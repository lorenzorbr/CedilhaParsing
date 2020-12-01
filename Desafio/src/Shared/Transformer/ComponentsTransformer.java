package Shared.Transformer;

public class ComponentsTransformer {
    public static String makeName(String[] data, int begin, int end) {
        StringBuilder nome = new StringBuilder();
        for(int x = begin; x < end; x++) {
            if (x > begin) {
                if (Character.isUpperCase(data[x].charAt(0))  || Character.isDigit(data[x].charAt(0))) {
                    return nome.toString();
                }
                nome.append("ç");
            }
            nome.append(data[x]);
        }
        return nome.toString();
    }



}
