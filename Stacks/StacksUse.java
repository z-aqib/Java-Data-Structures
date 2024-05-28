package Stacks;

public class StacksUse {

    public boolean validate(String expression) {
        StacksArray stack = new StacksArray(expression.length());
        for (int index = 0; index < expression.length(); index++) {
            char symbol = expression.charAt(index);
            if (symbol == '(' || symbol == '{' || symbol == '[') {
                stack.push(symbol);
            } else if (symbol == ')' || symbol == '}' || symbol == ']') {
                if (stack.isEmpty() == true) {
                    return false;
                }
                char stackLast = (char) stack.pop();
                if (((symbol == ')' && stackLast == '(') || (symbol == '}' && stackLast == '{')
                        || (symbol == ']' && stackLast == '[')) == false) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public String infixToPostfix(String infix) {
        String postfix = "";
        StacksArray<Character> operatorStack = new StacksArray<>(infix.length());
        for (int index = 0; index < infix.length(); index++) {
            char symbol = infix.charAt(index);
            if (Character.isLetterOrDigit(symbol) == true) {
                postfix += symbol; // if its a operand, put directly into output
            } else if (symbol == '(') {
                operatorStack.push(symbol);
            } else if (symbol == ')') {
                // so i will pop everything until i get the bracket
                while (operatorStack.isEmpty() == false && operatorStack.peek() != '(') {
                    postfix += operatorStack.pop();
                }
                // now, if i get the bracket, i will remove it
                if (operatorStack.isEmpty() == false && operatorStack.peek() == '(') {
                    operatorStack.pop(); // Discard the '('
                }
            } else if (symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/') {
                // now if i get a symbol, i will pop and add to output until precdence is met
                while (operatorStack.isEmpty() == false
                        && (precedence(symbol) <= precedence(operatorStack.peek()))) {
                    postfix += operatorStack.pop();
                }
                operatorStack.push(symbol);
            }
        }
        while (operatorStack.isEmpty() == false) {
            postfix += operatorStack.pop();
        }
        return postfix;
    }

    private int precedence(char operator) {
        switch (operator) {
            case '+', '-' -> {
                return 1;
            }
            case '*', '/' -> {
                return 2;
            }
        }
        return 0; // Default precedence for non-operators
    }

    public double evaluatePostFix(String expression, int opA_value, int opB_value, int opC_value) {
        StacksArray<Double> stacklist = new StacksArray<>(expression.length());
        for (int i = 0; i < expression.length(); i++) {
            Character symbol = expression.charAt(i);
            if (Character.isLetter(symbol) == true) {
                switch (symbol) {
                    case 'A' ->
                        stacklist.push((double) opA_value);
                    case 'B' ->
                        stacklist.push((double) opB_value);
                    case 'C' ->
                        stacklist.push((double) opC_value);
                }
            } else if (symbol != ' ') {
                Double op1 = stacklist.pop();
                Double op2 = stacklist.pop();
                stacklist.push(computeOperation(op1, op2, symbol));
            }
        }
        return stacklist.pop();
    }

    private double computeOperation(Double op1, Double op2, char symbol) {
        double result = 0.0;
        if (op1 != null && op2 != null) {
            switch (symbol) {
                case '+' ->
                    result = op1 + op2;
                case '*' ->
                    result = op2 * op1;
                case '/' ->
                    result = op1 / op2;
                case '-' ->
                    result = op1 - op2;
            }
        }
        return result;
    }

}
