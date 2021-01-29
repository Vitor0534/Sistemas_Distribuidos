import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDPMultiplayer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socketCliente = new DatagramSocket();
        int id = new java.util.Random().nextInt(1000);
        String mensagem = "Eu sou o cliente UDP " + id;
        System.out.println("Preparando pacote para ser enviado...");
        byte[] dadosEnviados = mensagem.getBytes();
        InetAddress enderecoServer;
        enderecoServer = InetAddress.getByName("127.0.0.1");
        int portaServer = 8888;
        while(true) {
            DatagramPacket pacoteEnviado = 
                    new DatagramPacket(dadosEnviados, dadosEnviados.length, enderecoServer, portaServer);
            socketCliente.send(pacoteEnviado);
            System.out.println("Pacote enviado!");
        }
        //socketCliente.close();
       
    }
}
