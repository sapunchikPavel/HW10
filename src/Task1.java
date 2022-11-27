import java.util.Scanner;
import java.util.function.Predicate;

public class Task1 {
    public static void main(String[] args) {
        boolean isCorrectIp = false;
        Scanner scanner = new Scanner(System.in);
        String ipAddress;
        Predicate<String> ipV4 = (ip -> {
            String[] partsOfIp = ip.split("\\.");
            if (partsOfIp.length == 4) {
                for (String part : partsOfIp) {
                    try {
                        int num = Integer.valueOf(part);
                        if (!(num > 0 && num < 255)) {
                            return false;
                        }
                    } catch (NumberFormatException ex) {
                        return false;
                    }
                }
            } else {
                return false;
            }
            return true;
        });

        while (!isCorrectIp) {
            System.out.println("Введите Ip");
            ipAddress = scanner.nextLine();
            if (ipV4.test(ipAddress)) {
                System.out.println("Ip = " + ipAddress);
                isCorrectIp = true;
            } else {
                System.out.println("Ip неверный. Попробуйте еще раз");
            }
        }
    }
}
