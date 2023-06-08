import java.io.*;
import java.util.ArrayList;

public class Bloknot {
    public static void main(String[] args) throws IOException {
        System.out.println("Записная книга \n");
        while (true) {

             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("1.Создать новую запись.\n2.Посмотреть записи.\n3.Закрыть программу.\n");

                System.out.println("Выберите одну из команд: ");

                String team = reader.readLine();
                int nTeam = Integer.parseInt(team);

                if (nTeam == 1) {
                    System.out.println("Новая запись: ");
                    String record = reader.readLine();
                   try ( BufferedWriter wr = new BufferedWriter(new FileWriter("file.txt", true))) {
                    wr.write(record + "\n");
                   }
                }
                if (nTeam == 2) {
                    System.out.println("Просмотр записей: ");
                    BufferedReader rid = new BufferedReader(new FileReader("file.txt"));
                    String line;
                    int s = 1;

                    while ((line = rid.readLine()) != null) {
                        System.out.println(s + ". " + line);
                        s++;
                    }
                }

                if (nTeam == 3) {
                    System.exit(0);
                }
        }
    }
}