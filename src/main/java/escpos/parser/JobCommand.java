package escpos.parser;

import org.dom4j.Element;

/**
 * User: xingsen
 * Date: 14-4-22
 * Time: 下午12:17
 */
public class JobCommand extends Command {
    @Override
    public String tag() {
        return "job";
    }

    @Override
    protected byte[] end(Element self) {
        return new byte[]{'\n', '\n', '\n', '\n', '\n', 0x1D, 0x56, 0};
    }

    @Override
    protected byte[] start(Element self) {
        return new byte[]{};
    }


}
