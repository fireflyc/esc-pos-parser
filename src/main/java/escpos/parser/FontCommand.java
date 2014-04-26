package escpos.parser;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.dom4j.Attribute;
import org.dom4j.Element;

/**
 * User: xingsen
 * Date: 14-4-22
 * Time: 下午3:49
 */
public class FontCommand extends Command {
    @Override
    public String tag() {
        return "font";
    }

    @Override
    protected byte[] end(Element self) {
        return new byte[]{0x1D, 0x21, 0x0};//恢复正常0
    }

    @Override
    protected byte[] start(Element self) {
        Attribute sizeAttr = self.attribute("size");
        byte size = 1;
        if (sizeAttr != null) {
            size = NumberUtils.toByte(sizeAttr.getStringValue(), (byte) 1);
        }
        size = (byte) (size - 1); //从0开始
        if (size > 7) { //最大值为7放大8倍
            size = 7;
        }
        byte h = (byte) (size << 4); //高4位
        byte sizeByte = (byte) (h | size); //合并
        //用增加空格的方式居中或左对齐
        //数字行宽 48
        //汉字行宽 24
        //总行宽=字节数 * 24
        Attribute alignAttr = self.attribute("align");
        String text = self.getTextTrim();
        //最大行宽 48
        int maxWidth = 48;
        if (text.getBytes().length < maxWidth) {
            if (alignAttr != null && StringUtils.isNotEmpty(alignAttr.getText())) {
                if (alignAttr.getText().equalsIgnoreCase("center")) {
                    text = PadUtils.center(text, maxWidth, ' ');
                    self.setText(text);
                }
                if (alignAttr.getText().equalsIgnoreCase("right")) {
                    text = PadUtils.leftPad(text, maxWidth, ' ');
                    self.setText(text);
                }
            }
        }
        //设置字体大小、对齐方式
        return new byte[]{0x1D, 0x21, sizeByte};
    }

}
