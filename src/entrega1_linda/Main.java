package entrega1_linda;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int n;
		String line;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Número de entradas: ");
		n = input.nextInt();
		input.nextLine();
		float [][] califications = new float[n][4];
//		CAPTURA DE DATOS
		for (int i = 0; i < n; i++) {
			System.out.print("Inserte la linea: ");
			line = input.nextLine();
			String [] arrayline = line.split(" ");
			for (int j = 0; j < arrayline.length; j++) {
				
				califications[i][j]=Float.parseFloat(arrayline[j]);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.printf("%.2f\t", califications[i][j]);
				if (j==3) {
					System.out.println("");
				}
			}
		}
//		FIN RUTINA
	}
}
