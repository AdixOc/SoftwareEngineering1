import java.io.InputStream;

public abstract class InputStreamDekorator extends InputStream {
    final InputStream inputStream;

    public InputStreamDekorator(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public abstract int read();
}
