package produtorconsumidorrmi;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 *
 * @author Vitor
 */
public class Servidor {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1234);
            System.out.println("Registry em execução");
            BufferRMI buffer;
            System.out.println("Digite tamanho do buffer: ");
            buffer= new BufferRMI(new Scanner(System.in).nextInt());
            BufferRemoto stub = (BufferRemoto) UnicastRemoteObject.exportObject(buffer, 0);
            Naming.rebind("rmi://localhost:1234/BufferRMI", stub);
            while (true) {
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
