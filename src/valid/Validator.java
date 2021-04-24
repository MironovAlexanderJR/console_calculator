package valid;

public class Validator implements IValidator {
    @Override
    public boolean check(String inputString) {
        return false;
    }

    private boolean ss(String inputString) {
        if (inputString.chars().anyMatch(Character::isWhitespace))
            return false;
        return true;
    }

}
