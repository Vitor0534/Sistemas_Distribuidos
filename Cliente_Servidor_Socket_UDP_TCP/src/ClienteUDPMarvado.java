import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDPMarvado {
    public static void main(String[] args) throws Exception {
        DatagramSocket socketCliente = new DatagramSocket();
        String mensagem = "";
        System.out.println("Preparando pacote para ser enviado...");
        byte[] dadosEnviados = mensagem.getBytes();
        InetAddress enderecoServer;
        enderecoServer = InetAddress.getByName("192.168.61.2");
        int portaServer = 53;
        DatagramPacket pacoteEnviado = 
                new DatagramPacket(dadosEnviados, dadosEnviados.length, enderecoServer, portaServer);
        
        while(true) 
            socketCliente.send(pacoteEnviado);
        
        //System.out.println("Pacote enviado!");
        //socketCliente.close();
       
    }
}
