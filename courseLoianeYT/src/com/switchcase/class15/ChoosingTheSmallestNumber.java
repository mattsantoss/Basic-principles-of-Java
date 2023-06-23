package com.switchcase.class15;

import java.util.Scanner;

public class ChoosingTheSmallestNumber {
	public static void main (String[] args)
	{
		int num1 = 5;
        int num2 = 410;
        int num3 = 7;
        
        Scanner scan = new Scanner (System.in);
        
        System.out.println("Type the first number");
        num1 = scan.nextInt();
        
        System.out.println("Type the second number");
        num2 = scan.nextInt();
        
        System.out.println("Type the third number");
        num3 = scan.nextInt();
        
        int menor = Math.min(num1, Math.min(num2, num3));

        System.out.println("The Smallest Number is: " + menor);
	}
}
