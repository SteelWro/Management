package entity.parser;

import entity.Enum.SkinType;

public class BootsParser {
    public static SkinType strToBoots(String str){
        String boots = str.toUpperCase();
        if(boots.equals("NATURAL")){
            return SkinType.NATURAL;
        }else if(boots.equals("ARTIFICIAl")){
            return SkinType.ARTIFICIAL;
        }
        return SkinType.DEFAULT;
    }
}
