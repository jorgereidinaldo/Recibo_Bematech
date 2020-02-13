package nfiscal;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface BematechNFiscal extends Library {

    public BematechNFiscal Instance = (BematechNFiscal) Native.loadLibrary("mp2064", BematechNFiscal.class);

    public int ConfiguraModeloImpressora(int modelo);
    public int IniciaPorta(String porta);
    public int FechaPorta();
    public int FormataTX(String BufTras, int tipoletra, int italic, int sublin, int expand, int enfat);
    public int ImprimeBitmap(String bitmap, int orientacao);
    public  int ImprimeCodigoQRCODE(int errorCorrectionLevel, int moduleSize, int codeType, int QRCodeVersion, int encodingModes, String codeQr);
public int AcionaGuilhotina(int modo);
public int Le_Status();
}
