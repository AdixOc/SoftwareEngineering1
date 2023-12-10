import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Your Mom is fucking Gay bro".getBytes(StandardCharsets.UTF_8));
        InputStream uppercaseInputStream = new ToUppercaseDecorator(byteArrayInputStream);

        String text = new BufferedReader(
                new InputStreamReader(uppercaseInputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));

        System.out.println(text);
    }
}
