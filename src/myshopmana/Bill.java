/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myshopmana;

import java.util.ArrayList;

public class Bill {
    private String billID;
    private String cashierID;
    private String date;
    public Bill(String billID, String cashierID, String date){
        this.billID = this.billID;
        this.cashierID = this.cashierID;
        this.date = date;
    }

    public String getBillID() {
        return billID;
    }

    public String getCashierID() {
        return cashierID;
    }

    public String getDate() {
        return date;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public void setCashierID(String id) {
        this.cashierID = id;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

