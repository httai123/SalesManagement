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
import java.util.Objects;

public class SoldProduct {
    private Product product;
    private int quantitySold;
    private double totalSales;
    public SoldProduct(Product product,int quantitySold,double totalSales){
        this.product = product;
        this.quantitySold = quantitySold;
        this.totalSales = totalSales;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SoldProduct)) return false;
        SoldProduct that = (SoldProduct) o;
        return Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }
}

