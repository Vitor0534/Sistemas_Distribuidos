import java.rmi.Naming;
import java.rmi.Remote;
public class MyServer implements Remote{
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {           
            Naming.rebind("rmi://localhost:1237/calculate",new CalculateEngine()); 
            System.out.println("CalculateEngine bound");
            } 
        catch (Exception e) {
              System.err.println("CalculateEngine exception:");
               e.printStackTrace();
            }
     }
}