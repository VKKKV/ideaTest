package atguigu.dataStructures.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created on 2022/6/6星期一12:45
 *
 * @author abc
 * <p>
 * 支持小数加减乘除括号消除空格
 */
public class PolandNotation {
    public static void main(String[] args) {
        //后缀表达式
//        String suffixExpression = "3 4 + 5 x 6 -";
//        List<String> rpnList = getListString(suffixExpression);
//        System.out.println(rpnList);
//        int res = calculate(rpnList);
//        System.out.println(res);
        //enter expression
        String expression = "14 +((24+34)x44)-5.1";

        List<String> ls = toInfixExpressionList(expression);
        System.out.println(ls);
        List<String> suf = parseSuffixExpressionList(ls);
        System.out.println(suf);
        double res = calculate(suf);
        System.out.println(res);


    }


    //中缀转后缀
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        Stack<String> s1 = new Stack<>();//符号栈
        List<String> s2 = new ArrayList<>();//数栈

        for (String item : ls) {
            if (item.matches("([1-9]\\d*\\.?\\d*)|(0\\.\\d*\\d)|(^\\d+$)")) {
                s2.add(item);

            } else if (item.equals("(")) {
                s1.push(item);

            } else if (item.equals(")")) {
                while (!s1.peek().equals("("))
                    s2.add(s1.pop());
                //消除小括号
                s1.pop();
            } else {
                while (s1.size() != 0 && getValue(s1.peek()) >= getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }

        while (s1.size() != 0) {
            s2.add(s1.pop());
        }

        return s2;
    }


    public static int getValue(String operation) {

        if (operation.equals("+") || operation.equals("-")) {
            return 1;
        } else if (operation.equals("x") || operation.equals("/")) {
            return 2;
        } else {
            return 0;
        }
    }


    //转中缀list
    public static List<String> toInfixExpressionList(String s) {

        s = s.replaceAll("\\s+", "");

        List<String> ls = new ArrayList<>();
        int i = 0;
        String str = "";
        char c;
        do {
            if (((s.charAt(i))!='.')&&((c = s.charAt(i)) < 48) || ((c = s.charAt(i)) > 57)) {
                if (!str.equals("")) {
                    ls.add(str);
                    str = "";
                }
                ls.add(c + "");
            } else {
                str += c;
            }
            //空指针
            if (i == s.length() - 1 && !str.equals("")) {
                ls.add(str);
                str = "";
            }
            i++;
        } while (i < s.length());
        return ls;
    }


//    public static List<String> getListString(String suffixExpression) {
//        String[] split = suffixExpression.split(" ");
//        List<String> list = new ArrayList<>();
//        Collections.addAll(list, split);
//        return list;
//    }

    public static double calculate(List<String> ls) {
        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            if (item.matches("([1-9]\\d*\\.?\\d*)|(0\\.\\d*\\d)|(^\\d+$)")) {
                stack.push(item);
            } else {
                double num2 = Double.parseDouble(stack.pop());
                double num1 = Double.parseDouble(stack.pop());
                double res = switch (item) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "x" -> num1 * num2;
                    case "/" -> num1 / num2;
                    default -> throw new RuntimeException("运算符错误");
                };
                stack.push(String.valueOf(res));
            }
        }
        return Double.parseDouble(stack.pop());
    }
}



