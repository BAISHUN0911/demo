package org.example.infrastructure.time;

import lombok.NoArgsConstructor;
import org.example.infrastructure.time.util.ArithHelper;

import java.util.Collections;
import java.util.Stack;

/**
 * 字符串格式：1000 * 60 * 60 1小时 3600000ms 转为时间
 * 支持表达式格式为 x + (x+x*x) / x - x 类似的格式
 *
 * @Author BAISHUN
 * @Date: 2024/6/3 17:18
 */
@NoArgsConstructor
public class ExpressionToTime {
    private Stack<String> postfixStack = new Stack();
    private Stack<Character> opStack = new Stack();
    private int[] operatPriority = new int[]{0, 3, 2, 1, -1, 1, 0, 2};

    public static void main(String[] args) {
        String exp = "1000 * 60 * 60";
        String exp2 = "4 + (4 + 4 * 4) / 4 - 5";

        Double conversion = conversion(exp2);
        System.out.println(conversion);
    }

    private static Double conversion(String exp) {
        exp = exp.replaceAll(" ", "");
        double result = 0.0;
        exp = transform(exp);
        ExpressionToTime obj = new ExpressionToTime();
        return obj.calculate(exp);
    }

    private double calculate(String exp) {
        Stack<String> resultStack = new Stack<>();
        this.prepare(exp);
        // 表达式要从左到右计算，将 目标栈 翻转，然后依次弹栈
        Collections.reverse(this.postfixStack);
        while(!this.postfixStack.isEmpty()) {
            String currentValue = (String)this.postfixStack.pop();
            if (!this.isOperator(currentValue.charAt(0))) {
                currentValue = currentValue.replace("~", "-");
                resultStack.push(currentValue);
            } else {
                String secondValue = (String)resultStack.pop();
                String firstValue = (String)resultStack.pop();
                firstValue = firstValue.replace("~", "-");
                secondValue = secondValue.replace("~", "-");
                String tempResult = this.calculate(firstValue, secondValue, currentValue.charAt(0));
                resultStack.push(tempResult);
            }
        }

        return Double.valueOf((String)resultStack.pop());
    }

    private String calculate(String firstValue, String secondValue, char currentOp) {
        String result = "";
        switch (currentOp) {
            case '*':
                result = String.valueOf(ArithHelper.mul(firstValue, secondValue));
                break;
            case '+':
                result = String.valueOf(ArithHelper.add(firstValue, secondValue));
            case ',':
            case '.':
            default:
                break;
            case '-':
                result = String.valueOf(ArithHelper.sub(firstValue, secondValue));
                break;
            case '/':
                result = String.valueOf(ArithHelper.div(firstValue, secondValue));
        }

        return result;
    }

    private void prepare(String exp) {
        this.opStack.push(',');
        char[] arr = exp.toCharArray();
        int currentIndex = 0;
        int count = 0;

        for(int i = 0; i < arr.length; ++i) {
            char currentOp = arr[i];
            if (this.isOperator(currentOp)) {
                if (count > 0) {
                    this.postfixStack.push(new String(arr, currentIndex, count));
                }

                char peekOp = (Character)this.opStack.peek();
                if (currentOp == ')') {
                    while((Character)this.opStack.peek() != '(') {
                        this.postfixStack.push(String.valueOf(this.opStack.pop()));
                    }

                    this.opStack.pop();
                } else {
                    while(currentOp != '(' && peekOp != ',' && this.compare(currentOp, peekOp)) {
                        this.postfixStack.push(String.valueOf(this.opStack.pop()));
                        peekOp = (Character)this.opStack.peek();
                    }

                    this.opStack.push(currentOp);
                }

                count = 0;
                currentIndex = i + 1;
            } else {
                ++count;
            }
        }

        if (count > 1 || count == 1 && !this.isOperator(arr[currentIndex])) {
            this.postfixStack.push(new String(arr, currentIndex, count));
        }

        while((Character)this.opStack.peek() != ',') {
            this.postfixStack.push(String.valueOf(this.opStack.pop()));
        }
    }

    private boolean compare(char cur, char peek) {
        boolean result = false;
        if (this.operatPriority[peek - 40] >= this.operatPriority[cur - 40]) {
            result = true;
        }

        return result;
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
    }

    private static String transform(String exp) {
        char[] arr = exp.toCharArray();

        for(int i = 0; i < arr.length; ++i) {
            if (arr[i] == '-') {
                if (i == 0) {
                    arr[i] = '~';
                } else {
                    char c = arr[i - 1];
                    if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == 'E' || c == 'e') {
                        arr[i] = '~';
                    }
                }
            }
        }

        if (arr[0] != '~' && arr[1] != '(') {
            return new String(arr);
        } else {
            arr[0] = '-';
            return "0" + new String(arr);
        }
    }
}
