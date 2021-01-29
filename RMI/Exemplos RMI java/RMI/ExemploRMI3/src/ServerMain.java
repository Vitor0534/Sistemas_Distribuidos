
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ServerMain {

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1234);
            System.out.println("Registry em execução");
            while (true) {
                ObjetoRemoto objeto = new ObjetoRemoto();
                System.out.println("Digite o nome para o objeto a ser registrado: ");
                objeto.dono = new Scanner(System.in).next();
                AcoesRemotas stub = (AcoesRemotas) UnicastRemoteObject.exportObject(objeto, 0);
                Naming.rebind("rmi://localhost:1234/" + objeto.dono, stub);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
