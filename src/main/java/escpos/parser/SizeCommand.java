package escpos.parser;

/**
 * User: xingsen
 * Date: 14-4-22
 * Time: 下午3:49
 */
public class SizeCommand extends Command {
    @Override
    public String tag() {
        return "size";
    }

    @Override
    protected byte[] end() {
        return new byte[0];
    }

    @Override
    protected byte[] start() {
        return new byte[0];
    }
}
