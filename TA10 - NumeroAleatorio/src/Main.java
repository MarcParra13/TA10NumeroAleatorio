import java.util.InputMismatchException;
import java.util.Scanner;

class NumeroAleatorio {
	//Atributos de la clase NumeroAleatorio
	static int numMin = 1;
	static int numMax = 500;
	static int numeroAleatorio = generarNumero();
	static int contIntentos = getContIntentos();
	
	//Método para generar un número aletorio
	public static int generarNumero() {
		
		int numeroAleatorio = (int) (Math.random() * numMax + numMin);
		
		return numeroAleatorio;
	}
	
	/*Método para preguntar al usuario los números y 
	comprobar si el número del usuario es correcto y 
	si es mayor o menor que el numero aletaorio*/
	public static void comprobarNumero() {
		Scanner teclado = new Scanner (System.in);
		int numeroUsuario = 0;
		boolean salirBucle = false;
		
		while (salirBucle == false) {
			try {
				System.out.println("Introduce un número para intentar adivinar el número aletorio (1-500)");
				numeroUsuario = teclado.nextInt();
				
				contIntentos++;
				
				if (numeroUsuario == numeroAleatorio) {
					salirBucle = true;
					break;
				}
				
				System.out.println();
				
				if (numeroUsuario > numeroAleatorio) {
					System.out.println("El número que tienes que adivinar es MENOR que el que has introducido");
				} else {
					System.out.println("El número que tienes que adivinar es MAYOR que el que has introducido");
				}
			} catch (InputMismatchException ex) {
				System.out.println("\nTienes que introducir un número entero!");
				teclado.next();
			}
		}
	}
	
	//Método para conseguir el número de intentos
	public static int getContIntentos() {
		return contIntentos;
	}
}

public class Main {

	public static void main(String[] args) {
		
		//Lamamos al método generarNumero de la clase NumeroAleatorio
		NumeroAleatorio.generarNumero();
		
		//Lamamos al método comprobarNumero de la clase NumeroAleatorio
		NumeroAleatorio.comprobarNumero();
		
		////Lamamos al método getContIntentos de la clase NumeroAleatorio y printamos por pantalla
		System.out.println("\nEnhorabuena! El número de intentos ha sido de " + NumeroAleatorio.getContIntentos());

	}
}
