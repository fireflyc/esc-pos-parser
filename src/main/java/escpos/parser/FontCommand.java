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
        return new byte[]{0x1D, 0x21, 0x0, '\n', 0x1B, 0x61, 0x0, 0x1D, 0x66, 0x0};//恢复正常0
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
        //对齐方式
        byte alignByte = 0x0;
        Attribute alignAttr = self.attribute("align");
        if (alignAttr != null && StringUtils.isNotEmpty(alignAttr.getText())) {
            if (alignAttr.getText().equalsIgnoreCase("center")) {
                alignByte = 0x1;
            }
            if (alignAttr.getText().equalsIgnoreCase("right")) {
                alignByte = 0x2;
            }
        }

        //字体样式
        byte fontStyle = 0x0;
        Attribute styleAttr = self.attribute("fstyle");
        if (styleAttr != null && StringUtils.isNotEmpty(styleAttr.getText())) {
            if (styleAttr.getText().equalsIgnoreCase("small")) {
                fontStyle = 0x1;
            }
        }
        //设置字体大小、对齐方式和字体样式
        return new byte[]{0x1D, 0x21, sizeByte, 0x1B, 0x61, alignByte, 0x1D, 0x66, fontStyle};
    }
}
