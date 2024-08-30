package com.navi.calculator.backend;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.navi.calculator.backend.parser_lexer.*;
import com.navi.calculator.backend.parser_lexer.errors.ErrorsLP;

import java.io.Reader;
import java.io.StringReader;

import lombok.Getter;

public class Compile {

    private static double result;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void compile (String text){
        try{
            Reader reader = new StringReader(text);
            Lexer lexer = new Lexer(reader);
            Parser parser = new Parser(lexer);
            try{
                ErrorsLP.getErrors().clear();
                parser.parse();
                result = parser.result;
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        if(ErrorsLP.getErrors().isEmpty()){

        }
    }

    public static double getResult(){
        return result;
    }
}
