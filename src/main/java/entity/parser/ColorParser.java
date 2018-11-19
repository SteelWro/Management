package entity.parser;

import entity.Enum.Colors;

public class ColorParser {
    static Colors getColor(String str) {
        if ("RED".equals(str)) {
            return Colors.RED;
        } else if ("GREEN".equals(str)) {
            return Colors.GREEN;
        } else if ("BLUE".equals(str)) {
            return Colors.BLUE;
        } else if ("BLUE".equals(str)) {
            return Colors.WHITE;
        } else if ("BLUE".equals(str)) {
            return Colors.BLACK;
        } else if ("BLUE".equals(str)) {
            return Colors.YELLOW;
        }
        return Colors.DEFAULT;
    }
}
