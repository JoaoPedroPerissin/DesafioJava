package Desafio;

import java.util.Scanner;

public class DesafioJava {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		
		int contador = 1;
		
		double valorBruto = 0, valorComImpostoC = 0, lucroC = 0, 
				valorComImpostoE = 0, lucroE = 0, valorBrutoC = 0, valorBrutoE = 0, 
				valorBrutoV = 0, valorComImpostoV = 0, lucroV = 0;
		char categoria;
		
		while(contador <= 15) {
			System.out.println("Digite o preço do produto: ");
			double preco = sc.nextDouble();
			
			System.out.println("\nDigite a quantidade de produtos: ");
			double quantidade = sc.nextDouble();
			
			System.out.println("\nDigite a categoria do produto: C (cama, mesa e"
					+ " banho), E (eletrodomésticos) ou V (vestuário): ");
			categoria = sc.next().charAt(0);
			categoria = Character.toUpperCase(categoria);
			if ( categoria == 'C') {
				valorBruto = preco * quantidade;
				valorBrutoC += valorBruto;
				valorComImpostoC += valorBruto - valorBruto * 37.41/100;
				lucroC = valorComImpostoC * 30/100;
			} else if ( categoria == 'E') {
				valorBruto = preco * quantidade;
				valorBrutoE += valorBruto;
				valorComImpostoE += valorBruto - valorBruto * 43.14/100; 
				lucroE = valorComImpostoE * 35/100;
			} else if ( categoria == 'V') {
				valorBruto = preco * quantidade;
				valorBrutoV += valorBruto;
				valorComImpostoV += valorBruto - valorBruto * 38.42/100;
				lucroV = valorComImpostoV * 50/100;
			} else {
				System.out.println("\nValor inserido invalido, porfavor inserir"
						+ "um dos valores acima ");
				contador--;
			}
			contador++;
		}
		System.out.printf("\nC: Valor bruto: %.2f, valor com imposto: %.2f, lucro: %.2f.",valorBrutoC,valorComImpostoC,lucroC);
		System.out.printf("\nE: Valor bruto: %.2f, valor com imposto: %.2f, lucro: %.2f.",valorBrutoE,valorComImpostoE,lucroE);
		System.out.printf("\nV: Valor bruto: %.2f, valor com imposto: %.2f, lucro: %.2f.",valorBrutoV,valorComImpostoV,lucroV);
			
		
		
		sc.close();
		

	}

}
