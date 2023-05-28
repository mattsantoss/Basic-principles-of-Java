package basicPrinciplesOfJava;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ValorHora {

	public static void main(String[] args) {

		double remuneracao;
		double custo;
		double hora;
		int cargaHoraria;

		Scanner teclado = new Scanner(System.in);
		DecimalFormat formatador = new DecimalFormat("#0.00");

		System.out.println("Cálculo do valor da hora de serviço");
		System.out.print("Remuneração mensal pretendida: ");
		remuneracao = teclado.nextDouble();
		System.out.print("Custo operacional: ");
		custo = teclado.nextDouble();
		System.out.print("Carga horária mensal de trabalho: ");
		cargaHoraria = teclado.nextInt();

		hora = (remuneracao + (0.3 * remuneracao) + custo + (0.2 * remuneracao)) / cargaHoraria;

		System.out.println("Valor da hora: " + formatador.format(hora));
		teclado.close();
	}
}
