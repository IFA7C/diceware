import password.PasswordProvider;

import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        PasswordProvider passwordProvider = new PasswordProvider();
        Scanner scanner = new Scanner(System.in);
        String password;

        System.out.print("Teilanzahl des Passworts: ");
        String numberOfParts = scanner.nextLine();

        try {
            password = passwordProvider.getPassword(Integer.parseInt(numberOfParts));
            System.out.println(password);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}