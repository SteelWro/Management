package entity.parser;

import entity.Enum.Material;

public class ClothParser {
    public static Material getCloth(String str){
        if(str.equals("LEATHER")){
            return Material.LEATHER;
        }if(str.equals("FUR")){
            return Material.FUR;
        }if(str.equals("COTTON")){
            return Material.COTTON;
        }if(str.equals("WOOL")){
            return Material.WOOL;
        }if(str.equals("POLYESTER")){
            return Material.POLYESTER;
        }
        return Material.DEFAULT;
    }
}
