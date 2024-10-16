import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/places")
public class PlacesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String state = request.getParameter("state");
        String[] places;

        switch (state) {
            case "Tamil Nadu":
                places = new String[]{"Marina Beach", "Ooty", "Mahabalipuram", "Kodaikanal", "Meenakshi Temple", "Thanjavur Temple", "Nilgiri Mountain Railway", "Auroville", "Rameswaram", "Dindigul Fort"};
                break;
            case "Maharashtra":
                places = new String[]{"Gateway of India", "Ajanta Caves", "Ellora Caves", "Marine Drive", "Khandala", "Mahabaleshwar", "Lonavala", "Shivaji Park", "Bhandardara", "Tadoba Andhari Tiger Reserve"};
                break;
            case "Karnataka":
                places = new String[]{"Bangalore Palace", "Mysore Palace", "Hampi", "Coorg", "Chikmagalur Coffee Plantations", "Jog Falls", "Badami Caves", "Nandi Hills", "Ranganathaswamy Temple", "Sakleshpur"};
                break;
            case "Kerala":
                places = new String[]{"Alleppey Backwaters", "Munnar Tea Gardens", "Kumarakom Bird Sanctuary", "Athirappilly Waterfalls", "Wayanad Wildlife Sanctuary", "Fort Kochi", "Varkala Beach", "Thekkady", "Bolgatty Palace", "Kalady"};
                break;
            case "West Bengal":
                places = new String[]{"Victoria Memorial", "Howrah Bridge", "Darjeeling Tea Gardens", "Sundarbans National Park", "Kalimpong", "Dakshineswar Kali Temple", "Belur Math", "Bishnupur Temples", "Shantiniketan", "Murshidabad"};
                break;
            case "Rajasthan":
                places = new String[]{"Hawa Mahal", "Amber Fort", "Jaisalmer Fort", "Lake Pichola", "Jodhpur Blue City", "Pushkar Camel Fair", "Chittorgarh Fort", "Mount Abu", "Ranthambore National Park", "City Palace"};
                break;
            case "Gujarat":
                places = new String[]{"Gir National Park", "Rann of Kutch", "Somnath Temple", "Dwarka", "Sidi Saiyyed Mosque", "Sabarmati Ashram", "Akshardham Temple", "Statue of Unity", "Vadodara Palace", "Narmada Canal"};
                break;
            case "Uttar Pradesh":
                places = new String[]{"Taj Mahal", "Agra Fort", "Varanasi Ghats", "Sarnath", "Fatehpur Sikri", "Lucknow's Bara Imambara", "Kanpur Memorial Church", "Ganga Aarti", "Chunar Fort", "Mathura's Krishna Janmabhoomi"};
                break;
            case "Bihar":
                places = new String[]{"Bodh Gaya", "Nalanda University Ruins", "Rajgir", "Mahabodhi Temple", "Patna Sahib Gurudwara", "Vishwa Shanti Stupa", "Kushinagar", "Vaishali", "Gaya", "Sita Kund"};
                break;
            case "Punjab":
                places = new String[]{"Golden Temple", "Wagah Border", "Jallianwala Bagh", "Durgiana Temple", "Maharaja Ranjit Singh Museum", "Anandpur Sahib", "Gobind Sagar Lake", "Patiala's Qila Mubarak", "Ranjit Singh Panorama", "Sadda Pind"};
                break;
            case "Haryana":
                places = new String[]{"Kurukshetra", "Sohna", "Pinjore Gardens", "Gurgaon Cyber Hub", "Bhindawas Wildlife Sanctuary", "Panchkula", "Yamunanagar", "Tomb of Ibrahim Lodi", "Sultanpur National Park", "Manesar"};
                break;
            case "Odisha":
                places = new String[]{"Konark Sun Temple", "Jagannath Temple", "Chilika Lake", "Puri Beach", "Buddhist Monuments at Dhauli", "Udayagiri and Khandagiri Caves", "Nandankanan Zoo", "Simlipal National Park", "Mukteswara Temple", "Cuttack Dussehra"};
                break;
            case "Telangana":
                places = new String[]{"Hyderabad's Charminar", "Golconda Fort", "Hussain Sagar Lake", "Ramoji Film City", "Qutb Shahi Tombs", "Nehru Zoological Park", "Warangal Fort", "Buddha Purnima", "Kuntala Waterfalls", "Medak Cathedral"};
                break;
            case "Andhra Pradesh":
                places = new String[]{"Tirupati Temple", "Amaravati", "Visakhapatnam Beaches", "Vijayawada Kanaka Durga Temple", "Borra Caves", "Panchakona", "Horsley Hills", "Chandragiri Fort", "Kakinada Beach", "Nagarjuna Sagar Dam"};
                break;
            case "Himachal Pradesh":
                places = new String[]{"Shimla Ridge", "Manali Solang Valley", "Dharamshala", "Kullu Valley", "Spiti Valley", "Kinnaur", "Chamba", "Bir Billing", "Palampur Tea Gardens", "Khajjiar"};
                break;
            case "Jammu and Kashmir":
                places = new String[]{"Dal Lake", "Gulmarg Ski Resort", "Pahalgam", "Sonamarg", "Jammu's Vaishno Devi Temple", "Leh-Ladakh", "Shankaracharya Temple", "Betaab Valley", "Nubra Valley", "Mansar Lake"};
                break;
            case "Chhattisgarh":
                places = new String[]{"Chitrakote Waterfalls", "Kanger Valley National Park", "Bastar Dussehra", "Kanker Palace", "Jagdalpur", "Raipur", "Sirpur", "Tirathgarh Waterfalls", "Buddhist Monuments at Sirpur", "Amrit Dhara Waterfall"};
                break;
            case "Assam":
                places = new String[]{"Kaziranga National Park", "Assam State Museum", "Majuli Island", "Tea Gardens", "Nameri National Park", "Manas National Park", "Kamakhya Temple", "Sivasagar", "Guwahati", "Hajo"};
                break;
            case "Uttarakhand":
                places = new String[]{"Haridwar Ganga Aarti", "Rishikesh Laxman Jhula", "Nainital Lake", "Mussoorie", "Jim Corbett National Park", "Kedarnath", "Badrinath", "Auli Ski Resort", "Har Ki Pauri", "Pithoragarh"};
                break;
            case "Goa":
                places = new String[]{"Baga Beach", "Anjuna Beach", "Dudhsagar Waterfalls", "Fort Aguada", "Basilica of Bom Jesus", "Vagator Beach", "Palolem Beach", "Chapora Fort", "Mandrem Beach", "Cotigao Wildlife Sanctuary"};
                break;
            case "Madhya Pradesh":
                places = new String[]{"Khajuraho Temples", "Sanchi Stupa", "Pachmarhi", "Bandhavgarh National Park", "Kanha National Park", "Gwalior Fort", "Orchha", "Ujjain", "Mahakaleshwar Temple", "Rani Durgavati Palace"};
                break;
            default:
                places = new String[]{"No places available."};
                break;
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Best Tourist Places to Visit in " + state + ":</h2>");
        out.println("<ul>");
        for (String place : places) {
            out.println("<li>" + place + "</li>");
        }
        out.println("</ul>");
        out.println("<a href='index.html'>Go Back</a>");
        out.println("</body></html>");
    }
}
