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

public class BillDetails{
    private String billID;
    private Product product;
    private int amount;
    public BillDetails(String billID,Product product,int amount){
        this.billID = billID;
        this.product = product;
        this.amount = amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BillDetails)) return false;
        BillDetails that = (BillDetails) o;
        return Objects.equals(billID, that.billID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billID);
    }
}
