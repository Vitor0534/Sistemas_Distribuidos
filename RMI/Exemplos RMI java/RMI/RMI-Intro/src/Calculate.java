import java.rmi.Remote;
public interface Calculate extends Remote {
    public long add(long parameterOne, long parameterTwo)
    throws java.rmi.RemoteException;
    public long sub(long parameterOne, long parameterTwo)
       throws java.rmi.RemoteException;
   public long mul(long parameterOne, long parameterTwo)
       throws java.rmi.RemoteException;
   public long div(long parameterOne, long parameterTwo)
       throws java.rmi.RemoteException;
}
