package escpos.parser;

import org.dom4j.Element;
import org.dom4j.tree.DefaultText;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * User: xingsen
 * Date: 14-4-22
 * Time: 下午12:15
 */
public abstract class Command {
    public abstract String tag();

    public byte[] toGbk(String text) {
        Charset gbkCharset = Charset.forName("GBK");
        ByteBuffer buffer = gbkCharset.encode(CharBuffer.wrap(text));
        byte[] dst = new byte[buffer.remaining()];
        buffer.get(dst);
        return dst;
    }

    public byte[] parse(Map<String, Command> commandMap, Element self) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(start(self));

        List content = self.content();
        for (Object child : content) {
            if (child instanceof Element) {
                Element element = (Element) child;
                Command cmd = commandMap.get(element.getName());
                if (cmd == null) {
                    //未知标签原样输出
                    writeText(outputStream, element.getText());
                } else {
                    outputStream.write(cmd.parse(commandMap, element));
                }
                continue;
            }
            if (child instanceof DefaultText) {
                DefaultText text = (DefaultText) child;
                writeText(outputStream, text.getText());
                continue;
            }
        }

        outputStream.write(end(self));
        return outputStream.toByteArray();
    }

    protected void writeText(ByteArrayOutputStream outputStream, String text) throws IOException {
        if (text != null && !text.equals("")) {
            outputStream.write(toGbk(text));
        }
    }

    protected abstract byte[] end(Element self);

    protected abstract byte[] start(Element self);
}
