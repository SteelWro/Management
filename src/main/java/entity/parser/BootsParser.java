package entity.parser;

import entity.Enum.SkinType;

public class BootsParser {
    public SkinType getBoots(String str){
        if(str.equals("NATURAL")){
            return SkinType.NATURAL;
        }else if(str.equals("ARTIFICIAl")){
            return SkinType.ARTIFICIAL;
        }
        return SkinType.DEFAULT;
    }
}
