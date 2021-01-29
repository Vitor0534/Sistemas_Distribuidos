import java.net.*;

public class ObjetoRemoto implements AcoesRemotas {

    String dono;
    String ip;
    public String quemSouEu() {
        return "Eu sou o objeto do " + dono;
    }

    public String qualMeuIP() {
        try {
            return InetAddress.getLocalHost().toString();
        } catch (Exception erro) {
            return "";
        }
    } 
}
