package org.example;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;


public class MyLex {
    private String input;  // 输入字符串
    private int pos = 0;  // 当前字符的位置
    private char currentChar;  // 当前字符
    // 使用 Map 来存储关键字和它们的词法记号
    private Map<String, Integer> keywordMap = new HashMap<>();

    public MyLex(String input) {
        this.input = input;
        currentChar = input.charAt(pos);

        // 初始化关键字和对应的词法记号
        keywordMap.put("for", 1);
        keywordMap.put("if", 2);
        keywordMap.put("then", 3);
        keywordMap.put("else", 4);
        keywordMap.put("while", 5);
        keywordMap.put("do", 6);
        keywordMap.put("until", 29);
        keywordMap.put("int", 30);
        keywordMap.put("input", 31);
        keywordMap.put("output", 32);
        keywordMap.put("#", 0);
    }

    // 获取下一个字符
    private void nextChar() {
        pos++;
        if (pos >= input.length()) {
            currentChar = '\0';  // End of input
        } else {
            currentChar = input.charAt(pos);
        }
    }

    // 跳过空白字符
    private void skipWhitespace() {
        while (Character.isWhitespace(currentChar)) {
            nextChar();
        }
    }

    // 词法分析主方法
    public List<Word> analyze() {
        List<Word> tokens = new ArrayList<>();  // 保存词法单元的列表

        while (currentChar != '\0') {  // 处理所有字符
            skipWhitespace();  // 跳过空白字符

            if (Character.isLetter(currentChar)) {  // 处理标识符或关键字
                StringBuilder id = new StringBuilder();
                while (Character.isLetterOrDigit(currentChar)) {
                    id.append(currentChar);
                    nextChar();
                }
                String identifier = id.toString();
                // 如果是关键字
                if (keywordMap.containsKey(identifier)) {
                    tokens.add(new Word(keywordMap.get(identifier), identifier));
                } else {  // 否则是标识符
                    tokens.add(new Word(10, identifier));
                }
            } else if (Character.isDigit(currentChar)) {  // 处理数字
                int num = 0;
                while (Character.isDigit(currentChar)) {
                    num = num * 10 + (currentChar - '0');
                    nextChar();
                }
                tokens.add(new Word(11, String.valueOf(num)));
            } else {  // 处理运算符和分隔符
                switch (currentChar) {
                    case '+': tokens.add(new Word(13, "+")); break;
                    case '-': tokens.add(new Word(14, "-")); break;
                    case '*': tokens.add(new Word(15, "*")); break;
                    case '/': tokens.add(new Word(16, "/")); break;
                    case ':':
                        nextChar();
                        if (currentChar == '=') {
                            tokens.add(new Word(18, ":="));
                        } else {
                            tokens.add(new Word(17, ":"));
                        }
                        break;
                    case '<':
                        nextChar();
                        if (currentChar == '>') {
                            tokens.add(new Word(21, "<>"));
                        } else if (currentChar == '=') {
                            tokens.add(new Word(22, "<="));
                        } else {
                            tokens.add(new Word(20, "<"));
                        }
                        break;
                    case '>':
                        nextChar();
                        if (currentChar == '=') {
                            tokens.add(new Word(24, ">="));
                        } else {
                            tokens.add(new Word(23, ">"));
                        }
                        break;
                    case '=': tokens.add(new Word(25, "=")); break;
                    case ';': tokens.add(new Word(26, ";")); break;
                    case '(': tokens.add(new Word(27, "(")); break;
                    case ')': tokens.add(new Word(28, ")")); break;
                    case '#': tokens.add(new Word(0, "#")); // 处理注释符号本身
                        // 跳过注释后的所有字符直到行结束
                        while (currentChar != '\0' && currentChar != '\n') {
                            nextChar();
                        } break;
                    default: System.out.println("Unrecognized symbol: " + currentChar); break;
                }
                nextChar();
            }
        }

        return tokens;  // 返回词法单元列表
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入MicroC代码：");
        String input = scanner.nextLine();  // 获取用户输入

        MyLex lexer = new MyLex(input);  // 创建词法分析器对象
        List<Word> tokens = lexer.analyze();  // 进行词法分析

        // 输出词法分析结果
        for (Word token : tokens) {
            System.out.println(token);
        }
    }
}
