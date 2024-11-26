<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $inputLeader = trim($_POST["leader"]);
    $xml = simplexml_load_file("leaders.xml");

    echo "<h1>Search Results</h1>";

    foreach ($xml->leader as $leader) {
        $name = (string)$leader->name;
        $achievement = (string)$leader->achievement;

        if ($name == $inputLeader) {
            echo "<p><strong>Name:</strong> $name</p>";
            echo "<p><strong>Achievement:</strong> $achievement</p>";
            break;
        }
    }
}
?>
