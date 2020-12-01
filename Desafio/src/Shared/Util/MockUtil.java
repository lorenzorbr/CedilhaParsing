package Shared.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockUtil {
    public static ArrayList<String> getArchiveLines(){
        ArrayList<String> linhas = new ArrayList<>();
        linhas.add("001ç79077247084çPedroç500001");
        linhas.add("001ç74496002000çPauloç40000.99");
        linhas.add("002ç18957217000150çJose da SilvaçRural");
        linhas.add("002ç41384680000171çEduardo PereiraçRural");
        linhas.add("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro");
        linhas.add("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo");
        linhas.add("002ç08ç[1-34-1kkk0,2-33-1.50,3-40-0.10]çPaulo");
        linhas.add("001ç08ç[1-34-10,2-33-1.50,3-40-0.10]aulo");
        return linhas;
    }

    public static String getClientSuccesLine(){
        return "002ç18957217000150çJose da SilvaçRural";
    }

    public static String getSalesmanSuccesLine(){
        return "001ç79077247084çPedroç500001";
    }

    public static String getSalesSuccesLine(){
        return "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo";
    }

    public static List<String> getCPFList(){
        return  Arrays.asList("09514950038", "41847968007","53417301009","123456772","11111111111");
    }

    public static List<String> getCNPJList(){
        return Arrays.asList("12629241000183", "49764974000130", "69886453000163","1111111","22222");
    }

    public static List<List<String>> getListFiles(){
        List<String> fileA = Arrays.asList(
                "001ç79077247084çPedroç500001",
                "001ç74496002000çPauloç40000.99",
                "002ç18957217000150çJose da SilvaçRural",
                "002ç41384680000171çEduardo PereiraçRural",
                "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro"
        );

        List<String> fileB = Arrays.asList(
                "001ç790773247084çPedroç500001",
                "001ç7443960402000çPauloç40000.99",
                "002ç189574217000150çJose da SilvaçRural",
                "002ç4138468004400171çEduardo PereiraçRural",
                "003ç10ç[41-10-100,2-30-2.50,3-40-3.10]çPedro"
        );
        return Arrays.asList(fileA,fileB);
    }

}
