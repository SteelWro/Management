package Enum;

public enum Colors {
    BLACK("#000000"),WHITE("#FFFFFF"),RED("#FF0000"),GREEN("008000"),BLUE("#0000FF"),YELLOW("#FFFF00");

    String hexColor;

    Colors(String hexColor){
        this.hexColor = hexColor;
    }

    String getHEX(){
        return hexColor;
    }
}
