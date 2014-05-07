import escpos.EscPos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * User: xingsen
 * Date: 14-4-22
 * Time: 下午12:17
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        String text = "<job>测试内容内容测试内容内容测试内容内容测试内容内容测试内容内容测试内容内容测试内容内容测试内容内容测试内容内容测试内容内容测试内容内容测试内容内容</job>";
        EscPos pos = new EscPos();
        String s = pos.parseAsBase64(text);
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/fireflyc/DataHD/test.pos");
        byte a[] = s.getBytes();
        fileOutputStream.write(a);
    }

    public static byte[] toGbk(String text) {
        Charset gbkCharset = Charset.forName("GBK");
        ByteBuffer buffer = gbkCharset.encode(CharBuffer.wrap(text));
        byte[] dst = new byte[buffer.remaining()];
        buffer.get(dst);
        return dst;
    }
}
