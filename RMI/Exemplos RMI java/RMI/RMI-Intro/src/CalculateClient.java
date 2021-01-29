import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CalculateClient {
    public static void main(String[] args) {
        try {
            Calculate remoteCalculate = (Calculate) Naming.lookup("rmi://localhost:1234/calculate");
            System.out.println("Remote Addition Result : " + remoteCalculate.add(4, 5));
            System.out.println("Remote Subtraction Result : " + remoteCalculate.sub(4, 3));               
            System.out.println("Remote Multiplication Result : " + remoteCalculate.mul(3, 6));
            System.out.println("Remote Division Result : " + remoteCalculate.div(9, 3));
        }
        catch (MalformedURLException me) {
            System.out.println("MalformedURLException" + me);
        }
        catch (RemoteException re) {
            System.out.println("RemoteException" + re);
        }
        catch (NotBoundException ne) {
            System.out.println("NotBoundException" + ne);
        }
        catch (java.lang.ArithmeticException ae) {
            System.out.println("ArithmeticException" + ae);
        }
    }
}