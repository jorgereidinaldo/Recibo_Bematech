package nfiscal;

import java.util.Random;

public class Randomico {
	public static void main(String[] args) {
		//16221162191514321
		//inst�ncia um objeto da classe Random especificando a cement
				Random gerador = new Random(976120);
			    
				//imprime sequ�ncia de 10 n�meros inteiros aleat�rios entre 0 e 25
			    for (int i = 0; i < 10; i++) {
			    	 System.out.print(gerador.nextInt(26));
				 }
			   
			}
}
