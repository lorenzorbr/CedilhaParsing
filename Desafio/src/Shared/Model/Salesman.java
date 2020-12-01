package Shared.Model;

public class Salesman {
    private String cpf ;
    private String name;
    private double salary;

    public Salesman(String cpf, String name, double salary){
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "\n\n CPF: " + cpf + "\n Name: " + name + "\n Salary: " + salary;
    }
}
