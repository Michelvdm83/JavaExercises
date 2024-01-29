package playersguide.ThePasswordValidator;

public class PasswordValidator {
    private final int MAX_LENGTH;
    private final int MIN_LENGTH;
    private final char[] ILLEGAL_CHARS;

    public PasswordValidator(char[] illegalChars, int minLength, int maxLength) {
        ILLEGAL_CHARS = illegalChars;
        MIN_LENGTH = minLength;
        MAX_LENGTH = maxLength;
    }

    public boolean validatePassword(String password) {
        if (password.length() < MIN_LENGTH || MAX_LENGTH < password.length()) {
            return false;
        }
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean number = false;
        for (char c : password.toCharArray()) {
            for (char ch : ILLEGAL_CHARS) {
                if (c == ch) {
                    return false;
                }
            }
            if (Character.isLowerCase(c)) {
                lowerCase = true;
            }
            if (Character.isUpperCase(c)) {
                upperCase = true;
            }
            if (Character.isDigit(c)) {
                number = true;
            }
        }
        return lowerCase && upperCase && number;
    }
}
