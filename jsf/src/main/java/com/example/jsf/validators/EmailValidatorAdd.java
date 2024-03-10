package com.example.jsf.validators;

import com.example.jsf.services.EmployeeService;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator("emailValidatorAdd")
public class EmailValidatorAdd implements Validator {


    private Pattern pattern;
    private  Matcher matcher;
    private EmployeeService employeeService=new EmployeeService();





    @Override
        public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {




            String value=o.toString();

            pattern = Pattern.compile("^\\w+@[a-zA-Z]+\\.[a-zA-Z]+$");
            matcher=pattern.matcher(value);
            if(!matcher.find()){
                FacesMessage facesMessage =new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "Invalid format\nExample: email@gmail.com");
                throw new ValidatorException(facesMessage);
            }else {

                if(employeeService.checkAddEmployee(value)){

                    FacesMessage facesMessage =new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "Email already exists");
                    throw new ValidatorException(facesMessage);
                }

            }

        }

}
