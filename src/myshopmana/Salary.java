/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myshopmana;

/**
 *
 * @author Admin
 */
public class Salary {
    private String id;
    private String name;
    private double basicSalary;
    private int totalSales;
    private double additions;
    private double totalSalary;
    public Salary(String id,String name,double basicSalary,int totalSales,double additions){
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
        this.totalSales = totalSales;
        this.additions = additions;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getID(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setBasicSalary(double salary){
        this.basicSalary = salary;
    }
    public Double getBasicSalary(){
        return basicSalary;
    }
    public void setAddiitions(double add){
        this.additions = add;
    }
    public Double getAdditions(){
        return additions;
    }
    public void setTotalSales(int total){
        this.totalSales = total;
    }
    public int getToTalSales(){
        return totalSales;
    }
    public void setTotalSalary(double total){
        this.totalSalary = total;
    }
    public double getTotalSalary(){
        return getAdditions() + getBasicSalary();
    }
}
