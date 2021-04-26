package validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator implements IValidator{
    @Override
    public boolean check(String inputString) {
        return isWhitespace(inputString) && isLetter(inputString)
                && checkOperands(inputString) && checkForParentheses(inputString);
    }

    private boolean isWhitespace(String inputString) {
        if (inputString.chars().noneMatch(Character::isWhitespace)) {
            return true;
        }
        else System.out.println("Expression cannot have spaces");
        return false;
    }

    private boolean isLetter(String inputString) {
        if (inputString.chars().noneMatch(Character::isLetter)) {
            return true;
        }else System.out.println("Expression cannot contain letters");
        return false;
    }

    private boolean checkOperands(String inputString) {
        String operands = inputString.replaceAll("[0-9.]","");
        for (int i = 0; i < operands.length(); i++) {
            String expectedOperand = String.valueOf(operands.charAt(i));
            if (!validOperation(expectedOperand)) {
                System.out.println("Expression can only contain numbers, operators, and parentheses");
                return false;
            }
        }
        if (countNumbers(inputString) - operands.length() != 1) {
            System.out.println("Сan be no more operands than numbers");
            return false;
        }
        return true;
    }

    private boolean checkForParentheses(String inputString) {
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
                return true;
        }
        return false;
    }

    private int countNumbers(String input) {
        Pattern p = Pattern.compile("\\d+(\\.\\d*)?");
        Matcher m = p.matcher(input);
        final List<String> numbers = new ArrayList<>();
        while (m.find()) {
            numbers.add(m.group());
        }
        return numbers.size();
    }
}
