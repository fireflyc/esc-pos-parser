package escpos.parser;

import org.dom4j.Element;

/**
 * User: xingsen
 * Date: 14-4-25
 * Time: 下午2:47
 */
public class BoldCommand extends Command {
    @Override
    public String tag() {
        return "b";
    }

    @Override
    protected byte[] end(Element self) {
        return new byte[]{0x1B, 0x45, 0x0, '\n'};
    }

    @Override
    protected byte[] start(Element self) {
        return new byte[]{0x1B, 0x45, 0x1};
    }
}
