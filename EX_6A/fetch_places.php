<?php

$host = 'localhost'; 
$dbname = 'facts_of_india'; 
$username = 'root'; 
$password = '';


try {
    $conn = new PDO("mysql:host=$host;dbname=$dbname", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    
    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        $city = trim($_POST['city']); 

        
        $stmt = $conn->prepare("SELECT best_places FROM cities WHERE city_name = :city");
        $stmt->bindParam(':city', $city, PDO::PARAM_STR);
        $stmt->execute();

        
        if ($stmt->rowCount() > 0) {
            $result = $stmt->fetch(PDO::FETCH_ASSOC);
            $places = $result['best_places'];
            echo "<div class='result'>";
            echo "<h2>Best Places in " . htmlspecialchars($city) . ":</h2>";
            echo "<p>" . htmlspecialchars($places) . "</p>";
            echo "</div>";
        } else {
            echo "<div class='result'>";
            echo "<h2>No results found for " . htmlspecialchars($city) . ".</h2>";
            echo "</div>";
        }
    }
} catch (PDOException $e) {
    echo "Error: " . $e->getMessage();
}


$conn = null;
?>
