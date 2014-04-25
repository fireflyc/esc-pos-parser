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
        return new byte[]{0x1B, 0x64, 0x09, 0x1B, 0x64, 0x02}; //走纸 9+2分两次
    }

    @Override
    protected byte[] start(Element self) {
        return new byte[]{};
    }


}
