package calc;

import priorityOfOperands.Priority;

public class Calculator implements ICalculator, Priority {
    @Override
    public double calculate(String inputString) {
        return 0;
    }

    @Override
    public int getPriority(char token) {
        return 0;
    }
}
