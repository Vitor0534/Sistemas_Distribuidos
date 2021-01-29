
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor implements Hello {

    String dono = "Rafael";

    @Override
    public String sayHello() {
        return "Oi eu sou o objeto do " + dono;
    }

    public static void main(String args[]) {
        try {
            Servidor obj = new Servidor();

            LocateRegistry.createRegistry(1234);
            Registry registry = LocateRegistry.getRegistry(1234);

            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);
            // Bind the remote object's stub in the registry
            registry.rebind("Hello", stub);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
