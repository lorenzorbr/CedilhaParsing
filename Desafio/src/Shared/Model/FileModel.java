package Shared.Model;

import Shared.Constants.Constants;

import java.util.ArrayList;

public class FileModel {
    private Sale biggestSale = null;

    private int qtdCorruptedLines  = 0 ;

    private ArrayList<Salesman> salesmanList = new ArrayList<>();
    private ArrayList<Client> clientList = new ArrayList<>();
    private ArrayList<Sale> saleList = new ArrayList<>();

    public void setBiggestSale(Sale biggestSale){
        if(this.biggestSale == null || this.biggestSale.getSaleValue() < biggestSale.getSaleValue())
            this.biggestSale = biggestSale;
    }

    public Sale getBiggestSaleInfo(){
        return biggestSale;
    }

    public void incrementCorruptedLines(){
        qtdCorruptedLines++;
    }

    public ArrayList<Salesman> getSalesmanList() {
        return salesmanList;
    }

    public ArrayList<Client> getClientList() {
        return clientList;
    }

    public ArrayList<Sale> getSaleList() {
        return saleList;
    }

    public String toString(){
        StringBuilder print = new StringBuilder();
        print.append(Constants.PRINT.CORRUPTED_LINE);
        print.append(qtdCorruptedLines);

        print.append(Constants.PRINT.SALES);
        print.append(printSaleList());

        print.append(Constants.PRINT.SALESMAN);
        print.append(printSalesmanList());

        print.append(Constants.PRINT.CLIENT);
        print.append(printClientList());

        print.append(Constants.PRINT.INFO);
        print.append(getInfoOfSales());

        return print.toString();
    }

    private String getWorstSalesman(){
        double biggest = 0;
        String name = "";
        for(Sale sale: saleList){
            if (biggest == 0){
                biggest = sale.getSaleValue();
                name = sale.getNome();
            }
            else if(sale.getSaleValue() > biggest) {
                biggest = sale.getSaleValue();
                name = sale.getNome();
            }
        }
        return name;
    }

    private String getInfoOfSales(){
        String qtdClients = "\n\n Clients Quantity: " + getClientList().size() + "\n" ;
        String qtdSalesman = " Salesman Quantity: " + getSalesmanList().size() + "\n";
        String mostExpensiveSaleID = " Most Expensive Sale ID: " + getBiggestSaleInfo().getSaleId() + "\n";
        String worstSalesman = " Worst Salesman: " + getWorstSalesman();

        return (
                qtdClients +
                qtdSalesman+
                mostExpensiveSaleID+
                worstSalesman
        );
    }

    private String printSaleList() {
        StringBuilder print = new StringBuilder();
        for (Sale item: saleList){
            print.append(item);
        }
        return print.toString();
    }

    private String printSalesmanList(){
        StringBuilder print = new StringBuilder();
        for (Salesman item: salesmanList){
            print.append(item);
        }
        return print.toString();
    }

    private String printClientList(){
        StringBuilder print = new StringBuilder();
        for (Client item: clientList){
            print.append(item);
        }
        return print.toString();
    }
}
