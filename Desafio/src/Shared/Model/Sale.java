package Shared.Model;

import Shared.Constants.Constants;

import java.util.ArrayList;

public class Sale {
    private String saleId;
    private ArrayList<SaleInfo> saleInfo = new ArrayList<>();
    private String nome;

    private double totalPrice;

    public Sale(String saleId, ArrayList<SaleInfo> saleInfo, String nome) {
        this.saleId = saleId;
        this.saleInfo = saleInfo;
        this.nome = nome;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTotalPrice(){
        for(SaleInfo s: saleInfo){
            totalPrice += s.getValue();
        }
        return totalPrice;
    }

    public double getSaleValue(){
        double value = 0;

        for(SaleInfo item : saleInfo){
            value += item.getValue();
        }
        return value;
    }


    @Override
    public String toString(){
        return "\n\n SaleID: "+  saleId + "\n Sale Info:  " + saleInfoToString() + "\n Nome: " + getNome() +"\n Total Price Of The Sale: " + getTotalPrice()+"\n";
    }

    public String saleInfoToString(){
        StringBuilder print = new StringBuilder();
        for(SaleInfo sale: saleInfo){
            print.append(sale.toString());
        }
        return print.toString();
    }
}
