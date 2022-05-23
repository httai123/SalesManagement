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
    private String productName;
    private String productId;
    private double price;
    private int quantitySold;
    private double totalSales;
    public SoldProduct(String productId,String productName,double price, int quantitySold,double totalSales){
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantitySold = quantitySold;
        this.totalSales = totalSales;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
    public double getPrice() {
        return price;
    }

    public void setQPrice(double price) {
        this.price = price;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SoldProduct)) return false;
        SoldProduct that = (SoldProduct) o;
        return Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}

