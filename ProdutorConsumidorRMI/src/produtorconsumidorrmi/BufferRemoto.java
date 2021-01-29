package produtorconsumidorrmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Vitor
 */
//implementação da interface que irá servir para implementar os metodos remotadmente para
//o cliente e o consumidor 

public interface BufferRemoto extends Remote{
    
    public boolean inserirItem(int item) throws RemoteException;
    public int removerItem() throws RemoteException;
    public String imprimirBuffer() throws RemoteException;
    
}
