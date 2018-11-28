package entity.parser;

import entity.Enum.Colors;

public class ColorParser {
    public static Colors strToColor(String str) {
        String color = str.toUpperCase();
        if ("RED".equals(color)) {
            return Colors.RED;
        } else if ("GREEN".equals(color)) {
            return Colors.GREEN;
        } else if ("BLUE".equals(color)) {
            return Colors.BLUE;
        } else if ("WHITE".equals(color)) {
            return Colors.WHITE;
        } else if ("BLACK".equals(color)) {
            return Colors.BLACK;
        } else if ("YELLOW".equals(color)) {
            return Colors.YELLOW;
        }
        return Colors.DEFAULT;
    }
}
