
import java.rmi.Naming;

public class CalculatorClient {

    public static void main(String[] args) {
        try {
            Calcular c = (Calcular) Naming.lookup("rmi://192.168.107.146:1099/CalculatorService");
            System.out.println(c.sub(41, 43));
            System.out.println(c.add(42, 5));
            System.out.println(c.mul(33, 6));
            System.out.println(c.div(94, 3));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
