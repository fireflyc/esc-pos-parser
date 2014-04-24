package escpos.parser;

/**
 * User: xingsen
 * Date: 14-4-22
 * Time: 下午1:28
 */
public class CenterCommand extends Command {
    @Override
    public String tag() {
        return "center";
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
