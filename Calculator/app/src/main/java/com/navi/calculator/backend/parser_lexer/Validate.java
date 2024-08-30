package com.navi.calculator.backend.parser_lexer;

import java.util.HashMap;

public class Validate {
    private static HashMap<String, String> SYMBOL_NAMES;

    public static HashMap<String, String> getSymbolNames(){
        if(SYMBOL_NAMES == null) {
            SYMBOL_NAMES = new HashMap<>();
            SYMBOL_NAMES.put("LPAREN", "(");
            SYMBOL_NAMES.put("RPAREN", ")");
            SYMBOL_NAMES.put("PLUS", "+");
            SYMBOL_NAMES.put("MINUS", "-");
            SYMBOL_NAMES.put("DIVISION", "/");
            SYMBOL_NAMES.put("TIMES", "*");
            SYMBOL_NAMES.put("DIGIT", "Un número");
        }
        return SYMBOL_NAMES;
    }
}
