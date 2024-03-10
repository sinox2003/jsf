package com.example.jsf.db;

import com.example.jsf.models.Employee;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    Connection connection=SingleConnection.getConnection();

    public void addEmployee(Employee employee){

        try {
            PreparedStatement pst=connection.prepareStatement("insert into EMPLOYEE(NAME,DEPARTEMENT,EMAIL,BRTHD) values(?,?,?,?) ");
            pst.setString(1,employee.getName());
            pst.setString(2,employee.getDepartement());

            pst.setString(3,employee.getEmail());
            pst.setDate(4, (Date) employee.getBrthd());
            pst.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void updateEmployee(Employee employee){

        try {
            PreparedStatement pst=connection.prepareStatement("UPDATE EMPLOYEE SET NAME=?,DEPARTEMENT=?,EMAIL=?,BRTHD=? WHERE ID=? ");
            pst.setString(1,employee.getName());
            pst.setString(2,employee.getDepartement());

            pst.setString(3,employee.getEmail());
            pst.setDate(4, (Date) employee.getBrthd());
            pst.setInt(5,employee.getId());
            pst.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public boolean employeesExiste(String email) {



        try {
            PreparedStatement pst = connection.prepareStatement("select ID from EMPLOYEE where EMAIL=?  ");
            pst.setString(1, email);

            ResultSet rs = pst.executeQuery();
            if(rs.next()){

                return  true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public int employeesExisteAfterUpdate(String email) {

        int id=-1;
        try {
            PreparedStatement pst = connection.prepareStatement("select ID from EMPLOYEE where EMAIL=?  ");
            pst.setString(1, email);

            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                id=rs.getInt("ID");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public List<Employee> getAll(){

        List<Employee> employees=new ArrayList<>();

        try {
            PreparedStatement pst=connection.prepareStatement("select * from EMPLOYEE   ");

            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                employees.add(new Employee(rs.getInt("ID"),rs.getString("NAME"),rs.getString("DEPARTEMENT"),rs.getString("EMAIL"), rs.getDate("BRTHD")));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return employees;
    }

    public void deleteEmployee(int id){

        try {
            PreparedStatement pst=connection.prepareStatement("DELETE FROM EMPLOYEE WHERE ID=? ");
            pst.setInt(1,id);
            pst.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
