import java.net.*;

public class ObjetoRemoto implements AcoesRemotas {

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        if (dono != "") {
            this.dono = dono;
        } else {
            dono = "Fulano"; //default
        }
    }

    private String dono;
    private String ip;
    
    @Override
    public String quemSouEu() {
        System.out.println("invocando método quemSouEu()");
        return "Eu sou o objeto do " + dono;
    }

    @Override
    public String qualMeuIP() {
        try {
            System.out.println("invocando método qualMeuIP()");
            return InetAddress.getLocalHost().toString();
        } catch (Exception e) {
            return "";
        }
    } 
}
