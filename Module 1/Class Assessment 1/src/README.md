# day1.ThisKeyword.day3.ComparableComparatorDemo.Employee Festival Bonus System

## Overview
A Java console-based application that calculates employee festival bonuses based on their roles and sorts employees by bonus amount in descending order.

## Technologies Used
- Java
- Java Collections Framework
- ArrayList
- Comparator
- Object-Oriented Programming (OOP)

## Bonus Rules

| day1.ThisKeyword.day3.ComparableComparatorDemo.Employee Role | Bonus Rate |
|---|---:|
| Manager | 12% |
| Admin | 10% |
| Engineer | 12% |
| Accountant | 8% |

## Bonus Calculation
Bonus = (Salary + HRA) × Bonus Rate / 100

## Project Structure
Class Assessment 1/
├── README.md
└── src/
    ├── day1.ThisKeyword.day3.ComparableComparatorDemo.Employee.java
    ├── Bonus_service.java
    └── Main.java

## Features
- Stores employee details using an day1.ThisKeyword.day3.ComparableComparatorDemo.Employee class.
- Calculates bonuses based on employee roles.
- Uses ArrayList to manage employee records.
- Sorts employees by bonus in descending order.
- Displays employee details and calculated bonuses.

## How to Run

Open a terminal in the `src` folder and run:

javac day1.ThisKeyword.day3.ComparableComparatorDemo.Employee.java Bonus_service.java Main.java
java Main

## Sample Output
2 sushil 20000.0 5000.0 engineer 3000.0
3 aman 30000.0 5000.0 accountant 2800.0
1 ashish 12000.0 5000.0 manager 2040.0

## Learning Outcomes
- Classes, objects, and constructors
- Encapsulation and business logic separation
- ArrayList and Comparator
- Sorting collections
- Basic project organization and testing
