import java.net.*;
import java.util.ArrayList;


 

class Comida{
        // Tamanho do Buffer, quantidade de comidas que ele armazena
	public int tamanho = 10;
	public ArrayList<Integer> buffer = new ArrayList<>(5);
	
}	


public class Buffer {
    public static void main(String[] args) throws Exception {
        DatagramSocket conexaoServidor = new DatagramSocket(7777);
        Comida comida = new Comida();
  
        while(true) {
            byte[] dadosRecebidos = new byte[100];
            DatagramPacket pacoteRecebido = new DatagramPacket(dadosRecebidos,100);
            conexaoServidor.receive(pacoteRecebido);
            String ipCliente = pacoteRecebido.getSocketAddress().toString();
            String dados = new String(pacoteRecebido.getData());
            
            
            //Nao sei pq, mas se eu tirar o split o if nao funciona...
            //Se eu tirar o split não funciona...Chega o texto certinho, vi pelo debugador que os tipos estão certinhos, mas na hora do if, ele nao entra no if
            String[] conteudo = dados.split(":");
            String acao = conteudo[0];
            
            //System.out.print(dados);
            String cons="Consumidor";
            String prod="Produtor";
            String mensagem = "ok:ok";
            //int valor = Integer.parseInt(conteudo[1].trim());


            if (acao.equals(cons)){	//Mensagem do Consumidor)
            	if (!comida.buffer.isEmpty()){
                    comida.buffer.remove(0);
                    System.out.println("Cód: 2, " +ipCliente+" Comida Consumida com sucesso! Quantidade Itens Buffer:" + comida.buffer.size());
                    mensagem = "ok:ok";
                }else{
                    System.out.println("Cód: 3, " +ipCliente+ "Cód:  Erro ao consumir comida, Buffer vazio! Quantidade Itens Buffer:" + comida.buffer.size());
                    mensagem = "erro:erro";
                }  
        
            }

            if(acao.equals(prod)) {	//Mensagem do Produtor
            	if (comida.buffer.size() <= comida.tamanho){
                    comida.buffer.add(1);
                    System.out.println("Cód: 0, " + ipCliente+" Comida produzida com sucesso no Buffer! Quantidade Itens Buffer:" + comida.buffer.size());
                    mensagem = "ok:ok";
                    
                }else{ 
                    System.out.println("Cód: 1, " +ipCliente+" Erro ao produzir comida, Buffer cheio! Quantidade Itens Buffer:" + comida.buffer.size());
                    mensagem = "erro:erro";
                }
            
            }

            // Devolvendo Mensagens para o Consumidor
            byte[] dadosEnviados = mensagem.getBytes();
            
            //Envia a Mensagem para o Servidor
            DatagramPacket pacoteEnviado = 
                    new DatagramPacket(dadosEnviados, dadosEnviados.length, 
                            pacoteRecebido.getAddress(), pacoteRecebido.getPort());
            conexaoServidor.send(pacoteEnviado);
        }
    }
}
