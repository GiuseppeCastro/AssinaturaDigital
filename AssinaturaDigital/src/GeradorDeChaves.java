import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class GeradorDeChaves {
    public static KeyPair gerarChaves() throws Exception {
        
        KeyPairGenerator geradorChaves = KeyPairGenerator.getInstance("RSA");
        
        geradorChaves.initialize(2048);
        
        // Gera o par de chaves
        return geradorChaves.generateKeyPair();
    }
}