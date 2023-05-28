package basicPrinciplesOfJava;

import java.util.Scanner;

public class AlcoolGasolina {

	public static void main(String[] args) {

		double alcool;
		double gasolina;
		Scanner teclado = new Scanner(System.in);

		System.out.println("Álcool x Gasolina");
		System.out.print("Digite o valor do álcool: ");
		alcool = teclado.nextDouble();
		System.out.print("Digite o valor da gasolina: ");
		gasolina = teclado.nextDouble();

		if (alcool < 0.7 * gasolina) {
			System.out.println("ABASTEÇA COM ÁLCOOL");
		} else {
			System.out.println("ABASTEÇA COM GASOLINA");
		}
		teclado.close();
	}
}
