package com.codecool.mixerduo2.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DataValidateService {

    public boolean isValid(String password, List<String> errorList){
        Pattern specialCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
        Pattern lowerCasePatten = Pattern.compile("[a-z ]");
        Pattern digitCasePatten = Pattern.compile("[0-9 ]");

        errorList.clear();

        boolean flag=true;

        if (password.length() < 8) {
            errorList.add(" 8 character");
            flag=false;
        }
        if (!specialCharPatten.matcher(password).find()) {
            errorList.add("one special character");
            flag=false;
        }
        if (!UpperCasePatten.matcher(password).find()) {
            errorList.add(" one uppercase character");
            flag=false;
        }
        if (!lowerCasePatten.matcher(password).find()) {
            errorList.add(" one lowercase character");
            flag=false;
        }
        if (!digitCasePatten.matcher(password).find()) {
            errorList.add(" one number");
            flag=false;
        }

        return flag;

    }

    public boolean isNotEmptyName(String name, List<String> errorList ){
        errorList.clear();
        if(name.length() != 0) {
            return true;
        } else {
            errorList.add("must be at least one character long");
            return false;
        }
    }


}
