import java.security.PrivateKey;
import java.security.Signature;
import java.util.Base64;

public class AssinaturaDigital {
    public static String assinarMensagem(String mensagem, PrivateKey chavePrivada) throws Exception {

        // Cria uma instância com o algoritmo SHA256withRSA
        Signature assinador = Signature.getInstance("SHA256withRSA");        
        
        assinador.initSign(chavePrivada);
        
        assinador.update(mensagem.getBytes());
        
        // Gera a assinatura
        byte[] assinatura = assinador.sign();
        
        return Base64.getEncoder().encodeToString(assinatura);
    }
}