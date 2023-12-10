import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ToUppercaseDecorator extends InputStreamDekorator {
    public ToUppercaseDecorator(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public int read() {
        try {
            return Character.toUpperCase(super.inputStream.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
