/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myshopmana;
import java.util.Objects;
/**
 *
 * @author Admin
 */
public class DataUser {
    private String firstName,lastName,DOB,email,phoneNum,usertype;
    private String userName,password;
    private String id;
    private double salary;
    //private int id;
    public DataUser(String id,String userName,String password,String usertype,String DOB,
            String firstName,String lastName,String phoneNum,String email,double salary){
        this.id = id;
        this.DOB = DOB;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.userName = userName;
        this.password = password;
        this.usertype = usertype;
        this.salary = salary;
    }
    public DataUser(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getDOB() {
        return DOB;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUsertype() {
        return usertype;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataUser)) return false;
        DataUser staffData = (DataUser) o;
        return Objects.equals(userName, staffData.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
