package Shared.Transformer;

import Shared.Constants.Constants;
import Shared.Model.Client;

public class ClientTransformer {
    public static Client transform(String line){
        String[] data = line.split(Constants.VALIDATE.DELIMITER);
        return new Client(
                data[1],
                ComponentsTransformer.makeName(data,2,data.length),
                makeBusinessArea(data,  2)
        );

    }

    private static String makeBusinessArea(String [] data, int begin){
        int index = -1;
        for(int x = begin; x < data.length; x++) {
            if (x > begin) {
                if (Character.isUpperCase(data[x].charAt(0))) {
                    index = x;
                    continue;
                }
            }
        }
        return ComponentsTransformer.makeName(data, index, data.length);
    }
}
