package escpos.parser;

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
    protected byte[] end() {
        return new byte[]{0x1B, 0x64, 0x09, 0x1B, 0x64, 0x02}; //走纸 9+2分两次
    }

    @Override
    protected byte[] start() {
        return new byte[]{0x1B, 0x40};//重置打印机状态
    }


}
