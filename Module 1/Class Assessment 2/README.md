# Shopping Cart Application

## Overview
The Shopping Cart Application is a console-based Java project that allows users to manage products in a shopping cart. It demonstrates object-oriented programming, collections, exception handling, and lambda expressions.

## Features
- Add products to the shopping cart.
- Remove products from the cart.
- Update product quantities.
- Display all cart items.
- Calculate the total cart price.
- Sort cart items by product price.
- Validate product details and quantities.

## Technologies Used
- Java
- Java Collections Framework (`ArrayList`, `List`)
- Object-Oriented Programming (OOP)
- Lambda Expressions
- Exception Handling

## Project Structure
Class Assessment 2/
├── src/
│   ├── model/
│   │   ├── Product.java
│   │   ├── Productcategory.java
│   │   └── Carditems.java
│   ├── service/
│   │   └── ServiceCard.java
│   └── app/
│       └── Main.java
├── out/
└── README.md

## How to Run
javac -d out src/model/*.java src/service/*.java src/app/*.java
java -cp out app.Main


### Prerequisites
- Java Development Kit (JDK)
- Visual Studio Code with Extension Pack for Java (optional)

### Using VS Code
1. Open the project folder in VS Code.
2. Open `src/app/Main.java`.
3. Click **Run** above the `main()` method.

### Using the Terminal
Run these commands from the project root:

powershell
javac -d out src/model/*.java src/service/*.java src/app/*.java
java -cp out app.Main

## Concepts Practiced
- Classes and objects
- Constructors and encapsulation
- Enums
- Validation using `IllegalArgumentException`
- Lists and `ArrayList`
- Lambda expressions and sorting with `Comparator`
- Methods and separation of responsibilities

