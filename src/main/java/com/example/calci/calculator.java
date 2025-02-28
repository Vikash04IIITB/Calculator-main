package com.example.calci;

import java.util.Scanner;
import java.util.*;

public class calculator {

   public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

	int dummy = scanner.nextInt();
        boolean exit = false;

        System.out.println("Calculator :-");

        while (!exit) 

        {

            System.out.println("1. Square Root");

            System.out.println("2. Factorial");

            System.out.println("3. Log");

            System.out.println("4. Power");

            System.out.println("5. Exit");



            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();

            double result;

            if (choice == 5) 

            {

                exit = true;

                System.out.println("Exiting the calculator. Byeee!");

                continue;

            }



            System.out.print("Enter Number: ");

            double num = scanner.nextDouble();

            switch (choice) 

            {

                case 1:

                    result = findSquareRoot(num);

                    break;

                case 2:

                    result = findFactorial(num);

                    break;

                case 3:

                    result = findLog(num);

                    break;

                case 4:
                    System.out.print("Enter Exponent: ");

                    double e = scanner.nextDouble();
                    
                    result = findPower(num,e);

                    break;

                default:

                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");

                    continue;

            }



            System.out.println("Result: " + result);

        }

    }



    public static double findSquareRoot(double a) {

        double ans=Math.sqrt(a);

        return ans;

    }



    public static double findFactorial(double a) {

        int ans=1;

        for(int i=1;i<=(int)a;i++)   
            ans=ans*i;  

        return (double)ans;
    }



    public static double findLog(double a) {

        double ans;

        ans=Math.log(a);

        ans = Math.round(ans * Math.pow(10, 2))
                 / Math.pow(10, 2);

        return ans;
    }

    public static double findPower(double a,double e) {

        double ans;

        Scanner scanner = new Scanner(System.in);

        ans=Math.pow(a,e);

        
        return ans;
    }

}
