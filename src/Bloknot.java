import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;


public class Bloknot {
    public static void main(String[] args) {
        System.out.println("Записная книга \n");
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("1.Создать новую запись.\n2.Посмотреть записи.\n3.Закрыть программу.\n");

            System.out.println("Выберите одну из команд: ");

            int team;
            do {
                try {
                    team = Integer.parseInt(reader.readLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Введите число");
                }
            } while (true);

            String dateTime = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a")
                    .format(LocalDateTime.now());


            if (team == 1) {
                System.out.println("Новая запись: ");
                String record = reader.readLine();
                try (BufferedWriter wr = new BufferedWriter(new FileWriter("file.txt", true))) {
                    wr.write(record + "      " + dateTime);

                }
            }
            if (team == 2) {
                System.out.println("Просмотр записей: ");
                BufferedReader rid = new BufferedReader(new FileReader("file.txt"));
                String line;
                int s = 1;

                while ((line = rid.readLine()) != null) {
                    System.out.println(s + ". " + line);
                    s++;
                }
            }


            if (team == 3) {
                System.exit(0);
            }
        }
    }
}
// trow Exception ---- обработать исключения FileWriter, на отсутсвие файла