import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * User: xingsen
 * Date: 14-4-22
 * Time: 下午12:17
 */
public class MainTest {
    @Test
    public void testCommand() throws IOException {

        String text = "<job>" +
                "<center>啊1</center>" +
                "啊" +
                "<size1>哈哈哈 &gt; </size1></job>";
        EscPos pos = new EscPos();
        byte bytes[] = pos.parse(text);
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/fireflyc/DataHD/test.pos");
        fileOutputStream.write(bytes);
    }
}
