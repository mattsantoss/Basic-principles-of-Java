package basicPrinciplesOfJava;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculadoraMedia {
	public static void main(String[] args) {

		String nome;
		double nota1;
		double nota2;
		double media;
		Scanner teclado = new Scanner(System.in);
		DecimalFormat formatador = new DecimalFormat("#0.00");

		System.out.println("======================");
		System.out.println("== Cálculo da média ==");
		System.out.println("======================");
		System.out.println("");
		System.out.print("Digite o seu nome: ");
		nome = teclado.nextLine();
		System.out.print("Digite a nota1: ");
		nota1 = teclado.nextDouble();
		System.out.print("Digite a nota2: ");
		nota2 = teclado.nextDouble();

		media = (nota1 + nota2) / 2;

		System.out.println("-------------------------------");
		System.out.println("Nome: " + nome);
		System.out.println("Média: " + formatador.format(media));

		if (media < 2) {
			System.out.println("REPROVADO");
		} else if (media >= 5) {
			System.out.println("APROVADO");
		} else {
			System.out.println("RECUPERAÇÃO");
		}
		teclado.close();
	}
}
