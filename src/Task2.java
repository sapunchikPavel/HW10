import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream("D:\\Java\\Java.projects\\HomeWork\\HW10\\TestFile.txt"))) {
            StringBuilder plainText = new StringBuilder();
            while (reader.ready()) {
                plainText.append((char) reader.read());
            }
            HashMap<String, String> map = new HashMap<>();
            Pattern docPattern = Pattern.compile("[0-9]{4}-[0-9]{4}-[0-9]{2}");
            Pattern numberPattern = Pattern.compile("\\+\\(\\d{2}\\)\\d{7}");
            Pattern emailPattern = Pattern.compile("[A-z][\\w\\.]+@[a-z]+\\.[a-z]{2}");

            Matcher numberMatcher = numberPattern.matcher(plainText);
            Matcher emailMatcher = emailPattern.matcher(plainText);
            Matcher docMatcher = docPattern.matcher(plainText);

            if (docMatcher.find(0)) {
                map.put("doc", docMatcher.group());
            }
            if (emailMatcher.find(0)) {
                map.put("email", emailMatcher.group());
            }
            if (numberMatcher.find(0)) {
                map.put("number", numberMatcher.group());
            }

            System.out.println(map);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
