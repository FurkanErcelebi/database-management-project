package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Student implements IDBOperation{
    private int recordId;
    private Date createdDateTime;
    private Date modifiedDateTime;
    private String identityNum;
    private String name;
    private String surname;
    private int age;
    private String phone;
    private String emergencyPhone;
    private String email;
    private String address;

    private Connection con = null;
    private Statement statement = null;

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Date getModifiedDateTime() {
        return modifiedDateTime;
    }

    public void setModifiedDateTime(Date modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }

    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean Insert() {

        StringBuilder sql = new StringBuilder();
             sql.append( "INSERT INTO STUDENT ");
             sql.append( "(NAME, SURNAME,IDENTITY_NUM, AGE, PHONE, EMERGENY_PHONE, EMAIL, ADDRESS)");
             sql.append(name);
             sql.append(",");
             sql.append(surname);
             sql.append(",");
             sql.append(identityNum);
             sql.append(",");
             sql.append(age);
             sql.append(",");
             sql.append(phone);
             sql.append(",");
             sql.append(emergencyPhone);
             sql.append(",");
             sql.append(email);
             sql.append(",");
             sql.append(address);

        try {
            statement =  con.createStatement();
            boolean result = statement.execute(sql.toString());
            return result;
        } catch (SQLException throwables) {
            return false;
        }
    }

    @Override
    public boolean Update() {
        StringBuilder sql = new StringBuilder();
        sql.append( "UPDATE STUDENT SET ");
        sql.append( "NAME = ");
        sql.append(name);
        sql.append(",");
        sql.append("SURNAME = ");
        sql.append(surname);
        sql.append(",");
        sql.append("IDENTITY_NUM = ");
        sql.append(identityNum);
        sql.append(",");
        sql.append("AGE = ");
        sql.append(age);
        sql.append(",");
        sql.append("PHONE = ");
        sql.append(phone);
        sql.append(",");
        sql.append("EMERGENY_PHONE = ");
        sql.append(emergencyPhone);
        sql.append(",");
        sql.append("EMAIL = ");
        sql.append(email);
        sql.append(",");
        sql.append("ADDRESS = ");
        sql.append(address);

        try {
            statement =  con.createStatement();
            boolean result = statement.execute(sql.toString());
            return result;
        } catch (SQLException throwables) {
            return false;
        }
    }

    @Override
    public boolean Delete() {
        String sql = "DELETE FROM STUDENT WHERE RECORD_ID = " + recordId;
        try {
            statement =  con.createStatement();
            boolean result = statement.execute(sql.toString());
            return result;
        } catch (SQLException throwables) {
            return false;
        }
    }


    @Override
    public boolean Load(int recordId) {
        String sql = "SELECT * FROM STUDENT WHERE RECORD ID = " + recordId;
        try {
            statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if(result != null){
                LoadFromResultSet(result);
                return true;
            }
        } catch (SQLException throwables) {
                return false;
        }


        return false;
    }


    public void LoadFromResultSet(ResultSet rs){
        if(rs == null)
            return;
        try{
            while(rs.next()) {
                recordId = rs.getInt("RECORD_ID");
                identityNum = rs.getString("IDENTITY_NUM");
                name = rs.getString("NAME");
                surname = rs.getString("SURNAME");
                age = rs.getInt("AGE");
                phone = rs.getString("PHONE");
                emergencyPhone = rs.getString("EMERGENCY_PHONE");
                email = rs.getString("EMAIL");
                address = rs.getString("ADDRESS");
            }
        }catch(Exception ex){
                return;
            }

    }
}
