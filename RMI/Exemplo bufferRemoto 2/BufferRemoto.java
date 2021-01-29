import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BufferRemoto extends Remote {
    public boolean inserir(String item) throws RemoteException;
    public String remover() throws RemoteException;
}
