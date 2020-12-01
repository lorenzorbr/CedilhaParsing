package Shared.Util;

import Shared.Constants.Constants;
import Shared.Model.FileModel;
import Shared.Validate.ValidateFileChanges;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class ScanUtil {

    public List<String> read(String filename) {
        List<String> data = new ArrayList<>();
        try{
            File archive = new File(Constants.SCAN.PATH_IN +"\\"+ filename);
            Scanner input= new Scanner(archive);
            FileModel obj = new FileModel();
            while(input.hasNext()){
                data.add(input.nextLine());
            }
            input.close();
            if(ValidateFileChanges.hasChanged(filename, data)) {
                return data;
            }
        } catch (FileNotFoundException e) {
            System.out.println(Constants.SCAN.ERROR_READ + filename);
        }
        return null;
    }

    public void write(String fileName, String content){
        try {
            deleteFile(fileName);
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(getRootProjectFolder()+"\\"+Constants.SCAN.PATH_OUT+"\\"+fileName, true)));
            writer.print(content);
            writer.close();
        } catch (IOException e) {
            System.out.println(Constants.SCAN.ERROR_WRITE + fileName);
        }
    }

    public ArrayList<String> listFiles() {
        File folder = new File(getRootProjectFolder()+"\\"+Constants.SCAN.PATH_IN);
        File[] listOfFiles = folder.listFiles();

        ArrayList<String> fileNames = new ArrayList<>();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && listOfFiles[i].getName().contains(".txt")){
                fileNames.add(listOfFiles[i].getName());
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
        return fileNames;
    }



    private String getRootProjectFolder(){
        return FileSystems.getDefault().getPath("").toAbsolutePath().toString();
    }

    private void deleteFile(String fileName)throws IOException{
        Files.walk(Paths.get(getRootProjectFolder() + "\\" + Constants.SCAN.PATH_OUT ))
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach((File file) ->{
                    if(file.getName().equals(fileName))
                        file.delete();
                });
    }
}
