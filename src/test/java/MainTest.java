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
                "<b><font size=\"4\">伟大的标题</font></b>" +
                "啊" +
                "<font size=\"1\">哈哈哈1&gt;</font>" +
                "<font size=\"2\" align=\"center\">哈哈哈2 &gt; </font>" +
                "<font size=\"3\" align=\"right\" style=\"small\">哈哈哈3 &gt; </font>" +
                "<b><font>哈哈哈4 &gt; </font></b>" +
                "<b><font style=\"small\">~~~嘻嘻嘻</font></b>" +
                "<u><font size=\"5\">哈哈哈5 &gt; </font></u></job>";
        EscPos pos = new EscPos();
        byte bytes[] = pos.parse(text);
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/fireflyc/DataHD/test.pos");
        fileOutputStream.write(bytes);
    }
}
