import java.util.Scanner;

public class Helper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    }

    // Gets a string with a length greater than 0
    public static String getNonZeroLengthString(Scanner scan, String prompt) {
        String input;

        do {
            System.out.println(prompt);
            input = scan.nextLine();

            if (input.length() > 0) {
                break;
            } else {
                System.out.println("Invalid prompt. Please try again");
            }

        } while (true);

        System.out.println(input);
        return input;
    }

    // Ask the user for an int and verifies if the number inputted is an int
    public static int getInt(Scanner scan, String prompt) {
        int value = 0;
        System.out.println(prompt);

        do {
            if (scan.hasNextInt()) {
                value = scan.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please try again");
            }
            scan.nextLine();
        } while (true);

        return value;
    }

    // Ask the user for a double and verifies if the number inputted is a double
    public static double getDouble(Scanner scan, String prompt) {
        double value = 0;
        System.out.println(prompt);

        do {
            if (scan.hasNextDouble()) {
                value = scan.nextDouble();
                break;
            } else {
                System.out.println("Invalid input. Please try again");
            }
            scan.nextLine();
        } while(true);

        return value;
    }

    // Checks if the user's int is greater than 0
    public static int getPositiveNonZeroInt(Scanner scan, String prompt) {
        int value = 0;
        System.out.println(prompt);

        do {
            if (scan.hasNextInt()) {
                value = scan.nextInt();

                if (value > 0) {
                    break;
                } else {
                    System.out.println("Invalid input. Please try again");
                }

            } else {
                System.out.println("Invalid input. Please try again");
            }
            scan.nextLine();
        } while (true);

        return value;
    }


    // Checks if the user's int is within a given range
    public static int getRangedInt(Scanner scan, String prompt, int min, int max) {
        int value = 0;

        System.out.println(prompt);

        do {
            if (scan.hasNextInt()) {
                value = scan.nextInt();

                // Checks if the value is in range
                if (value <= max && value >= min) {
                    break;
                } else {
                    System.out.println("Invalid input. Please try again");
                }
            } else {
                System.out.println("Invalid input. Please try again");
            }
            scan.nextLine();
        } while(true);

        return value;
    }

    // Checks if the user's int is within a given range
    public static double getRangedDouble(Scanner scan, String prompt, double min, double max) {
        double value = 0.0;

        System.out.println(prompt);

        do {
            if (scan.hasNextDouble()) {
                value = scan.nextDouble();

                // Checks if the value is in range
                if (value <= max && value >= min) {
                    break;
                } else {
                    System.out.println("Invalid input. Please try again");
                }
            } else {
                System.out.println("Invalid input. Please try again");
            }
            scan.nextLine();
        } while(true);

        return value;
    }

    // Confirms if the user will continue (Y) or stop (N)
    public static boolean getYNConfirm(Scanner scan, String prompt) {
        boolean YN;
        String confirmation;

        System.out.println(prompt);

        do {
            confirmation = scan.nextLine();
            if (confirmation.equalsIgnoreCase("y")) {
                YN = true;
                break;
            } else if (confirmation.equalsIgnoreCase("n")) {
                YN = false;
                break;
            } else {
                System.out.println("Invalid input. Please try again");
            }
        } while (true);

        return YN;
    }

    // Finds specific lines of numbers (DoB, SSN, etc)
    public static String getRegExString(Scanner scan, String prompt, String regEx) {
        String input;

        do {
            System.out.println(prompt);
            input = scan.nextLine();
            if (input.matches(regEx)) {
                break;
            } else {
                System.out.println("Invalid input. Please try again");
            }
        } while (true);

        return input;
    }

    // Creates a pretty header with a message centered
    public static void prettyHeader(String msg) {

        // Doing the math to center the string
        int z = (60 - msg.length()) / 2 - 2;
        String x = " ";

        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                for (int k = 0; k < 60; k++) {
                    if (z == k) {
                        System.out.print(msg);
                    } else if (k < 3 || k > 56) {
                        System.out.print("*");
                    } else if (k < 56 - (msg.length() - 2)) {
                        System.out.print(x);
                    }
                }
                System.out.println(" ");
            } else {
                for (int j = 0; j < 60; j++) {
                    System.out.print("*");
                }
                System.out.println(" ");
            }
        }
    }

    // Converts Fahrenheit to Celsius
    public static double CtoF(double Celsius) {
        double fahrenheit;

        fahrenheit = ((Celsius*9)/5) + 32;

        return fahrenheit;
    }
}