package com.example.jsf.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.rmi.ServerException;
import java.sql.Date;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesConverter("dateConverter")
public class DateConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

        try {
            if(!s.isEmpty())
                return Date.valueOf(s);
            return null;
        } catch (Exception e) {

            throw new ConverterException(e);
        }

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {

        return o.toString();
    }

}
