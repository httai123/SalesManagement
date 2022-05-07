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

import java.util.Objects;

public class Product {
    private String productID;
    private String productName;
    private String productUnit;
    private String productCategory;
    private int price;
    private int quantity;

    public Product() {
    }

    public Product(String productID, String productName, String productUnit,
                   String productCategory, int price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.productUnit = productUnit;
        this.quantity = quantity;
        this.price = price;
        this.productCategory = productCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(productID, product.productID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID);
    }
}
