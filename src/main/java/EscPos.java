import escpos.parser.CenterCommand;
import escpos.parser.Command;
import escpos.parser.JobCommand;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
        addCommand(new CenterCommand());
    }

    public void addCommand(Command command) {
        commandMap.put(command.tag(), command);
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
}
