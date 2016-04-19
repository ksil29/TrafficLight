import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ksil on 19.04.2016.
 */
public class TrafficLight {
    private static int duration;

    public static void main(String[] args) {
        readDuration();

        for (int i = 1; i <= duration; i++) {
            int check = i % 10;
            if (check >= 1 && check <= 2) {
                turnLight(Lights.GREEN);
            } else if (check >= 3 && check <= 5) {
                turnLight(Lights.YELLOW);
            } else {
                turnLight(Lights.RED);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {

            }
        }
    }

    private enum Lights {
        RED, YELLOW, GREEN;
    }

    private static void turnLight(Lights light) {
        System.out.println(light);
    }

    private static void readDuration() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите количество минут: ");
            while (true) {
                try {
                    duration = Integer.parseInt(reader.readLine());
                    if (duration < 0) {
                        System.out.println("Вы ввели отрицательное число. Попробуйте еще: ");
                        continue;
                    }
                    break;
                } catch (NumberFormatException ignore) {
                    System.out.println("Неверный ввод. Попробуйте еще: ");
                }
            }
            reader.close();
        } catch (IOException ignore) {

        }
    }
}
