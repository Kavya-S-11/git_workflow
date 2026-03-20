# Calculator Coding Standards

## Language & Version
- Java 8 or higher
- Single-file structure (`Calculator.java`) — no packages unless the project grows

## Naming Conventions
- **Classes** — `PascalCase` (e.g., `Calculator`)
- **Methods** — `camelCase`, verb-first (e.g., `squareRoot`, `isPrime`)
- **Variables** — `camelCase`, short but descriptive (e.g., `base`, `exp`, `result`)
- **Constants** — `UPPER_SNAKE_CASE` if added (e.g., `MAX_FACTORIAL_INPUT`)

## Method Structure
- All calculator operations are `static` — no instance state is needed.
- Each method does one thing and returns a value; side effects (printing) belong in `main`.
- Throw `ArithmeticException` with a clear message for mathematically invalid inputs (e.g., division by zero, negative square root).

```java
// Correct
static double divide(double a, double b) {
    if (b == 0) throw new ArithmeticException("Division by zero");
    return a / b;
}

// Incorrect — mixing logic and output
static void divide(double a, double b) {
    if (b == 0) { System.out.println("Error"); return; }
    System.out.println(a / b);
}
```

## Error Handling
- Catch `ArithmeticException` in `main` for math errors.
- Catch the general `Exception` last to handle bad user input, then call `sc.nextLine()` to clear the scanner buffer.
- Never swallow exceptions silently.

## Input / Output
- Use a single `Scanner` instance opened once in `main` and closed on exit.
- Trigonometric functions accept **degrees** as user input; convert internally with `Math.toRadians()`.
- Print results with `%.4f` precision for decimals, `%d` for integers.

## Adding New Operations
1. Add a `static` method in the relevant group (Basic / Advanced / Trigonometry / Other).
2. Add a menu entry in `printMenu()` with a unique option number.
3. Add a `case` in the `switch` block inside `main`.
4. Document the expected input domain (e.g., "n must be ≥ 0") in the method's guard clause.
