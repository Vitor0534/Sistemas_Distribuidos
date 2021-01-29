import java.net.DatagramSocket;
import java.net.DatagramPacket;
public class ServidorUDP {
    public static void main(String[] args) throws Exception{
        System.out.println("Socket UDP 'aberto' na porta 8888");
        DatagramSocket socketServer = new DatagramSocket(8888);
        byte[] dadosRecebidos = new byte[100];
        DatagramPacket pacoteRecebido = new DatagramPacket(dadosRecebidos, 
                dadosRecebidos.length);
        System.out.println("Recebendo pacote...");
        socketServer.receive(pacoteRecebido);
        System.out.println("Pacote recebido!");
        String mensagem = new String(dadosRecebidos);
        System.out.println("Mensagem recebida: " + mensagem);
        socketServer.close();
    }
}
