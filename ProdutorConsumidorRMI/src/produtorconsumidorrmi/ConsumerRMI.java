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
public class ConsumerRMI {
    
     public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1234);
            
            BufferRemoto stub = (BufferRemoto) registry.lookup("BufferRMI");
            
            while(true){
                
              int item = stub.removerItem();
              if(item == 0)
              {
                  System.out.println("buffer fazio consumer " + InetAddress.getLocalHost().toString() + "em espera");
              }
              else
              {
                  System.out.println("consumer " + InetAddress.getLocalHost().toString() + " consumindo");
                  System.out.println(stub.imprimirBuffer());
              }

            }

    } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
    
    
}
