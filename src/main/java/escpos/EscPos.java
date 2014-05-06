package escpos;

import escpos.parser.*;
import org.apache.commons.codec.binary.Base64;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * User: xingsen
 * Date: 14-4-22
 * Time: 下午12:20
 */
public class EscPos {
    private Map<String, Command> commandMap = new HashMap<String, Command>();

    public EscPos() {
        addCommand(new JobCommand());
        addCommand(new UnderlineCommand());
        addCommand(new BoldCommand());
        addCommand(new FontCommand());

        addCommand(new BrCommand());
        addCommand("p", new BrCommand());
    }

    public void addCommand(Command command) {
        commandMap.put(command.tag(), command);
    }

    public void addCommand(String tag, Command command) {
        commandMap.put(tag, command);
    }

    public byte[] parse(String text) {
        try {
            Document document = DocumentHelper.parseText(text);
            ByteArrayOutputStream cmds = new ByteArrayOutputStream();
            Element root = document.getRootElement();
            Command cmd = commandMap.get(root.getName());
            if (cmd != null) {
                cmds.write(cmd.parse(commandMap, root));
            }
            return cmds.toByteArray();
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String parseAsString(String text) throws UnsupportedEncodingException {
        return new String(parse(text), "GBK");
    }

    public String parseAsBase64(String text) throws UnsupportedEncodingException {
        return Base64.encodeBase64String(parse(text));
    }
}
