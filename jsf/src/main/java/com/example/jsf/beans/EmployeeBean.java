package com.example.jsf.beans;

import com.example.jsf.models.Employee;
import com.example.jsf.services.EmployeeService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "employeeBean")
@SessionScoped
public class EmployeeBean {




    public static int i=0;
    private  EmployeeService employeeService =new EmployeeService();
    private List<Employee> models=employeeService.getNextTen(i);
    private List<Employee> employees=employeeService.getAll();

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    private Employee employee;
    private boolean checkSubOne=!employeeService.checkSubOne(i);



    private boolean checkAddOne= employeeService.checkAddOne(i);
    private boolean addButton;

    public static  boolean searchButton;
    public   static String searchText;

    public    String tmpSearchText;

    public String getTmpSearchText() {
        return tmpSearchText;
    }

    public void setTmpSearchText(String tmpSearchText) {
        this.tmpSearchText = tmpSearchText;
    }

    public boolean isAddButton() {
        return addButton;
    }
    public boolean isCheckSubOne() {
        return checkSubOne;
    }

    public boolean isCheckAddOne() {

        return checkAddOne;
    }

    public void setModels(List<Employee> models) {
        checkSubOne=!employeeService.checkSubOne(i);
        checkAddOne= employeeService.checkAddOne(i);
        this.models = models;
    }
    public List<Employee> getModels() {
        return models;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void refreshModels(){
        setModels(employeeService.getNextTen(i));
    }

    public void addOneToI(){
        if((models.size()/7)>=i && !employeeService.checkDivision(i) ){
            i=i+1;
            refreshModels();
        }

    }
    public void subsOneToI(){
        if((models.size()/7)<=i )
            i=i-1;
        refreshModels();
    }
    public void lastPage(){
        i=employeeService.lastPage();
        refreshModels();
    }
    public void firstPage(){

        i=0;
        refreshModels();
    }


    public void deleteEmployee(int id){

        employeeService.deleteEmployee(id);
        if( (double)i==employeeService.checkLastPage() ){
            i--;}
        refreshModels();
    }


    public void updateEmployee(Employee employee){

        employeeService.updateEmployee(employee);
        deactivateEdit(employee);
    }

    public void deactivateEdit(Employee employee){
        refreshModels();
        employee.setEdit(false);

    }
    public void activateEditButton(Employee employee) {
        for(Employee employee1:models){
            employee1.setEdit(false);
        }
        employee.setEdit(true);
        this.employee = employee;

    }

    public boolean activateEdit(Employee employee) {
        return employee.isEdit();

    }

    public void  activateAddButton(){
        addButton=true;
        employee=new Employee();


    }
    public void  addEmployee(){
        employeeService.addEmployee(employee);
        refreshModels();
        deactivateAddButton();
    }
    public void  deactivateAddButton(){
        addButton=false;

    }



    public void deactivateSearchButton(){
        searchButton=false;
        tmpSearchText="";
        refreshModels();
    }
    public void activateSearchButton(){

        searchButton=true;
        searchText=tmpSearchText;
        firstPage();
    }




}





