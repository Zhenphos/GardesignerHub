//import java.awt.image.BufferedImage;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.net.URLConnection;
//
//import javax.imageio.ImageIO;
//import javax.json.Json;
//import javax.json.JsonObject;
//import javax.json.JsonReader;
//import javax.swing.ImageIcon;
//import javax.swing.JOptionPane;
//
//public class ImagePicker {
//
//    public static void main(String[] args) {
//        try{
//            URL url = new URL("https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=Godfather");
//            URLConnection connection = url.openConnection();
//      
//            String line;
//            StringBuilder builder = new StringBuilder();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            while((line = reader.readLine()) != null) {
//                builder.append(line);
//            }
//            System.out.println("reader");
//            JsonReader jsonReader = Json.createReder(reader);
////
////            JsonObject json = new JsonObject(builder.toString());
////            String imageUrl = json.getJsonObject("responseData").getJsonArray("results").getJsonObject(0).getString("url");
////
////            BufferedImage image = ImageIO.read(new URL(imageUrl));
////            JOptionPane.showMessageDialog(null, "", "", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(image));
//        } catch(Exception e){
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Failure", JOptionPane.ERROR_MESSAGE);
//            e.printStackTrace();
//        }
//    }
//}