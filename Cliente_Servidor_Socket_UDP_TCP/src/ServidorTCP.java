import java.io.InputStream;
import java.net.*;
public class ServidorTCP {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5875);
        System.out.println("Aguardando conexão na porta 7777...");
        Socket conexaoCliente = ss.accept();
        System.out.println("Conexão estabelecida com o cliente!");
        InputStream entrada = conexaoCliente.getInputStream();
        byte[] dadosRecebidos = new byte[100];
        System.out.println("Aguardando mensagem...");
        entrada.read(dadosRecebidos);
        String mensagem = new String(dadosRecebidos);
        System.out.println("Mensagem recebida: " + mensagem);
        conexaoCliente.close();
        ss.close();
    }
}

