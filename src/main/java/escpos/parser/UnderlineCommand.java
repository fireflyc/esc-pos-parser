package escpos.parser;

import org.dom4j.Attribute;
import org.dom4j.Element;

/**
 * User: xingsen
 * Date: 14-4-25
 * Time: 下午2:50
 */
public class UnderlineCommand extends Command {
    @Override
    public String tag() {
        return "u";
    }

    @Override
    protected byte[] end(Element self) {
        return new byte[]{0x1B, 0x2D, 0};
    }

    @Override
    protected byte[] start(Element self) {
        byte style = 1;
        Attribute doubleUnderline = self.attribute("b");
        if (doubleUnderline != null) {
            style = 2;
        }
        return new byte[]{0x1B, 0x2D, style};
    }
}
