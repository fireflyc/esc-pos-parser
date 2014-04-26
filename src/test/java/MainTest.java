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

        String text = "<job><font align=\"center\">xxxx公司小票</font>" +
                "<font align=\"right\">这个不会居中</font>" +
                "<p>今天天气如何啊？</p>"+
                "<u>还行不错</u>"+
                "<i>还行不错</i><br/><br/>"+
                "</job>";
        EscPos pos = new EscPos();
        byte bytes[] = pos.parse(text);
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\IdeaProjects\\test.pos");
        fileOutputStream.write(bytes);
    }
}
