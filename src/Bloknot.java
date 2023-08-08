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
    public static void main(String[] args) throws IOException {
        System.out.println("Записная книга \n");
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("1.Создать новую запись.\n2.Посмотреть записи.\n3. Изменить запись.\n4. Удалить запись.\n0.Закрыть программу.");

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
                    wr.write(record + "      " + dateTime + "\n");
                } catch (Exception e) {
                    System.out.println("Нет такого файла");
                    throw new FileNotFoundException();

                }
            }
            if (team == 2) {
                System.out.println("Просмотр записей: ");
               try (BufferedReader rid = new BufferedReader(new FileReader("file.txt"))) {

                   String line;
                   int s = 1;

                   while ((line = rid.readLine()) != null) {
                       System.out.println(s + ". " + line);
                       s++;
                   }
               } catch (Exception e) {
                   System.out.println("Нет такого файла");
                   throw new FileNotFoundException();
               }
            }

            if (team == 3) {
                System.out.println("Какую запись изменить: ");
                ArrayList<String> list = new ArrayList<>();

                try (BufferedReader rid = new BufferedReader(new FileReader("file.txt"))) {

                    String line;
                    int s = 1;

                    while ((line = rid.readLine()) != null) {
                        System.out.println(s + ". " + line);
                        s++;
                        list.add(line);
                    }
                } catch (Exception e) {
                    System.out.println("Нет такого файла");
                    throw new FileNotFoundException();
                }

                int change = Integer.parseInt(reader.readLine());
                change--;
                String record = reader.readLine();
                list.set(change,record);
                BufferedWriter wr = new BufferedWriter(new FileWriter("file.txt"));

                for (String nov : list) {
                    wr.write(nov + "   " + dateTime + "\n");
                }
                wr.close();
            }

            if (team == 4) {
                System.out.println("Какую запись удалить: ");
                ArrayList<String> list = new ArrayList<>();

                try (BufferedReader rid = new BufferedReader(new FileReader("file.txt"))) {

                    String line;
                    int s = 1;

                    while ((line = rid.readLine()) != null) {
                        System.out.println(s + ". " + line);
                        s++;
                        list.add(line);
                    }
                } catch (Exception e) {
                    System.out.println("Нет такого файла");
                    throw new FileNotFoundException();
                }
                int delete = Integer.parseInt(reader.readLine());
                delete--;
                list.remove(delete);
                BufferedWriter wr = new BufferedWriter(new FileWriter("file.txt"));

                for (String nov : list) {
                    wr.write(nov + "   " + dateTime + "\n");
                }
                wr.close();
            }
            if (team == 0) {
                System.exit(0);
            }
        }
    }
}

//Добавить пункт под номером 3 для изменения записей