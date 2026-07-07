package bank;

import java.util.Scanner;

public class InputValidator {

    // Read integer
    public static int getInt(Scanner sc, String message) {

        int value;

        while (true) {

            System.out.print(message);

            if (sc.hasNextInt()) {

                value = sc.nextInt();
                sc.nextLine();

                if (value > 0) {
                    return value;
                }

                System.out.println("Value must be greater than 0.");

            } else {

                System.out.println("Please enter a valid number.");
                sc.nextLine();
            }
        }
    }

    // Read decimal number
    public static double getDouble(Scanner sc, String message) {

        double value;

        while (true) {

            System.out.print(message);

            if (sc.hasNextDouble()) {

                value = sc.nextDouble();
                sc.nextLine();

                if (value >= 0) {
                    return value;
                }

                System.out.println("Value cannot be negative.");

            } else {

                System.out.println("Please enter a valid amount.");
                sc.nextLine();
            }
        }
    }

    // Read text
    public static String getString(Scanner sc, String message) {

        String value;

        while (true) {

            System.out.print(message);

            value = sc.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("This field cannot be empty.");
        }
    }

    // Read phone number
    public static String getPhone(Scanner sc) {

        String phone;

        while (true) {

            System.out.print("Phone Number: ");

            phone = sc.nextLine().trim();

            if (phone.matches("\\d{10}")) {
                return phone;
            }

            System.out.println("Phone number must contain exactly 10 digits.");
        }
    }

    // Read email
    public static String getEmail(Scanner sc) {

        String email;

        while (true) {

            System.out.print("Email: ");

            email = sc.nextLine().trim();

            if (email.contains("@") && email.contains(".")) {
                return email;
            }

            System.out.println("Enter a valid email address.");
        }
    }
}