package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
 * Ejemplo de lo que tiene que hacer el programa
 * Primer conjunto: {1,2,3}
 * Segundo conjunto: {3,4}
 * 
 * Union = {1, 2, 3, 4} 
 * Intersección = {3}
 * Diferencia asimétrica
 * A-B= {1, 2}
 * B-A= {4}
 * 
 */

public class Main {

	private Set<Integer> set1;
	private Set<Integer> set2;

	private List<Integer>  a;
	private List<Integer>  b;

	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public Main() {
		set1 = new HashSet<Integer>();
		set2 = new HashSet<Integer>();

		a = new ArrayList<Integer>();
		b = new ArrayList<Integer>();
	}

	public static void main(String [] args) {
		Main ppal = new Main();

		ppal.printMessage();
		try {
			ppal.defineElements();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ppal.createSet();
		try {
			ppal.calculate();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

		try {
			ppal.br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printMessage() {
		System.out.println("================================================\n"
				+ "==  BIENVENID@ A LA CALCULADORA DE CONJUNTOS  ==\n"
				+ "================================================\n\n"
				+ "Hola, para utilizar la calculadora sigue los siguientes pasos:\n"
				+ "Paso 1: Digita los elementos del conjunto, seguidos de la tecla ESPACIO\n"
				+ "Paso 2: Oprime ENTER para agregar los elementos del segundo grupo, repite el paso 1\n");
	}

	public void defineElements() throws IOException{
		defineElements("Primer Conjunto: ", 1);
	}

	private void defineElements(String s, int option) throws IOException{

		if(option < 3){

			

			System.out.print(s);
			
			String[] elements = br.readLine().split(" ");
			for (int i = 0; i < elements.length; i++) {
				if (option == 1) {
					a.add(Integer.parseInt(elements[i]));
				}else {
					b.add(Integer.parseInt(elements[i]));
				}
			}
			
			defineElements("Segundo Conjunto: ", option+1);
		}
	}

	public void createSet() {
		set1.addAll(a);
		set2.addAll(b);

		printSets();
	}

	public void printSets() {
		System.out.println("=======================================\n"
				+ "TUS CONJUNTOS: \n"
				+ "A = "
				+ set1 + "\n\nB = "
				+ set2 + "\n=======================================");
	}

	public void menu() {
		System.out.print("CALCULADORA\n"
				+ "Escoge la opcion que deseas realizar:\n"
				+ "(1) Union\n"
				+ "(2) Intersección\n"
				+ "(3) Diferencia asimetrica\n"
				+ "(Otro numero) Para salir\n"
				+ "Opcion: ");
	}

	public void calculate() throws NumberFormatException, IOException{
		menu();
		int opt = Integer.parseInt(br.readLine());
		System.out.println("====================================");
		switch(opt){
		case 1:
			showUnionSet();
			calculate();
			break;
		case 2:
			intersection();
			calculate();
			break;
		case 3:
			difference();
			calculate();
			break;
		default:
			System.out.println("Nos vemos pronto :D");
			break;
		}
	}

	private void showUnionSet(){
		Set<Integer> union = new HashSet<Integer>(set1);
		union.addAll(set2);
		System.out.println("El conjunto union de A y B = " + union 
				+ "\n====================================\n");
	}

	private void intersection(){
		Set<Integer> intion = new HashSet<Integer>(set1);
		intion.retainAll(set2);
		System.out.println("Interseccion entre el conjunto A y B = " + intion
				+ "\n====================================\n");
	}

	private void difference() throws NumberFormatException, IOException{
		System.out.print("Diferencia entre: \n"
				+ "(1) A - B \n"
				+ "(2) B - A \n"
				+ "Opcion: ");

		int opt = Integer.parseInt(br.readLine());
		System.out.println("====================================");

		if(opt == 1 || opt == 2){
			difference(opt);
		}
	}

	private void difference(int o){

		if(o == 1){
			Set<Integer> df = new HashSet<Integer>(set1);
			df.removeAll(set2);
			System.out.println("A - B = " + df
					+ "\n====================================\n");
		} else {
			Set<Integer> df = new HashSet<Integer>(set2);
			df.removeAll(set1);
			System.out.println("B - A = " + df
					+ "\n====================================\n");
		}
	}
}