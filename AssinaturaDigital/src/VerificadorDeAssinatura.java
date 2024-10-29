import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class VerificadorDeAssinatura {
    public static boolean verificarAssinatura(String mensagem, String assinatura, PublicKey chavePublica) 
            throws Exception {
        Signature verificador = Signature.getInstance("SHA256withRSA");        
        verificador.initVerify(chavePublica);        
        verificador.update(mensagem.getBytes());
        byte[] assinaturaBytes = Base64.getDecoder().decode(assinatura);
        
        // Verifica a assinatura
        return verificador.verify(assinaturaBytes);
    }
}