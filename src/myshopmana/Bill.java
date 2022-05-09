/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myshopmana;

import java.util.ArrayList;

public class Bill {
    private ArrayList<BillDetails> billDetails;
    private String customerID;
    private DataUser dataUsers;
    private String date;
    public Bill(ArrayList<BillDetails> billDetailses, String customerID, DataUser dataUsers, String date){
        this.customerID = customerID;
        this.billDetails = billDetailses;
        this.dataUsers = dataUsers;
        this.date = date;
    }

    public ArrayList<BillDetails> getBillDetails() {
        return billDetails;
    }

    public DataUser getDataUsers() {
        return dataUsers;
    }

    public String getDate() {
        return date;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setBillDetails(ArrayList<BillDetails> billDetails) {
        this.billDetails = billDetails;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setDataUsers(DataUser dataUsers) {
        this.dataUsers = dataUsers;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

