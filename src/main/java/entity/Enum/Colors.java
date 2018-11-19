package entity.Enum;

public enum Colors {
    BLACK("#000000"),WHITE("#FFFFFF"),RED("#FF0000"),GREEN("008000"),BLUE("#0000FF"),YELLOW("#FFFF00"),DEFAULT("#ABCDEF");

    String hexColor;

    Colors(String hexColor){
        this.hexColor = hexColor;
    }

    public String getHEX(){
        return hexColor;
    }
}
