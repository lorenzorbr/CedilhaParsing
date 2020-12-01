package Shared.Validate;

import Shared.Constants.Constants;
import Shared.Model.SaleInfo;

public class ValidateLine {
    public static boolean validate(String item){
        String[] data = item.split(Constants.VALIDATE.DELIMITER);
        if(data.length>3) {
            switch (data[0]) {
                case Constants.ID_TEXT.SALESMAN:
                    return validateSalesMan(data);
                case Constants.ID_TEXT.CLIENT:
                    return validateClient(data);
                case Constants.ID_TEXT.SALE:
                    return validateSale(data);
                default:
                    return false;
            }
        }else{
            return false;
        }
    }

    private static boolean validateSalesMan(String[] data){
        return (
                ValidateCPF.isCPF(data[1]) &&
                ValidateValue.validateValue(data[data.length-1], Constants.REGEX.DOUBLE) &&
                validateName(data,2,data.length)
        );
    }

    private static boolean validateClient(String[] data){
        return(
                ValidateCNPJ.isCNPJ(data[1]) &&
                validateBusinessArea(data,  2) &&
                validateName(data,2,data.length)
        );
    }

    private static boolean validateSale(String[] data){
        return (
                ValidateValue.validateSaleID(data[1]) &&
                validateSaleInfo(data[2]) &&
                validateName(data, data.length-1, data.length)
        );
    }

    private static boolean validateName(String[] data, int begin, int end) {
        StringBuilder nome = new StringBuilder();
        for(int x = begin; x < end; x++) {
            if (x > begin) {
                if (Character.isUpperCase(data[x].charAt(0))  || Character.isDigit(data[x].charAt(0))) {
                    continue;
                }
                nome.append("ç");
            }
            nome.append(data[x]);
        }
        return (nome.length()>0);
    }

    private static boolean validateSaleInfo(String data) {
        data = data.substring(1,data.length()-1);// tira : []
        String [] items = data.split(",");
        SaleInfo item;
        for(String s : items){
            if(!validateSaleSpecifics(s.split("-"))){
                return false;
            }
        }
        return true;
    }

    private static boolean validateSaleSpecifics(String[] splitted) {
        return (
                splitted.length==3 &&
                ValidateValue.validateValue(splitted[0], Constants.REGEX.INTEGER) &&
                ValidateValue.validateValue(splitted[1], Constants.REGEX.INTEGER) &&
                ValidateValue.validateValue(splitted[2], Constants.REGEX.DOUBLE)
        );
    }

    private static boolean validateBusinessArea(String [] data, int begin){
        int index = -1;
        for(int x = begin; x < data.length; x++) {
            if (x > begin) {
                if (Character.isUpperCase(data[x].charAt(0))) {
                    index = x;
                    continue;
                }
            }
        }
        if(index > 0)
            return validateName(data, index, data.length);
        return false;
    }
}
