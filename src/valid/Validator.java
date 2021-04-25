package valid;

public class Validator implements IValidator {
    @Override
    public boolean check(String inputString) {
        if (isWhitespace(inputString) && isLetter(inputString)
                && checkOperands(inputString) && checkTheFirstOperand(inputString)
                && checkTheLastOperand(inputString) && сheckForParentheses(inputString)) return true;
        System.out.println("The expression is not correct");
        return false;
    }

    private boolean isWhitespace(String inputString) {
        return inputString.chars().noneMatch(Character::isWhitespace);
    }

    private boolean isLetter(String inputString) {
        return inputString.chars().noneMatch(Character::isLetter);
    }

    private boolean checkOperands(String inputString) {
        String operands = inputString.replaceAll("[0-9.]","");
        for (int i = 0; i < operands.length(); i++) {
            String expectedOperand = String.valueOf(operands.charAt(i));
            if (!validOperation(expectedOperand)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkTheFirstOperand(String inputString) {
        return Character.isDigit(inputString.charAt(0)) || validOperation(String.valueOf(inputString.charAt(0)));
    }

    private boolean checkTheLastOperand(String inputString) {
        return Character.isDigit(inputString.charAt(inputString.length() - 1)) || validOperation(String.valueOf((inputString.charAt(inputString.length() - 1))));
    }

    private boolean сheckForParentheses(String inputString) {
        int firstParentheses = 0;
        int secondParentheses = 0 ;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == '(') firstParentheses+= 1;
            if (inputString.charAt(i) == ')') secondParentheses+= 1;
        }
        if (firstParentheses - secondParentheses == 0) return true;
        else System.out.println("found unclosed parentheses"); return false;
    }

    private boolean validOperation(String operation) {
        switch (operation) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "(":
            case ")":
                return true;
        }
        return false;
    }
}
