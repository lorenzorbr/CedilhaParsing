package Shared.Service;

import Shared.Constants.Constants;
import Shared.Model.Sale;
import Shared.Transformer.ClientTransformer;
import Shared.Transformer.SaleTransformer;
import Shared.Transformer.SalesManTransformer;
import Shared.Model.FileModel;
import Shared.Util.ScanUtil;
import Shared.Validate.ValidateLine;

import java.util.List;
//Service is where the business rules are, it reads the archives and verify its changes
public class MainService {

    public static void execute() {
        ScanUtil scan = new ScanUtil();
        while (true) {
            List<String> filesNames = scan.listFiles();
            percorreArquivos(filesNames, scan);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void percorreArquivos(List<String> filesNames, ScanUtil scan){
        for (String fileName : filesNames) {
            List<String> file = scan.read(fileName);
            if (file != null) {
                scan.write(
                        fileName,
                        geraArquivo(file, fileName).toString()
                );
            }
            else{
                System.out.println("Arquivo Inalterado: " + fileName);
            }
        }
    }

    private static FileModel geraArquivo(List<String> file, String fileName){
        FileModel model = new FileModel();
        for (String line : file) {
            if (ValidateLine.validate(line)) {
                model = incluiLinha(line, model);
            }
            else{
                model.incrementCorruptedLines();
                System.out.println("Arquivo: " + fileName + " possui a seguinte linha corrompida: " + line);
            }
        }
        return model;
    }

    private static FileModel incluiLinha(String line, FileModel model){
        String[] data = line.split(Constants.VALIDATE.DELIMITER);
        switch (data[0]) {
            case Constants.ID_TEXT.SALESMAN:
                model.getSalesmanList().add(SalesManTransformer.transform(line));
                break;
            case Constants.ID_TEXT.CLIENT:
                model.getClientList().add(ClientTransformer.transform(line));
                break;
            case Constants.ID_TEXT.SALE:
                Sale sale = SaleTransformer.transform(line);
                model.getSaleList().add(sale);
                model.setBiggestSale(sale);
                break;
        }
        return model;
    }
}
