//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner input =new Scanner(System.in);
//        double result=0;
//
//        while (true){
//            printMenu();
//            int choice=input.nextInt();
//            switch (choice){
//                case 1:result=addition(input);
//                    break;
//                case 2:result=subtraction(input);
//                    break;
//                case 3:result=multiplication(input);
//                    break;
//                case 4:result=division(input);
//                    break;
//                case 5:result=modulus(input);
//                    break;
//                case 6:result=minimum(input);
//                    break;
//                case 7:result=maximum(input);
//                    break;
//                case 8:result=average(input);
//                    break;
//                case 9:printLastResult(result);
//                    break;
//                case 10:
//                    break;
//                case 11:
//                    break;
//            }
//        }
//    }//Main
//    public static void printMenu(){
//        System.out.println("\nCalculator Menu:");
//        System.out.println("-1 to Addition");
//        System.out.println("-2 to Subtraction");
//        System.out.println("-3 to Multiplication");
//        System.out.println("-4 to Division");
//        System.out.println("-5 to Modulus");
//        System.out.println("-6 to find the Minimum ");
//        System.out.println("-7 to find the Maximum ");
//        System.out.println("-8 to find the Average of numbers");
//        System.out.println("-9 to print the last result in calculator");
//        System.out.println("-10 to print the list of all results in calculator");
//        System.out.println("-11 to exit the calculator");
//        System.out.print("Please enter your choice: ");
//    }
//    public static double addition(Scanner input){
//        System.out.print("Enter first number: ");
//        double num1 = input.nextDouble();
//        System.out.print("Enter second number: ");
//        double num2 = input.nextDouble();
//        return num1 + num2;
//    }
//    public static double subtraction(Scanner input){
//        System.out.print("Enter first number: ");
//        double num1 = input.nextDouble();
//        System.out.print("Enter second number: ");
//        double num2 = input.nextDouble();
//        return num1 - num2;
//    }
//    public static double multiplication(Scanner input){
//        System.out.print("Enter first number: ");
//        double num1 = input.nextDouble();
//        System.out.print("Enter second number: ");
//        double num2 = input.nextDouble();
//        return num1 * num2;
//    }
//    public static double division(Scanner input){
//        System.out.print("Enter first number: ");
//        double num1 = input.nextDouble();
//        System.out.print("Enter second number: ");
//        double num2 = input.nextDouble();
//        return num1 / num2;
//    }
//    public static double modulus(Scanner input){
//        System.out.print("Enter first number: ");
//        double num1 = input.nextDouble();
//        System.out.print("Enter second number: ");
//        double num2 = input.nextDouble();
//        return num1 % num2;
//    }
//    public static double minimum(Scanner input){
//        System.out.print("Enter first number: ");
//        double num1 = input.nextDouble();
//        System.out.print("Enter second number: ");
//        double num2 = input.nextDouble();
//        return Math.min(num1,num2);
//    }
//    public static double maximum(Scanner input){
//        System.out.print("Enter first number: ");
//        double num1 = input.nextDouble();
//        System.out.print("Enter second number: ");
//        double num2 = input.nextDouble();
//        return Math.max(num1,num2);
//    }
//    public static double average(Scanner input){
//        System.out.print("Enter first number: ");
//        double num1 = input.nextDouble();
//        System.out.print("Enter second number: ");
//        double num2 = input.nextDouble();
//        return (num1+num2)/2;
//    }
//    public static void printLastResult(double result) {
//        System.out.println("Last result: " + result);
//    }
//
//
//}
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);

        double lastResult = 0;
        ArrayList<Double> results = new ArrayList<>();

        while (true) {
            printMenu();
            int choice = input.nextInt();
            System.out.println("~~~~~~~~~~~~~~~~\n");


            switch (choice) {
                case 1:
                        lastResult = addNumbers(input, results);
                    break;
                case 2:

                        lastResult = subtractNumbers(input, results);
                    break;
                case 3:
                        lastResult = multiplyNumbers(input, results);
                    break;
                case 4:
                        lastResult = divideNumbers(input, results);
                    break;
                case 5:
                        lastResult = modulusNumbers(input, results);
                    break;
                case 6:
                        lastResult = findMin(input, results);
                    break;
                case 7:
                        lastResult = findMax(input, results);
                    break;
                case 8:
                        lastResult = calculateAverage(input, results);
                    break;
                case 9:
                    printLastResult(lastResult);
                    break;
                case 10:
                    printAllResults(results);
                    break;
                case 11:
                    System.out.println("Thank you :)");
                    return;
                    default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }

    public static void printMenu() {
        System.out.println("\nCalculator Menu:");
        System.out.println("Enter 1 to add the numbers");
        System.out.println("Enter 2 to subtract the numbers");
        System.out.println("Enter 3 to multiply the numbers");
        System.out.println("Enter 4 to divide the numbers");
        System.out.println("Enter 5 to modulus the numbers");
        System.out.println("Enter 6 to find the minimum number");
        System.out.println("Enter 7 to find the maximum number");
        System.out.println("Enter 8 to find the average of numbers");
        System.out.println("Enter 9 to print the last result in calculator");
        System.out.println("Enter 10 to print the list of all results in calculator");
        System.out.println("Enter 11 to exit the calculator");
        System.out.print("Please enter your choice: ");
    }

    public static double addNumbers(Scanner input, ArrayList<Double> results) {
        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = input.nextDouble();
        double result = num1+num2;
        results.add(result);
        System.out.println("Result: " + result);
        return result;
    }

    public static double subtractNumbers(Scanner input, ArrayList<Double> results) {
        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = input.nextDouble();
        double result = num1-num2;
        results.add(result);
        System.out.println("Result: " + result);
        return result;
    }

    public static double multiplyNumbers(Scanner input, ArrayList<Double> results) {
        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = input.nextDouble();
        double result = num1*num2;
        results.add(result);
        System.out.println("Result: " + result);
        return result;
    }

    public static double divideNumbers(Scanner input, ArrayList<Double> results) {
        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = input.nextDouble();
        double result = num1/num2;
        results.add(result);
        System.out.println("Result: " + result);
        return result;
    }

    public static double modulusNumbers(Scanner input, ArrayList<Double> results) {
        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = input.nextDouble();
        double result = num1%num2;
        results.add(result);
        System.out.println("Result: " + result);
        return result;
    }

    public static double findMin(Scanner input, ArrayList<Double> results) {
        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = input.nextDouble();
        double result = Math.min(num1, num2);
        results.add(result);
        System.out.println("Minimum: " + result);
        return result;
    }

    public static double findMax(Scanner input, ArrayList<Double> results) {
        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = input.nextDouble();
        double result = Math.max(num1, num2);
        results.add(result);
        System.out.println("Maximum: " + result);
        return result;
    }

    public static double calculateAverage(Scanner input, ArrayList<Double> results) {
        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = input.nextDouble();
        double result = (num1 + num2) / 2;
        results.add(result);
        System.out.println("Average: " + result);
        return result;
    }

    public static void printLastResult(double lastResult) {
        System.out.println("Last result: " + lastResult);
    }

    public static void printAllResults(ArrayList<Double> results) {
        System.out.println("All results: " + results);
    }

}
