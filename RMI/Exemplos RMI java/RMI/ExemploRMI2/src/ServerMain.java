import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ServerMain {
    public static void main(String[] args) {
        try {
            while (true) {
                ObjetoRemoto objeto = new ObjetoRemoto();
                System.out.println("Digite o nome para o objeto a ser registrado: ");
                objeto.setDono(new Scanner(System.in).next());
                AcoesRemotas stub = (AcoesRemotas) UnicastRemoteObject.exportObject(objeto, 0);
                Naming.rebind("rmi://localhost:1234/" + objeto.getDono(), stub);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
