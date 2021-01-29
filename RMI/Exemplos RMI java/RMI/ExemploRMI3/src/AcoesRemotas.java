import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AcoesRemotas extends Remote {
    String quemSouEu() throws RemoteException;
    String qualMeuIP() throws RemoteException;
}
