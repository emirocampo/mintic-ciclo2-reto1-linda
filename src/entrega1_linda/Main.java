package entrega1_linda;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int n;
		String line;
		
		Scanner input = new Scanner(System.in);
//		System.out.print("Número de entradas: ");
		n = input.nextInt();
		input.nextLine();
		float [][] califications = new float[n][4];
//		CAPTURA DE DATOS
		for (int i = 0; i < n; i++) {
//			System.out.print("Inserte la linea: ");
			line = input.nextLine();
			String [] arrayline = line.split(" ");
			for (int j = 0; j < arrayline.length; j++) {
				
				califications[i][j]=Float.parseFloat(arrayline[j]);
			}
		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.printf("%.2f\t", califications[i][j]);
//				if (j==3) {
//					System.out.println("");
//				}
//			}
//		}
//		FIN RUTINA
//		RUTINA PARA CALCULAR PROMEDIO Y EXAMENES MENORES AL PROMEDIO
		float mean, sum = 0;
		for (int i = 0; i < n; i++) {
			sum += califications[i][3];
		}
		mean = sum / n;
		
		int flagExamsMean = 0;
		for (int i = 0; i < n; i++) {
			if(califications[i][3] < mean) {
				flagExamsMean++;
			}
		}
//		FIN RUTINA
//		RUTINA EXMANES SOBRESALIENTES
		int flagOutstandingGrades = 0;
		for (int i = 0; i < n; i++) {
			if(califications[i][3] > 8.0 && califications[i][3] <= 9.0) {
				flagOutstandingGrades++;
			}
		}
//		FIN RUTINA
//		RUTINA MEJOR DESEMPEÑO ACADEMICO GENERO FEMENINO
//		se pide calcular el promedio, pero con la nota mas alta es suficiente
		float [] subject = {0, 0, 0};
		for (int i = 0; i < n; i++) {
			if ( califications[i][1] == 1.0) {
				switch ( Float.toString(califications[i][2]) ) {
				case "1.0":
					subject[0]= subject[0] + califications[i][2];
					break;
				case "2.0":
					subject[1]= subject[1] + califications[i][2];
					break;
				case "3.0":
					subject[2]= subject[2] + califications[i][2];
					break;

				default:
					break;
				}
			}
		}
		float max = subject[0];
		int indexSubject = 0;
		for (int i = 0; i < subject.length; i++) {
			if( subject[i] > max ) {
				max = subject[i];
				indexSubject = i;
			}
		}
		String subjectRequest = "";
		switch ( indexSubject ) {
		case 0:
			subjectRequest = "historia";
			break;
		case 1:
			subjectRequest = "literatura";
			break;
		case 2:
			subjectRequest = "biologia";
			break;

		default:
			break;
		}
//		FIN RUTINA
//		ESTUDIANTE MAYOR DESEMPE�O HISTORIA
		String nameStudent = "";
		String topStudent = "0";
		float topNote = 0;
		for (int i = 0; i < n; i++) {
			if(califications[i][2] == 1.00) {
				topNote = califications[i][3];
//				System.out.printf("inicialización topNote %.2f\n",topNote);
				topStudent = Float.toString(califications[i][0]);
//				System.out.printf("inicialización el estudiante mas alto de historia: %s\n", topStudent);
				break;
			}
		}
		
		for (int i = 0; i < n; i++) {
			if( califications[i][2] == 1.00 && califications[i][3] > topNote) {
				topNote = califications[i][3];
//				System.out.printf("La nota mas alta de historia: %.2f\n", topNote);
				topStudent = Float.toString(califications[i][0]);
//				System.out.printf("El estudiante mas alto de historia: %s\n", topStudent);
			}
		}
//		System.out.printf("topStudent: %s\n",topStudent);
		switch (topStudent) {
			case "1.0":
				nameStudent = "armando";
				break;
			case "2.0":
				nameStudent = "nicolas";
				break;
			case "3.0":
				nameStudent = "daniel";
				break;
			case "4.0":
				nameStudent = "maria";
				break;
			case "5.0":
				nameStudent = "marcela";
				break;
			case "6.0":
				nameStudent = "alexandra";
				break;
	
			default:
				break;
		}
//		FIN RUTINA
		System.out.printf("%d\n",flagExamsMean);
		System.out.printf("%d\n",flagOutstandingGrades);
		System.out.printf("%s\n", subjectRequest );
		System.out.printf("%s\n", nameStudent );
	}
}
