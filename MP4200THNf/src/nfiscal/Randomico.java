package nfiscal;

import java.util.Random;

public class Randomico {
	public static void main(String[] args) {
		//16221162191514321
		//instância um objeto da classe Random especificando a cement
				Random gerador = new Random(976120);
			    
				//imprime sequência de 10 números inteiros aleatórios entre 0 e 25
			    for (int i = 0; i < 10; i++) {
			    	 System.out.print(gerador.nextInt(26));
				 }
			   
			}
}
