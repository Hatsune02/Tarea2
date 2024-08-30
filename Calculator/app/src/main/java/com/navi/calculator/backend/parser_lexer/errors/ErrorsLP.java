package com.navi.calculator.backend.parser_lexer.errors;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import lombok.*;


public class ErrorsLP {
    private static ArrayList<TError> errors = new ArrayList<>();

    public static ArrayList<TError> getErrors(){
        return errors;
    }
    public static void addError(String lexeme, int line, int col, String type, String description){
        errors.add(new TError(lexeme, line, col, type, description));
    }

    public static void clearErrors(){
        errors.clear();
    }


}
