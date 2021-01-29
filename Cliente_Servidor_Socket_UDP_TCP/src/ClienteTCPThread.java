import java.io.OutputStream;
import java.net.*;
public class ClienteTCPThread {
    public static void main(String[] args) throws Exception {
        int id = new java.util.Random().nextInt(1000);
        System.out.println("Conectando ao servidor...");
        Socket conexaoServidor = new Socket("127.0.0.1", 7777);
        System.out.println("Servidor conectado!");
        OutputStream saida = conexaoServidor.getOutputStream();
        String mensagem = "Eu sou o cliente " + id;
        byte[] dadosEnviados = mensagem.getBytes();
        while(true) {
            saida.write(dadosEnviados);
            saida.flush();
            System.out.println("Mensagem foi enviada com sucesso!");
        }
        //conexaoServidor.close();
    }
}
