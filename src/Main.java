import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        // Soal 1: Memasukan Object ke dalam array[Object]
        Mahasiswa[] mahasiswas = new Mahasiswa[2];
        mahasiswas[0] = new Mahasiswa("Budi", LocalDate.of(1999, 1, 1), "123456789");
        mahasiswas[1] = new Mahasiswa("Wati", LocalDate.of(1999, 12, 31), "987654321");

        // Soal 2: Menulis data ke dalam file profile.txt
        writeToFile(mahasiswas);

         // Soal 3: Membaca isi file profile.txt dan memasukkan hanya Nama saja ke dalam array[String]
        String[] names = readNamesFromFile();

        System.out.println("Output array nya:"+"\n"+Arrays.toString(names));
    }

    private static void writeToFile(Mahasiswa[] mahasiswas) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("profile.txt"))){
            for (Mahasiswa mahasiswa : mahasiswas) {
                writer.println(mahasiswa.toString());
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private static String[] readNamesFromFile() {
        ArrayList<String> namesList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("profile.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    namesList.add(parts[1]);
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        return namesList.toArray(new String[0]);
    }
}