package nfiscal;

import java.io.FileInputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;




import com.sun.jna.ptr.IntByReference;

import nfiscal.BematechNFiscal;

public class Recibo {
	private static org.apache.log4j.Logger logger = Logger.getLogger(Recibo.class.getName());
	
	
	
	// file;
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		imprimiRecibo("OTICA RUBI","22/11/2017","JORGE","976","JORGE REIDINALDO REBOUCAS DOS SANTOS","900,00","SD12345678","900,00","20/11/2017","00,00","00,00","C:\\rubi.bmp","16221162191514321","1/1","RIACHÃO DO JACUIPE","PRESTACAO");
			
		
	}
		// TODO Auto-generated method stub
		//JOptionPane.showMessageDialog(null,"Favor reiniciar ou ligar a impressora");
		
		//iRetorno = cupom.FechaPorta();
		//iRetorno=cupom.IniciaPorta("USB"); // SE == 0 ERRO DE COMUNICAÇÃO
	//	System.out.println(iRetorno);
		/*
		while (iOpc != 0)
		{
		
		
			System.out.println("Elija una opcion:" + "\n");
			System.out.println("<1> Imprime Texto");
			System.out.println("<2> Imprime Bitmap");
			System.out.println("<0> Finalizar");
			
			iOpc = Console.readInt( "\nOpcion -> ");
			//System.out.println(iOpc);
			if (iOpc==12){
				System.out.println("Cabeca levantada:" + "\n");
				System.out.println("Cabeca levantada:" + "\n");
			}
			
			*/
			//switch (iOpc)
			//{
				//case 1:
					
					//iRetorno=cupom.Le_Status();
				//System.out.println("Status"+iRetorno);
		
		
		public static void imprimiRecibo(String nomeLoja,String dataPagamento,String usuarioRecebimento,String codigoCliente,String nomeCliente,String vPago,String numeroRecibo,String vPcla,String vcto,String ju,String mu,String caminhoLogotipo,String chaveSeguranca,String parcela,String cidade,String formaPagamento){
		
			Properties props_1 = new Properties();
			try {
				
			
				FileInputStream file1 = new FileInputStream(
						"C:/Otica/properties.properties");
				props_1.load(file1);
			} catch (Exception e1) {
				logger.info(e1);
				e1.printStackTrace();
			}

		int numeroViasRecibo=Integer.valueOf(props_1.getProperty("numero_vias_recibo"));
			
			
			
			
			int iRetorno;
			int iOpc = -1;
			int i=0;
			BematechNFiscal cupom = BematechNFiscal.Instance;
					iRetorno = cupom.ConfiguraModeloImpressora(7);
					
					iRetorno = cupom.IniciaPorta("USB");
					System.out.println("Status"+iRetorno);
					if(statusImpressora()==false){
					JOptionPane.showMessageDialog(null,"Favor reiniciar ou ligar a impressora");
					}else{
						for( i=0;i<numeroViasRecibo;i++){
					//System.out.println("Status"+iRetorno);
					iRetorno = cupom.ImprimeBitmap(caminhoLogotipo, 0);
					
					
					iRetorno = cupom.FormataTX("************************************************\r\n", 2, 0, 0, 0, 0);
				
					iRetorno = cupom.FormataTX("   RECIBO DE PAGAMENTO\r\n", 2, 0, 0, 1, 1);
					iRetorno = cupom.FormataTX("************************************************\r\n", 2, 0, 0, 0, 0);
					iRetorno = cupom.FormataTX("EMPRESA:"+ nomeLoja+"\r\n", 2, 0, 0, 0, 0);
					iRetorno = cupom.FormataTX("CIDADE:"+ cidade+"\r\n", 2, 0, 0, 0, 0);
					iRetorno = cupom.FormataTX("DATA PAGAMENTO:\r", 2, 0, 0, 0, 1);
				
					
					iRetorno = cupom.FormataTX(dataPagamento+"\r\n", 2, 0, 0, 1, 1);
					iRetorno = cupom.FormataTX("PARCELA:\r", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX(parcela+"\r\n", 2, 0, 0, 1, 1);
					iRetorno = cupom.FormataTX("FUNCIONARIO: \r", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX(usuarioRecebimento+" \r\n", 2, 0, 0, 0, 1);
					
					
					//iRetorno = cupom.FechaPorta();
					//===============================================================================
                     //iRetorno = cupom.ConfiguraModeloImpressora(7);
					
					//iRetorno = cupom.IniciaPorta("USB");
					iRetorno = cupom.FormataTX("CLIENTE:\r", 2, 0, 0, 0, 0);
					
					iRetorno = cupom.FormataTX(codigoCliente+"  "+nomeCliente+"\r\n", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX("------------------------------------------------\r\n", 2, 0, 0, 0, 0);
					iRetorno = cupom.FormataTX("FORMA PAGAMENTO: \r", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX(formaPagamento+" \r\n", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX("VALOR PAGO:  \r", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX(vPago+"\r\n", 2, 0, 0, 1, 1);
					iRetorno = cupom.FormataTX("------------------------------------------------\r\n", 2, 0, 0, 0, 0);
					String vlr=vPago.replace("R","").replace("$","");
					iRetorno = cupom.FormataTX("Valor  |     Venc    |  Juros  |  Multa  |Total\r\n", 2, 0, 0, 0, 0);
					iRetorno = cupom.FormataTX(vPcla+" |  "+vcto+" |"+ju  +"    |"+mu+"    |"+vlr+"\r\n", 2, 0, 0, 0, 0);
					                      
					iRetorno = cupom.FormataTX("------------------------------------------------\r\n", 2, 0, 0, 0, 0);
					
					
					
					
					
					iRetorno = cupom.FormataTX("RECIBO:  \r", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX(numeroRecibo+"\r\n", 2, 0, 0, 1, 1);
					//iRetorno = cupom.FechaPorta();
					
					//================================================================================
					
					// iRetorno = cupom.ConfiguraModeloImpressora(7);
						
					//	iRetorno = cupom.IniciaPorta("USB");
					iRetorno = cupom.ImprimeCodigoQRCODE(1, 7, 0, 10, 1, "Cod:"+codigoCliente+"\nNOME:"+nomeCliente+"\nDATA PAGAMENTO:"+dataPagamento+"\nRECIBO:"+numeroRecibo+"\nVALOR PAGO:"+vPago+"\nCHAVE SEGURANCA"+chaveSeguranca);
					iRetorno = cupom.FormataTX("O Senhor é o meu pastor, nada me faltará 23.1\r\n", 2, 0, 0, 0, 1);
					if(numeroViasRecibo>0 && numeroViasRecibo!=i){
						cupom.AcionaGuilhotina(1);
						} if(numeroViasRecibo==i){
							cupom.AcionaGuilhotina(0);
							}
					
						}	
						cupom.FechaPorta();
						}
					
		}	
		
		public static void imprimiReciboPagamentoAvulso(String nomeLoja,String dataPagamento,String usuarioRecebimento,String nomeCliente,String vPago,String numeroRecibo,String vPcla,String vcto,String ju,String mu,String caminhoLogotipo,String chaveSeguranca,String parcela,String cidade){
			
			Properties props_1 = new Properties();
			try {
				
			
				FileInputStream file1 = new FileInputStream(
						"C:/Otica/properties.properties");
				props_1.load(file1);
			} catch (Exception e1) {
				logger.info(e1);
				e1.printStackTrace();
			}

		int numeroViasRecibo=Integer.valueOf(props_1.getProperty("numero_vias_recibo"));
			
			
			
			
			int iRetorno;
			int iOpc = -1;
			int i=0;
			BematechNFiscal cupom = BematechNFiscal.Instance;
					iRetorno = cupom.ConfiguraModeloImpressora(7);
					
					iRetorno = cupom.IniciaPorta("USB");
					System.out.println("Status"+iRetorno);
					if(statusImpressora()==false){
					JOptionPane.showMessageDialog(null,"Favor reiniciar ou ligar a impressora");
					}else{
						for( i=0;i<numeroViasRecibo;i++){
					//System.out.println("Status"+iRetorno);
					iRetorno = cupom.ImprimeBitmap(caminhoLogotipo, 0);
					
					
					iRetorno = cupom.FormataTX("************************************************\r\n", 2, 0, 0, 0, 0);
				
					iRetorno = cupom.FormataTX("   RECIBO DE PAGAMENTO\r\n", 2, 0, 0, 1, 1);
					iRetorno = cupom.FormataTX("************************************************\r\n", 2, 0, 0, 0, 0);
					iRetorno = cupom.FormataTX("EMPRESA:"+ nomeLoja+"\r\n", 2, 0, 0, 0, 0);
					iRetorno = cupom.FormataTX("CIDADE:"+ cidade+"\r\n", 2, 0, 0, 0, 0);
					iRetorno = cupom.FormataTX("DATA PAGAMENTO:\r", 2, 0, 0, 0, 1);
				
					
					iRetorno = cupom.FormataTX(dataPagamento+"\r\n", 2, 0, 0, 1, 1);
					iRetorno = cupom.FormataTX("PARCELA:\r", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX(parcela+"\r\n", 2, 0, 0, 1, 1);
					iRetorno = cupom.FormataTX("FUNCIONARIO: \r", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX(usuarioRecebimento+" \r\n", 2, 0, 0, 0, 1);
					
					
					//iRetorno = cupom.FechaPorta();
					//===============================================================================
                     //iRetorno = cupom.ConfiguraModeloImpressora(7);
					
					//iRetorno = cupom.IniciaPorta("USB");
					iRetorno = cupom.FormataTX("CLIENTE:\r", 2, 0, 0, 0, 0);
					
					iRetorno = cupom.FormataTX(" "+nomeCliente+"\r\n", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX("VALOR PAGO:  \r", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX(vPago+"\r\n", 2, 0, 0, 1, 1);
					iRetorno = cupom.FormataTX("------------------------------------------------\r\n", 2, 0, 0, 0, 0);
					String vlr=vPago.replace("R","").replace("$","");
					iRetorno = cupom.FormataTX("Valor  |     Venc    |  Juros  |  Multa  |Total\r\n", 2, 0, 0, 0, 0);
					iRetorno = cupom.FormataTX(vPcla+" |  "+vcto+" |"+ju  +"    |"+mu+"    |"+vlr+"\r\n", 2, 0, 0, 0, 0);
					                      
					iRetorno = cupom.FormataTX("------------------------------------------------\r\n", 2, 0, 0, 0, 0);
					
					
					
					
					
					iRetorno = cupom.FormataTX("RECIBO:  \r", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX(numeroRecibo+"\r\n", 2, 0, 0, 1, 1);
					//iRetorno = cupom.FechaPorta();
					
					//================================================================================
					
					// iRetorno = cupom.ConfiguraModeloImpressora(7);
						
					//	iRetorno = cupom.IniciaPorta("USB");
					iRetorno = cupom.ImprimeCodigoQRCODE(1, 7, 0, 10, 1,"\nNOME:"+nomeCliente+"\nDATA PAGAMENTO:"+dataPagamento+"\nRECIBO:"+numeroRecibo+"\nVALOR PAGO:"+vPago+"\nCHAVE SEGURANCA"+chaveSeguranca);
					iRetorno = cupom.FormataTX("O Senhor é o meu pastor, nada me faltará 23.1\r\n", 2, 0, 0, 0, 1);
					if(numeroViasRecibo>0 && numeroViasRecibo!=i){
						cupom.AcionaGuilhotina(1);
						} if(numeroViasRecibo==i){
							cupom.AcionaGuilhotina(0);
							}
					
						}	
						cupom.FechaPorta();
						}
					
		}	
		public static void imprimiReciboPagamentoParcial(String nomeLoja,String dataPagamento,String usuarioRecebimento,String codigoCliente,String nomeCliente,String vPago,String vDifer,String numeroRecibo,String vPcla,String vcto,String ju,String mu,String caminhoLogotipo,String chaveSeguranca,String parcela,String cidade){
			
			int iRetorno;
			int iOpc = -1;
			int i=0;
			//int qde=1;
			
				

			Properties props_1 = new Properties();
			try {
				
			
				FileInputStream file1 = new FileInputStream(
						"C:/Otica/properties.properties");
				props_1.load(file1);
			} catch (Exception e1) {
				logger.info(e1);
				e1.printStackTrace();
			}

		int numeroViasRecibo=Integer.valueOf(props_1.getProperty("numero_vias_recibo"));
				
			
			BematechNFiscal cupom = BematechNFiscal.Instance;
					iRetorno = cupom.ConfiguraModeloImpressora(7);
					
					iRetorno = cupom.IniciaPorta("USB");
					System.out.println("Status"+iRetorno);
					if(statusImpressora()==false){
					JOptionPane.showMessageDialog(null,"Favor reiniciar ou ligar a impressora");
					}else{
						//while(qde!=numeroViasRecibo){
						for( i=0;i<numeroViasRecibo;i++){
					//System.out.println("Status"+iRetorno);
					iRetorno = cupom.ImprimeBitmap(caminhoLogotipo, 0);
					
					
					iRetorno = cupom.FormataTX("************************************************\r\n", 2, 0, 0, 0, 0);
				
					iRetorno = cupom.FormataTX("   RECIBO DE PAGAMENTO\r\n", 2, 0, 0, 1, 1);
					iRetorno = cupom.FormataTX("************************************************\r\n", 2, 0, 0, 0, 0);
					iRetorno = cupom.FormataTX("EMPRESA:"+ nomeLoja+"\r\n", 2, 0, 0, 0, 0);
					iRetorno = cupom.FormataTX("CIDADE:"+ cidade+"\r\n", 2, 0, 0, 0, 0);
					iRetorno = cupom.FormataTX("DATA PAGAMENTO:\r", 2, 0, 0, 0, 1);
				
					
					iRetorno = cupom.FormataTX(dataPagamento+"\r\n", 2, 0, 0, 1, 1);
					iRetorno = cupom.FormataTX("PARCELA:\r", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX(parcela+"\r\n", 2, 0, 0, 1, 1);
					iRetorno = cupom.FormataTX("FUNCIONARIO: \r", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX(usuarioRecebimento+" \r\n", 2, 0, 0, 0, 1);
					
					
					//iRetorno = cupom.FechaPorta();
					//===============================================================================
                     //iRetorno = cupom.ConfiguraModeloImpressora(7);
					
					//iRetorno = cupom.IniciaPorta("USB");
					iRetorno = cupom.FormataTX("CLIENTE:\r", 2, 0, 0, 0, 0);
					
					iRetorno = cupom.FormataTX(codigoCliente+"  "+nomeCliente+"\r\n", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX("VALOR PARCELA:  \r", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX(vPcla+"\r\n", 2, 0, 0, 1, 1);
					iRetorno = cupom.FormataTX("VALOR PAGO:  \r", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX(vPago+"\r\n", 2, 0, 0, 1, 1);
					iRetorno = cupom.FormataTX("Diferença Parcela a Pagar:  \r", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX(vDifer+"\r\n", 2, 0, 0, 1, 1);
					
					iRetorno = cupom.FormataTX("------------------------------------------------\r\n", 2, 0, 0, 0, 0);
					String vlr=vPago.replace("R","").replace("$","");
					iRetorno = cupom.FormataTX("Valor  |     Venc    |  Juros  |  Multa  |Total\r\n", 2, 0, 0, 0, 0);
					iRetorno = cupom.FormataTX(vPcla+" |  "+vcto+" |"+ju  +"    |"+mu+"    |"+vlr+"\r\n", 2, 0, 0, 0, 0);
					                      
					iRetorno = cupom.FormataTX("------------------------------------------------\r\n", 2, 0, 0, 0, 0);
					
					
					
					
					
					iRetorno = cupom.FormataTX("RECIBO:  \r", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX(numeroRecibo+"\r\n", 2, 0, 0, 1, 1);
					//iRetorno = cupom.FechaPorta();
					
					//================================================================================
					
					// iRetorno = cupom.ConfiguraModeloImpressora(7);
						
					//	iRetorno = cupom.IniciaPorta("USB");
					iRetorno = cupom.ImprimeCodigoQRCODE(1, 7, 0, 10, 1, "Cod:"+codigoCliente+"\nNOME:"+nomeCliente+"\nDATA PAGAMENTO:"+dataPagamento+"\nRECIBO:"+numeroRecibo+"\nVALOR PAGO:"+vPago+"\nCHAVE SEGURANCA"+chaveSeguranca);
					iRetorno = cupom.FormataTX("O Senhor é o meu pastor, nada me faltará 23.1\r\n", 2, 0, 0, 0, 1);
					
					
					if(numeroViasRecibo>0 && numeroViasRecibo !=i){
						cupom.AcionaGuilhotina(1);
						}else if(numeroViasRecibo==i){
							cupom.AcionaGuilhotina(0);
							}
					
						}	
						cupom.FechaPorta();
					
			}
		
		}
					
			/*		
					
					
					
					
iRetorno = cupom.ConfiguraModeloImpressora(7);
					
					iRetorno = cupom.IniciaPorta("USB");
					iRetorno = cupom.ImprimeBitmap(caminhoLogotipo, 0);
					
					iRetorno = cupom.FormataTX("VIA EMPRESA:\r\n", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX("************************************************\r\n", 2, 0, 0, 0, 0);
					iRetorno = cupom.FormataTX("   RECIBO DE PAGAMENTO\r\n", 2, 0, 0, 1, 1);
					iRetorno = cupom.FormataTX("************************************************\r\n", 2, 0, 0, 0, 0);
					iRetorno = cupom.FormataTX("EMPRESA:"+nomeLoja+"\r\n", 2, 0, 0, 0, 0);
					iRetorno = cupom.FormataTX("CIDADE:"+ cidade+"\r\n", 2, 0, 0, 0, 0);
					
					iRetorno = cupom.FormataTX("DATA PAGAMENTO:\r", 2, 0, 0, 0, 1);
					
					iRetorno = cupom.FormataTX(dataPagamento+"\r\n", 2, 0, 0, 1, 1);
					iRetorno = cupom.FormataTX("PARCELA:\r", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX(parcela+"\r\n", 2, 0, 0, 1, 1);
					iRetorno = cupom.FormataTX("FUNCIONARIO: \r", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX(usuarioRecebimento+" \r\n", 2, 0, 0, 0, 1);
					
					
					//iRetorno = cupom.FechaPorta();
					//===============================================================================
                   //  iRetorno = cupom.ConfiguraModeloImpressora(7);
					
					//iRetorno = cupom.IniciaPorta("USB");
					iRetorno = cupom.FormataTX("CLIENTE:\r", 2, 0, 0, 0, 0);
					
					iRetorno = cupom.FormataTX(codigoCliente+"  "+nomeCliente+"\r\n", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX("VALOR PAGO:  \r", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX(vPago+"\r\n", 2, 0, 0, 1, 1);
                    iRetorno = cupom.FormataTX("------------------------------------------------\r\n", 2, 0, 0, 0, 0);
					
					iRetorno = cupom.FormataTX("Valor  |     Venc    |  Juros  |  Multa  |Total\r\n", 2, 0, 0, 0, 0);
					iRetorno = cupom.FormataTX(vPcla+" |  "+vcto+" |"+ju  +"    |"+mu+"    |"+vlr+"\r\n", 2, 0, 0, 0, 0);
						                      
					iRetorno = cupom.FormataTX("------------------------------------------------\r\n", 2, 0, 0, 0, 0);
					
					
					iRetorno = cupom.FormataTX("RECIBO:  \r", 2, 0, 0, 0, 1);
					iRetorno = cupom.FormataTX(numeroRecibo+"\r\n", 2, 0, 0, 1, 1);
					//iRetorno = cupom.FechaPorta();
					
					//================================================================================
					
					// iRetorno = cupom.ConfiguraModeloImpressora(7);
						
						//iRetorno = cupom.IniciaPorta("USB");
					iRetorno = cupom.ImprimeCodigoQRCODE(1, 7, 0, 10, 1, "Cod:"+codigoCliente+"\nNOME:"+nomeCliente+"\nDATA PAGAMENTO:"+dataPagamento+"\nRECIBO:"+numeroRecibo+"\nVALOR PAGO:"+vPago+"\n"+chaveSeguranca);
					iRetorno = cupom.FormataTX("O Senhor é o meu pastor, nada me faltará 23.1\r\n", 2, 0, 0, 0, 1);
					
					if(numeroViasRecibo>1){
					cupom.AcionaGuilhotina(1);
					}
					cupom.FechaPorta();
						}
						cupom.AcionaGuilhotina(0);
					}
					
		}
					
				/*	
				break;	
				case 2:
					iRetorno = cupom.ConfiguraModeloImpressora(7);
					iRetorno = cupom.IniciaPorta("USB");
					iRetorno = cupom.ImprimeBitmap("C:\\rubi.bmp", 0);
					iRetorno = cupom.FechaPorta();
				break;
				*/
					
		//}
		//}
		
		public static boolean statusImpressora()
		{
			int iRetorno;
			BematechNFiscal cupom = BematechNFiscal.Instance;
			iRetorno = cupom.ConfiguraModeloImpressora(7);
			
			iRetorno = cupom.IniciaPorta("USB");
			System.out.println("Status"+iRetorno);
			if(iRetorno==0){
			JOptionPane.showMessageDialog(null,"Favor reiniciar ou ligar a impressora");
			return false;
			}else{
				return true;
			}
		
		}

}





/*
 MP-4200 TH
Conexão Serial
Retorno
Descrição
0
Erro de comunicação
5
Impressora com pouco papel
9
Tampa aberta
24
Impressora "ONLINE"
32
Impressora sem papel
 * 
 */
