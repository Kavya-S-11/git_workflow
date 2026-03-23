import java.util.Scanner;

public class Calculator {

    // Basic arithmetic
    static double add(double a, double b) { return a + b; }
    static double subtract(double a, double b) { return a - b; }
    static double multiply(double a, double b) { return a * b; }
    static double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Division by zero");
        return a / b;
    }
    static double modulus(double a, double b) { return a % b; }

    // Advanced calculations
    static double power(double base, double exp) { return Math.pow(base, exp); }
    static double squareRoot(double n) {
        if (n < 0) throw new ArithmeticException("Cannot take square root of negative number");
        return Math.sqrt(n);
    }
    static double log(double n) {
        if (n <= 0) throw new ArithmeticException("Logarithm undefined for non-positive values");
        return Math.log10(n);
    }
    static double naturalLog(double n) {
        if (n <= 0) throw new ArithmeticException("Logarithm undefined for non-positive values");
        return Math.log(n);
    }

    // Trigonometry (input in degrees)
    static double sine(double deg)   { return Math.sin(Math.toRadians(deg)); }
    static double cosine(double deg) { return Math.cos(Math.toRadians(deg)); }
    static double tangent(double deg) {
        if (deg % 180 == 90) throw new ArithmeticException("Tangent undefined at 90°/270°");
        return Math.tan(Math.toRadians(deg));
    }

    // Utility
    static long factorial(int n) {
        if (n < 0) throw new ArithmeticException("Factorial of negative number is undefined");
        if (n > 20) throw new ArithmeticException("Input too large (max 20)");
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    // New: scientific calculation helper supporting common functions
    static double scientific(String op, double a, Double b) {
        String o = op.toLowerCase();
        switch (o) {
            case "sin": return sine(a);
            case "cos": return cosine(a);
            case "tan": return tangent(a);
            case "asin": return Math.toDegrees(Math.asin(a));
            case "acos": return Math.toDegrees(Math.acos(a));
            case "atan": return Math.toDegrees(Math.atan(a));
            case "sinh": return Math.sinh(Math.toRadians(a));
            case "cosh": return Math.cosh(Math.toRadians(a));
            case "tanh": return Math.tanh(Math.toRadians(a));
            case "exp": return Math.exp(a);
            case "10^": return power(10, a);
            case "pow":
                if (b == null) throw new IllegalArgumentException("pow requires two operands");
                return power(a, b);
            case "sqrt": return squareRoot(a);
            case "ln": return naturalLog(a);
            case "log": return log(a);
            case "abs": return Math.abs(a);
            default: throw new IllegalArgumentException("Unknown scientific operation: " + op);
        }
    }

    static void printMenu() {
        System.out.println("\n===== JAVA CALCULATOR =====");
        System.out.println("--- Basic ---");
        System.out.println("  1. Addition        (a + b)");
        System.out.println("  2. Subtraction     (a - b)");
        System.out.println("  3. Multiplication  (a * b)");
        System.out.println("  4. Division        (a / b)");
        System.out.println("  5. Modulus         (a % b)");
        System.out.println("--- Advanced ---");
        System.out.println("  6. Power           (a ^ b)");
        System.out.println("  7. Square Root     (√a)");
        System.out.println("  8. Log base 10     (log a)");
        System.out.println("  9. Natural Log     (ln a)");
        System.out.println("--- Trigonometry ---");
        System.out.println(" 10. Sine            (sin a°)");
        System.out.println(" 11. Cosine          (cos a°)");
        System.out.println(" 12. Tangent         (tan a°)");
        System.out.println("--- Other ---");
        System.out.println(" 13. Factorial       (n!)");
        System.out.println(" 14. Prime Check     (is n prime?)");
        System.out.println(" 15. Scientific      (sin, cos, tan, sqrt, ln, log, exp, pow)");
        System.out.println("  0. Exit");
        System.out.println("===========================");
        System.out.print("Choose an option: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            choice = sc.nextInt();
            // Handle user's menu choice.
            // Note: Scanner.nextInt() reads only the number token and leaves the line terminator
            // in the input stream; subsequent nextLine()/next() calls will still work for token-based reads.
            // The switch below is wrapped in a try/catch to separate calculation errors (ArithmeticException)
            // from general input/parsing errors. Valid choices are 0-15; 0 exits the loop.
            try {
                switch (choice) {
                    case 1: {
                        System.out.print("Enter a: "); double a = sc.nextDouble();
                        System.out.print("Enter b: "); double b = sc.nextDouble();
                        System.out.printf("Result: %.4f + %.4f = %.4f%n", a, b, add(a, b));
                        break;
                    }
                    case 2: {
                        System.out.print("Enter a: "); double a = sc.nextDouble();
                        System.out.print("Enter b: "); double b = sc.nextDouble();
                        System.out.printf("Result: %.4f - %.4f = %.4f%n", a, b, subtract(a, b));
                        break;
                    }
                    case 3: {
                        System.out.print("Enter a: "); double a = sc.nextDouble();
                        System.out.print("Enter b: "); double b = sc.nextDouble();
                        System.out.printf("Result: %.4f * %.4f = %.4f%n", a, b, multiply(a, b));
                        break;
                    }
                    case 4: {
                        System.out.print("Enter a: "); double a = sc.nextDouble();
                        System.out.print("Enter b: "); double b = sc.nextDouble();
                        System.out.printf("Result: %.4f / %.4f = %.4f%n", a, b, divide(a, b));
                        break;
                    }
                    case 5: {
                        System.out.print("Enter a: "); double a = sc.nextDouble();
                        System.out.print("Enter b: "); double b = sc.nextDouble();
                        System.out.printf("Result: %.4f %% %.4f = %.4f%n", a, b, modulus(a, b));
                        break;
                    }
                    case 6: {
                        System.out.print("Enter base: "); double a = sc.nextDouble();
                        System.out.print("Enter exponent: "); double b = sc.nextDouble();
                        System.out.printf("Result: %.4f ^ %.4f = %.4f%n", a, b, power(a, b));
                        break;
                    }
                    case 7: {
                        System.out.print("Enter a: "); double a = sc.nextDouble();
                        System.out.printf("Result: sqrt(%.4f) = %.4f%n", a, squareRoot(a));
                        break;
                    }
                    case 8: {
                        System.out.print("Enter a: "); double a = sc.nextDouble();
                        System.out.printf("Result: log10(%.4f) = %.4f%n", a, log(a));
                        break;
                    }
                    case 9: {
                        System.out.print("Enter a: "); double a = sc.nextDouble();
                        System.out.printf("Result: ln(%.4f) = %.4f%n", a, naturalLog(a));
                        break;
                    }
                    case 10: {
                        System.out.print("Enter angle (degrees): "); double a = sc.nextDouble();
                        System.out.printf("Result: sin(%.2f°) = %.4f%n", a, sine(a));
                        break;
                    }
                    case 11: {
                        System.out.print("Enter angle (degrees): "); double a = sc.nextDouble();
                        System.out.printf("Result: cos(%.2f°) = %.4f%n", a, cosine(a));
                        break;
                    }
                    case 12: {
                        System.out.print("Enter angle (degrees): "); double a = sc.nextDouble();
                        System.out.printf("Result: tan(%.2f°) = %.4f%n", a, tangent(a));
                        break;
                    }
                    case 13: {
                        System.out.print("Enter n (integer): "); int n = sc.nextInt();
                        System.out.printf("Result: %d! = %d%n", n, factorial(n));
                        break;
                    }
                    case 14: {
                        System.out.print("Enter n (integer): "); int n = sc.nextInt();
                        System.out.printf("Result: %d is %s%n", n, isPrime(n) ? "PRIME" : "NOT PRIME");
                        break;
                    }

                    case 15: {
                        System.out.print("Enter operation (sin, cos, tan, sqrt, ln, log, exp, pow): ");
                        String op = sc.next();
                        System.out.print("Enter first operand: ");
                        double a = sc.nextDouble();
                        Double b = null;
                        if (op.equalsIgnoreCase("pow")) {
                            System.out.print("Enter second operand: ");
                            b = sc.nextDouble();
                        }
                        double res = scientific(op, a, b);
                        if (b == null)
                            System.out.printf("Result: %s(%.4f) = %.6f%n", op, a, res);
                        else
                            System.out.printf("Result: %s(%.4f, %.4f) = %.6f%n", op, a, b, res);
                        break;
                    }

                    case 0:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose 0-15.");
                }
            } catch (ArithmeticException e) {
                System.out.println("Math Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine(); // clear bad input
            }

        } while (choice != 0);

        sc.close();
    }
}
