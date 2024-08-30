package com.navi.calculator.backend.parser_lexer.errors;

import lombok.*;

@ToString
@NoArgsConstructor @AllArgsConstructor
public class TError {
    private String lexeme;
    private int line;
    private int column;
    private String type;
    private String description;

    public String getLexeme() {
        return lexeme;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
