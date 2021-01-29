import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class Consumidor{
    public static void main(String[] args) throws Exception {
        DatagramSocket conexaoCliente = new DatagramSocket();
        
        while (true) {
            //Thread.sleep(600);
            
            // Gera um tempo aleatório de 1 até 5 para enviar o pacotinho
            Random gerador = new Random();
            int x = gerador.nextInt(4000)+1000; // Sorteia um número entre 0 a 4000 e soma +1000 ou seja entre 1000 e 5000 ms
            Thread.sleep(x);
            
            //Cria a mensagem a ser enviada para o Servidor
            //Se eu tirar o split não funciona...Chega o texto certinho, vi pelo debugador que os tipos estão certinhos, mas na hora do if, ele nao entra no if
            String mensagem = "Consumidor:teste";
            //System.out.println("Realizando a tentativa de consumir comida!");
            byte[] dadosEnviados = mensagem.getBytes();
            
            InetAddress ipServidor = InetAddress.getByName("127.0.0.1");
            int portaServidor = 7777;
            
            //Envia a Mensagem para o Servidor
            DatagramPacket pacoteEnviado = 
                    new DatagramPacket(dadosEnviados, dadosEnviados.length, 
                            ipServidor, portaServidor);
            conexaoCliente.send(pacoteEnviado);
            
            //Recebe Mensagem do Servidor
            byte[] dadosRecebidos = new byte[100];
            DatagramPacket pacoteRecebido = new DatagramPacket(dadosRecebidos,100);
            conexaoCliente.receive(pacoteRecebido);
            
            //Coloca os dados recebidos em ums String
            String dados = new String(pacoteRecebido.getData());
            //System.out.println(dados);
            
            //Se eu tirar o split não funciona...Chega o texto certinho, vi pelo debugador que os tipos estão certinhos, mas na hora do if, ele nao entra no if
            //Faz o Split do Pacote
            String status="ok";
            String[] conteudo = dados.split(":");
            String acao = conteudo[0]; 
            //System.out.println(acao);
            
            if(acao.equals(status))
                System.out.println("Comida consumida com sucesso!");
            else 
                System.out.println("Falha ao consumir a commida! O Buffer se encontra vazio!");
            
  
        }        
    }
   
}