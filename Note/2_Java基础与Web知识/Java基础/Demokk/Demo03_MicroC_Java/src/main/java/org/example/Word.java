package org.example;

//单词
public class Word {
    public int token;   // 词法记号
    public String lexeme;  // 词法单元（标识符或操作符）

    public Word(int token, String lexeme) {
        this.token = token;
        this.lexeme = lexeme;
    }

    @Override
    public String toString() {
        return "(" + token + "," + lexeme + ")";
    }
}