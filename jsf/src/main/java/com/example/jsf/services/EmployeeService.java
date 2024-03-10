package com.example.jsf.services;

import com.example.jsf.beans.EmployeeBean;
import com.example.jsf.db.EmployeeDao;
import com.example.jsf.models.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    EmployeeDao employeeDao=new EmployeeDao();

    public void addEmployee(Employee employee) {
            if (!checkAddEmployee(employee.getEmail()))
                employeeDao.addEmployee(employee);

    }
    public boolean checkAddEmployee(String email) {

        return employeeDao.employeesExiste(email);
    }



    public void updateEmployee(Employee employee) {
            employeeDao.updateEmployee(employee);
    }

    public boolean checkUpdateEmployee(Employee employee) {
        return employeeDao.employeesExisteAfterUpdate(employee.getEmail()) != -1 && employeeDao.employeesExisteAfterUpdate(employee.getEmail()) != employee.getId();

    }

    public List<Employee> getAll(){
        if(EmployeeBean.searchButton){

            return employeeDao.getAll().stream().filter(employee -> employee.getName().contains(EmployeeBean.searchText)).collect(Collectors.toList());
        }
        return employeeDao.getAll();

    }

    public List<Employee> getNextTen(int i){


        return  getAll().subList(Math.max(7*i,0),Math.min(7*i+7, getAll().size()));

    }

    public boolean checkDivision(int i){

        return (getAll().size()==7*i+7);

    }


        public boolean checkSubOne(int i){

        return i==0;
    }
    public boolean checkAddOne(int i){
        if(getAll().size()==7 || (getAll().size()%7==0 && i+1==lastPage())) {
            return false;
        }
        return i < getAll().size()/7;
    }
    public int lastPage(){
        if(getAll().size()==7)
            return 0;
        return getAll().size()/7;
    }

    public double checkLastPage(){

        return (double) getAll().size() /7;
    }

    public void deleteEmployee(int id){

        employeeDao.deleteEmployee(id);
    }

}
