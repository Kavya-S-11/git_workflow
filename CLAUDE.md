# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Code Standards Reference

Before generating or modifying any code in this repository, always consult the `/doc` directory first. It contains the authoritative coding standards for this project:

- [`/doc/calc.md`](doc/calc.md) — naming conventions, method structure, error handling, I/O rules, and how to add new operations

All generated code must conform to the standards defined there.

## Build & Run

```bash
# Compile
javac Calculator.java

# Run
java Calculator
```

## Architecture

This is a single-file Java console application (`Calculator.java`) with a menu-driven loop. All calculator logic lives as static methods in the `Calculator` class, grouped into:

- **Basic arithmetic** — `add`, `subtract`, `multiply`, `divide`, `modulus`
- **Advanced math** — `power`, `squareRoot`, `log`, `naturalLog`
- **Trigonometry** — `sine`, `cosine`, `tangent` (degrees as input, converted internally via `Math.toRadians`)
- **Utilities** — `factorial`, `isPrime`

`main` drives a `do-while` loop that prints the menu, reads an integer choice via `Scanner`, dispatches to the appropriate case, and handles errors via `ArithmeticException` catch blocks. The loop exits when the user enters `0`.
