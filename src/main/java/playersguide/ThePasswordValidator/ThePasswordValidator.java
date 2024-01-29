package playersguide.ThePasswordValidator;

import java.util.Scanner;

public class ThePasswordValidator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PasswordValidator validator = new PasswordValidator(new char[]{'T', '&'}, 6, 13);

        while (true) {
            System.out.print("Please enter a password you want to validate: ");
            String password = input.next();
            if (password.equals("exit")) break;
            String validated = validator.validatePassword(password) ? "This is a valid password" : "This is an invalid password";
            System.out.println(validated);
        }
    }
}
