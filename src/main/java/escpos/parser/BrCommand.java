package escpos.parser;

import org.dom4j.Element;

/**
 * Created by Administrator on 2014/4/26.
 */
public class BrCommand extends Command {
    @Override
    public String tag() {
        return "br";
    }

    @Override
    protected byte[] end(Element self) {
        return new byte[]{'\n'};
    }

    @Override
    protected byte[] start(Element self) {
        return new byte[]{};
    }
}
