package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Departamento;
import entidades.HoraContrato;
import entidades.Trabalhador;
import entidades.emums.NivelDoTrabalhador;

public class App {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Entre com o nome do departamento: ");
		String departamento = sc.nextLine();
		System.out.print("Entre com o nome do trabalhador: ");
		String nome = sc.nextLine();
		System.out.print("Level do trabalhador: ");
		String nivel = sc.nextLine();
		System.out.print("Salário base: ");
		double salario = sc.nextDouble();

		Trabalhador trabalhador = new Trabalhador(nome, NivelDoTrabalhador.valueOf(nivel), salario,
				new Departamento(departamento));

		System.out.printf("Quantos contratos esse trabalhador possui? ");
		int numero = sc.nextInt();

		for (int i = 0; i < numero; i++) {
			System.out.printf("Entre com a data do #%d contrato: ", i + 1);
			System.out.printf("Data DD/MM/AAAA: ");
			Date data = sdf.parse(sc.next());
			System.out.printf("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.printf("Duração: ");
			int duracao = sc.nextInt();

			HoraContrato contrato = new HoraContrato(data, valorPorHora, duracao);

			trabalhador.addContrato(contrato);
		}

		System.out.printf("\nEntre com o mes e o ano para calcular o salario: ");
		String periodo = sc.next();
		int mes = Integer.parseInt(periodo.substring(0, 2));
		int ano = Integer.parseInt(periodo.substring(3));

		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println(
				"Salario no periodo de " + periodo + ": " + String.format("%.2f", trabalhador.salario(ano, mes)));

		sc.close();
	}
}
