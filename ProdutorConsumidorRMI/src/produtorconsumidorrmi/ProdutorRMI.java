package produtorconsumidorrmi;
import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 *
 * @author Vitor
 */
public class ProdutorRMI {
     public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1234);
            
            BufferRemoto stub = (BufferRemoto) registry.lookup("BufferRMI");
            
            while(true){
                boolean test=stub.inserirItem(1);
                if(test)
                {
                    System.out.println("Produtor " + InetAddress.getLocalHost().toString()+ " inserindo");
                    System.out.println(stub.imprimirBuffer());
                }
                else
                {
                    System.out.println("buffer cheio produtor" + InetAddress.getLocalHost().toString()+ " em espera");
                    System.out.println(stub.imprimirBuffer());
                }
            }

    } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
