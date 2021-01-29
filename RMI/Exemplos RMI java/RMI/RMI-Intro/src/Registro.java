import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class Registro {

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1237);
            System.out.println("Registry em execução");
            new Scanner(System.in).next(); //feito só para dar um apausa e não sair direto
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}