import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1234);
            while(true)   
            {
            Hello stub = (Hello) registry.lookup("Hello");    //isso aqui comunica direto com a interface
                                                              //é como criar um obj normal e usar suas funções
                                                             //mas a implementação do que faz fica no servidor, ele só recebe o retorno 
            String response = stub.sayHello();
            System.out.println("response: " + response);
            }
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
