import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        String filePath = "alert.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            Map<String, StringBuilder> institutions = new HashMap<>();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String institutionCode = parts[0];
                String port = parts[2];
                String status = parts[4].trim();

                StringBuilder message = institutions.getOrDefault(institutionCode, new StringBuilder());
                message.append("- Envi MP Port ").append(port).append(" terpantau ").append(status).append("\n");
                institutions.put(institutionCode, message);
            }


            for (Map.Entry<String, StringBuilder> entry : institutions.entrySet()) {
                String institutionCode = entry.getKey();
                String message = entry.getValue().toString();


                String outputMessage = getCustomizedMessage(institutionCode, message);
                System.out.println(outputMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String getCustomizedMessage(String institutionCode, String message) {
        switch (institutionCode) {
            case "MDR":
                return "Selamat Siang Rekan Bank Mandiri,\nMohon bantuan untuk Sign on pada envi berikut:\n" + message;
            case "BNI":
                return "Selamat Siang Rekan Bank BNI,\nMohon bantuan untuk Sign on pada envi berikut:\n" + message;
            default:
                return "Default message for unknown institution:\n" + message;
        }
    }
}