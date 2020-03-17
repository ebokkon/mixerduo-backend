package com.codecool.mixerduo2.service;

import org.passay.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class SignUpValidator {

    private WhitespaceRule whitespaceRule = new WhitespaceRule();

    public boolean isValidPassword(String password) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(8, 30),
                new UppercaseCharacterRule(1),
                new DigitCharacterRule(1),
                new SpecialCharacterRule(1),
                whitespaceRule));

        RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }
        return false;
    }

    public boolean isValidUsername(String username) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(4, 30),
                whitespaceRule));

        RuleResult result = validator.validate(new PasswordData(username));
        if (result.isValid()) {
            return true;
        }
        System.out.println(WhitespaceRule.ERROR_CODE);
        return false;
    }

    public boolean isValidName(String name) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(1, 30),
                whitespaceRule));

        RuleResult result = validator.validate(new PasswordData(name));
        if (result.isValid()) {
            return true;
        }
        return false;
    }

    public boolean isValidEmail(String email){
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher isMatch = pattern.matcher(email);
        if (isMatch.matches()) {
            return true;
        }
        return false;
    }
}