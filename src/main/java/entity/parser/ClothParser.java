package entity.parser;

import entity.Enum.Material;

public class ClothParser {
    public static Material strToCloth(String str){
        String cloth = str.toUpperCase();
        if(cloth.equals("LEATHER")){
            return Material.LEATHER;
        }if(cloth.equals("FUR")){
            return Material.FUR;
        }if(cloth.equals("COTTON")){
            return Material.COTTON;
        }if(cloth.equals("WOOL")){
            return Material.WOOL;
        }if(cloth.equals("POLYESTER")){
            return Material.POLYESTER;
        }
        return Material.DEFAULT;
    }

//    public static Material toCloth(Material material){
//        if(material.toString().equals("LEATHER")){
//            return Material.LEATHER;
//        }if(material.toString().equals("FUR")){
//            return Material.FUR;
//        }if(material.toString().equals("COTTON")){
//            return Material.COTTON;
//        }if(material.toString().equals("WOOL")){
//            return Material.WOOL;
//        }if(material.toString().equals("POLYESTER")){
//            return Material.POLYESTER;
//        }
//    }
}
