
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClienteMain {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1234);
            System.out.println("Objetos Cadastrados: ");
            String[] objetos =  registry.list();
            for (String nome : objetos) {
                System.out.println(nome);
            }
            System.out.print("Digite o nome do objeto desejado: ");
            String nome = new Scanner(System.in).next();
            AcoesRemotas stub = (AcoesRemotas) registry.lookup(nome);
            System.out.println(stub.quemSouEu());
            System.out.println(stub.qualMeuIP());
    } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
    
}
