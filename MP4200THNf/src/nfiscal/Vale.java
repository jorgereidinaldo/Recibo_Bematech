package nfiscal;

import javax.swing.JOptionPane;


/*
 * @author Jorge Reidinaldo R Santos
 * @param nomeLoja Nome da loja cadastrada

*/
public class Vale {
	
	public static void main(String[] args) {
		
		imprimiVale("OTICA | RUBI","30/12/2017","JORGE REIDINALDO","ENERGIA","PAGAMENTO ENERGIA MES","30,00","123","C:\\Otica\\imagens\\logotipo.png","RIACHAO DO JACUIPE");
		
		}
	
	
	
	
	
	
	
	
	public static void imprimiVale(String nomeLoja,String dataPagamento,String usuarioRecebimento,String fornecedor,String contaPagamento,String tipoDocumento,String vPago,String caminhoLogotipo,String cidadeLoja){
		int iRetorno;
		int iOpc = -1;
		
		BematechNFiscal cupom = BematechNFiscal.Instance;
				iRetorno = cupom.ConfiguraModeloImpressora(7);
				
				iRetorno = cupom.IniciaPorta("USB");
				System.out.println("Status"+iRetorno);
				if(iRetorno==0){
				JOptionPane.showMessageDialog(null,"Favor reiniciar ou ligar a impressora");
				}else{
				//System.out.println("Status"+iRetorno);
				iRetorno = cupom.ImprimeBitmap(caminhoLogotipo, 0);
				
				
				iRetorno = cupom.FormataTX("************************************************\r\n", 2, 0, 0, 0, 0);
			
				iRetorno = cupom.FormataTX("     VALE DE PAGAMENTO\r\n", 2, 0, 0, 1, 1);
				iRetorno = cupom.FormataTX("************************************************\r\n", 2, 0, 0, 0, 0);
				iRetorno = cupom.FormataTX("EMPRESA:"+ nomeLoja+"\r\n", 2, 0, 0, 0, 0);
				iRetorno = cupom.FormataTX("CIDADE:"+ cidadeLoja+"\r\n", 2, 0, 0, 0, 0);
				iRetorno = cupom.FormataTX("DATA PAGAMENTO:\r", 2, 0, 0, 0, 1);
				
				iRetorno = cupom.FormataTX(dataPagamento+"\r\n", 2, 0, 0, 1, 1);
				iRetorno = cupom.FormataTX("FUNCIONARIO: \r", 2, 0, 0, 0, 1);
				iRetorno = cupom.FormataTX(usuarioRecebimento+" \r\n", 2, 0, 0, 0, 1);
				
				
				//iRetorno = cupom.FechaPorta();
				//===============================================================================
                 //iRetorno = cupom.ConfiguraModeloImpressora(7);
				
				//iRetorno = cupom.IniciaPorta("USB");
				iRetorno = cupom.FormataTX("FORNECEDOR:\r", 2, 0, 0, 0, 0);
				
				iRetorno = cupom.FormataTX(fornecedor+"\r\n", 2, 0, 0, 1, 1);
iRetorno = cupom.FormataTX("CONTA:\r", 2, 0, 0, 0, 0);
				
				iRetorno = cupom.FormataTX(contaPagamento+"\r\n", 2, 0, 0, 1, 1);
iRetorno = cupom.FormataTX("TIPO DOCUMENTO:\r", 2, 0, 0, 0, 0);
				
				iRetorno = cupom.FormataTX(tipoDocumento+"\r\n", 2, 0, 0, 1, 1);
				iRetorno = cupom.FormataTX("VALOR PAGO:  \r", 2, 0, 0, 0, 1);
				iRetorno = cupom.FormataTX(vPago+"\r\n", 2, 0, 0, 1, 1);
				iRetorno = cupom.FormataTX(" \r", 2, 0, 0, 0, 1);
				iRetorno = cupom.FormataTX(" \r", 2, 0, 0, 0, 1);
				iRetorno = cupom.FormataTX(" \r", 2, 0, 0, 0, 1);
				iRetorno = cupom.FormataTX("  \r", 2, 0, 0, 0, 1);
				iRetorno = cupom.FormataTX("________________________________________________\r", 2, 0, 0, 0, 1);
				//iRetorno = cupom.FormataTX("------------------------------------------------\r\n", 2, 0, 0, 0, 0);
				
				//iRetorno = cupom.FormataTX("Valor  |     Venc    |  Juros  |  Multa  |Total\r\n", 2, 0, 0, 0, 0);
				//iRetorno = cupom.FormataTX(vPcla+" | "+vcto+"  |"+ju  +"   |"+mu+"   |"+vPago+"\r\n", 2, 0, 0, 0, 0);
				                      
				//iRetorno = cupom.FormataTX("------------------------------------------------\r\n", 2, 0, 0, 0, 0);
				
				
				
			//	iRetorno = cupom.FormataTX("Observação:  \r", 2, 0, 0, 0, 1);
			//	iRetorno = cupom.FormataTX(observacaoJustificativa+"\r\n", 2, 0, 0, 0, 1);
			//	iRetorno = cupom.FormataTX("RECIBO:  \r", 2, 0, 0, 0, 1);
			//	iRetorno = cupom.FormataTX(numeroRecibo+"\r\n", 2, 0, 0, 1, 1);
				//iRetorno = cupom.FechaPorta();
				
				//================================================================================
				
				// iRetorno = cupom.ConfiguraModeloImpressora(7);
					
				//	iRetorno = cupom.IniciaPorta("USB");
				iRetorno = cupom.ImprimeCodigoQRCODE(1, 7, 0, 10, 1, "Fornecedor:"+fornecedor+"\nConta:"+contaPagamento+"\nDATA PAGAMENTO:"+dataPagamento+"\nVALOR PAGO:"+vPago+"\nTipo Document:"+tipoDocumento+"\n");
				iRetorno = cupom.FormataTX("O Senhor é o meu pastor, nada me faltará 23.1\r\n", 2, 0, 0, 0, 1);
				cupom.AcionaGuilhotina(1);
				iRetorno = cupom.FechaPorta();
	
				/*
iRetorno = cupom.ConfiguraModeloImpressora(7);
				
				iRetorno = cupom.IniciaPorta("USB");
				iRetorno = cupom.ImprimeBitmap(caminhoLogotipo, 0);
				
				iRetorno = cupom.FormataTX("VIA EMPRESA:\r\n", 2, 0, 0, 0, 1);
				iRetorno = cupom.FormataTX("************************************************\r\n", 2, 0, 0, 0, 0);
				iRetorno = cupom.FormataTX("     VALE DE PAGAMENTO\r\n", 2, 0, 0, 1, 1);
				iRetorno = cupom.FormataTX("************************************************\r\n", 2, 0, 0, 0, 0);
				iRetorno = cupom.FormataTX("EMPRESA:"+nomeLoja+"\r\n", 2, 0, 0, 0, 0);
				iRetorno = cupom.FormataTX("DATA PAGAMENTO:\r", 2, 0, 0, 0, 1);
				
				iRetorno = cupom.FormataTX(dataPagamento+"\r\n", 2, 0, 0, 1, 1);
				iRetorno = cupom.FormataTX("FUNCIONARIO: \r", 2, 0, 0, 0, 1);
				iRetorno = cupom.FormataTX(usuarioRecebimento+" \r\n", 2, 0, 0, 0, 1);
				
				
				//iRetorno = cupom.FechaPorta();
				//===============================================================================
               //  iRetorno = cupom.ConfiguraModeloImpressora(7);
				
				//iRetorno = cupom.IniciaPorta("USB");
				iRetorno = cupom.FormataTX("NATUREZA:\r", 2, 0, 0, 0, 0);
				
				iRetorno = cupom.FormataTX(naturezaVale+"\r\n", 2, 0, 0, 1, 1);
				iRetorno = cupom.FormataTX("VALOR PAGO:  \r", 2, 0, 0, 0, 1);
				iRetorno = cupom.FormataTX(vPago+"\r\n", 2, 0, 0, 1, 1);
				
				
               // iRetorno = cupom.FormataTX("------------------------------------------------\r\n", 2, 0, 0, 0, 0);
				
				//iRetorno = cupom.FormataTX("Valor  |     Venc    |  Juros  |  Multa  |Total\r\n", 2, 0, 0, 0, 0);
				//iRetorno = cupom.FormataTX(vPcla+" | "+vcto+"  |"+ju  +"   |"+mu+"   |"+vPago+"\r\n", 2, 0, 0, 0, 0);
				                      
				//iRetorno = cupom.FormataTX("------------------------------------------------\r\n", 2, 0, 0, 0, 0);
				
				
				iRetorno = cupom.FormataTX("RECIBO:  \r", 2, 0, 0, 0, 1);
				iRetorno = cupom.FormataTX(numeroRecibo+"\r\n", 2, 0, 0, 1, 1);
				//iRetorno = cupom.FechaPorta();
				
				//================================================================================
				
				// iRetorno = cupom.ConfiguraModeloImpressora(7);
					
					//iRetorno = cupom.IniciaPorta("USB");
				iRetorno = cupom.ImprimeCodigoQRCODE(1, 7, 0, 10, 1, "Natureza:"+naturezaVale+"\nObservacao:"+observacaoJustificativa+"\nDATA PAGAMENTO:"+dataPagamento+"\nRECIBO:"+numeroRecibo+"\nVALOR PAGO:"+vPago+"\n");
				iRetorno = cupom.FormataTX("O Senhor é o meu pastor, nada me faltará 23.1\r\n", 2, 0, 0, 0, 1);
				cupom.AcionaGuilhotina(1);
				cupom.FechaPorta();
				
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
	
				}
	}
	

}
