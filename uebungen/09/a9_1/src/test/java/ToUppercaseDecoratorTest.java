import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToUppercaseDecoratorTest {
    @Test
    void testToUppercaseDecorator() throws IOException {
        String input = "hello";
        String expected = "HELLO";
        InputStream inputStream = new ToUppercaseDecorator(new ByteArrayInputStream(input.getBytes()));
        String actual = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        assertEquals(expected, actual);
    }

}