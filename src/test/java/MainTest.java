import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * User: xingsen
 * Date: 14-4-22
 * Time: 下午12:17
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        String text = "<job><font align=\"center\">xxxx公司小票</font>" +
                "<font align=\"right\">这个不会居中</font>" +
                "<font align=\"right\" fstyle=\"small\">这个不会居中,但是字体会不会小一些？</font>" +
                "<p>今天天气如何啊？</p>" +
                "<u>还行不错</u>" +
                "<i>还行不错</i>" +
                "我是小浩浩,我是一个小淘气，囧 o(╯□╰)o我是小浩浩,我是一个小淘气，囧 o(╯□╰)o我是小浩浩,我是一个小淘气，囧 o(╯□╰)o我是小浩浩,我是一个小淘气，囧 o(╯□╰)o我是小浩浩,我是一个小淘气，囧 o(╯□╰)o我是小浩浩,我是一个小淘气，囧 o(╯□╰)o我是小浩浩,我是一个小淘气，囧 o(╯□╰)o我是小浩浩,我是一个小淘气，囧 o(╯□╰)o我是小浩浩,我是一个小淘气，囧 o(╯□╰)o我是小浩浩,我是一个小淘气，囧 o(╯□╰)o我是小浩浩,我是一个小淘气，囧 o(╯□╰)o我是小浩浩,我是一个小淘气，囧 o(╯□╰)o我是小浩浩,我是一个小淘气，囧 o(╯□╰)o我是小浩浩,我是一个小淘气，囧 o(╯□╰)o<br/>" +
                "我是一只呼啦熊我是一只呼啦熊我是一只呼啦熊我是一只呼啦熊我是一只呼啦熊我是一只呼啦熊我是一只呼啦熊我是一只呼啦熊我是一只呼啦熊我是一只呼啦熊我是一只呼啦熊<br/><br/><br/><br/><br/><br/><br/>"+
                "</job>";
        EscPos pos = new EscPos();
        byte bytes[] = pos.parse(text);
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/fireflyc/DataHD/test.pos");
        fileOutputStream.write(bytes);
    }
}
