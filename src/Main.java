import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Записная книга \n");
        ArrayList<String> list = new ArrayList<>();
        while (true) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("1.Создать новую запись.\n2.Посмотреть записи.\n3.Закрыть программу.\n");

            System.out.println("Выберите одну из команд: ");

            String team = reader.readLine();
            int nTeam = Integer.parseInt(team);

            if (nTeam == 1) {
                System.out.println("Новая запись: ");
                String record = reader.readLine();
                list.add(record);
            }
            if (nTeam == 2) {
                System.out.println("Просмотр записей: ");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                }


            }
            if (nTeam == 3) {
                System.exit(0);
            }


        }
    }
}