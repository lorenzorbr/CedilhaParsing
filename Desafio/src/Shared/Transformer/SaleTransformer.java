package Shared.Transformer;

import Shared.Constants.Constants;
import Shared.Model.Sale;
import Shared.Model.SaleInfo;

import java.util.ArrayList;

public class SaleTransformer {
    public static Sale transform(String line){
        String[] data = line.split(Constants.VALIDATE.DELIMITER);
        return new Sale(
                data[1],
                makeSaleInfo(data[2]),
                ComponentsTransformer.makeName(data, data.length-1, data.length)
        );

    }

    private static ArrayList<SaleInfo> makeSaleInfo(String data) {
        ArrayList <SaleInfo> salesList = new ArrayList<>();
        data = data.substring(1,data.length()-1);// remove colchetes
        String [] items = data.split(",");
        String[] item;
        for(String s : items){
            item = s.split("-");
            salesList.add(new SaleInfo(item[0], item[1], item[2]));
        }
        return salesList;
    }

}
