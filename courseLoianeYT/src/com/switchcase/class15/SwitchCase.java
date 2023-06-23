package com.switchcase.class15;

import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		System.out.println("Type a number of the week, between 1-7");
		int weekDay = scan.nextInt();
		
		switch (weekDay) {
		case 1:System.out.println("today is Sunday");break;
		case 2:System.out.println("today is Monday");break;
		case 3:System.out.println("today is Tuesday");break;
		case 4:System.out.println("today is Wednesday");break;
		case 5:System.out.println("today is Thursday");break;
		case 6:System.out.println("today is Friday");break;
		case 7:System.out.println("today is Saturday");break;

		default:
			System.out.println("invalid week day");
			break;
		}

	}

}
