import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDP {
    public static void main(String[] args) throws Exception {
        DatagramSocket socketCliente = new DatagramSocket();
        String mensagem = "Oi lindim!";
        System.out.println("Preparando pacote para ser enviado...");
        byte[] dadosEnviados = mensagem.getBytes();
        InetAddress enderecoServer;
        enderecoServer = InetAddress.getByName("127.0.0.1");
        int portaServer = 8888;
        DatagramPacket pacoteEnviado = 
                new DatagramPacket(dadosEnviados, dadosEnviados.length, enderecoServer, portaServer);
        socketCliente.send(pacoteEnviado);
        System.out.println("Pacote enviado!");
        socketCliente.close();
       
    }
}
