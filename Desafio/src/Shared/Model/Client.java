package Shared.Model;


import Shared.Constants.Constants;

public class Client {
    private String cnpj ;
    private String name ;
    private String businessArea;

    public Client(String cnpj, String name, String businessArea) {
        this.cnpj = cnpj;
        this.name = name;
        this.businessArea = businessArea;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "\n\n ID: " + Constants.ID_TEXT.CLIENT + "\n Client : " + name + "\n CNPJ: "+ cnpj + "\n BusinessArea: " + businessArea ;
    }
    
}
