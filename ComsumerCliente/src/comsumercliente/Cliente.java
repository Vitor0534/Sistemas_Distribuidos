import java.io.OutputStream;
import java.net.*;

public class Cliente {
    public static void main(String[] args){
        try{
        System.out.println("Conectando ao servidor...");
        Socket conexaoServidor = new Socket("127.0.0.1",1111);
        System.out.println("Servidor conectado!");
        OutputStream saida = conexaoServidor.getOutputStream();
        String mensagem = "Oi sumido!";
        byte[] dadosEnviados = mensagem.getBytes();
        saida.write(dadosEnviados);
        saida.flush();
        System.out.println("Mensagem foi enviada com sucesso!");
        conexaoServidor.close();
        }catch(Exception erro)
        {
            System.out.println("deu merda");
        }
    }
}

