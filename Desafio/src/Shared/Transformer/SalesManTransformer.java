package Shared.Transformer;

import Shared.Constants.Constants;
import Shared.Model.Salesman;

public class SalesManTransformer {
    public static Salesman transform(String line){
        String[] data = line.split(Constants.VALIDATE.DELIMITER);
        return new Salesman(
                data[1],
                ComponentsTransformer.makeName(data,2,data.length),
                Double.parseDouble(data[data.length-1])
        );
    }
}
