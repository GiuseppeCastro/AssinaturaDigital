import java.security.KeyPair;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Gerando par de chaves RSA...");
            KeyPair parChaves = GeradorDeChaves.gerarChaves();
            
            // Mensagem para o Arthur
            String mensagem = "Fala Arthur! Esta mensagem é do Wallace.";
            System.out.println("\nMensagem original: " + mensagem);
            
            String assinatura = AssinaturaDigital.assinarMensagem(mensagem, parChaves.getPrivate());
            System.out.println("Assinatura gerada: " + assinatura);
            
            boolean assinaturaValida = VerificadorDeAssinatura.verificarAssinatura(
                mensagem, assinatura, parChaves.getPublic());
            System.out.println("\nAssinatura é válida? " + assinaturaValida);
            
            String mensagemAdulterada = mensagem + " [ADULTERADA]";
            boolean assinaturaValidaAposAdulteracao = VerificadorDeAssinatura.verificarAssinatura(
                mensagemAdulterada, assinatura, parChaves.getPublic());
            System.out.println("Assinatura é válida após adulteração? " + assinaturaValidaAposAdulteracao);
            
        } catch (Exception e) {
            System.err.println("Erro durante o processo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}