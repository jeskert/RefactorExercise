import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTester {
    private FileReader _input;

    @Before
    public void setUp() {
        try {
            _input = new FileReader("data.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("unable to open test file");
        }
    }

    @Test
    public void testRead() throws IOException {
        char ch = '&';
        for (int i = 0; i < 4; i++) {
            ch = (char) _input.read();
        }
        assert ('d' == ch);
    }

    @After
    public void tearDown() {
        try {
            _input.close();
        } catch (IOException e) {
            throw new RuntimeException("error on closing test file");
        }
    }

}
