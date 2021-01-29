import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class CalculateEngine extends UnicastRemoteObject implements Calculate {
    private static final long serialVersionUID = 1L;
    public CalculateEngine() throws RemoteException {
              super();
       }
    @Override
    public long add(long parameterOne, long parameterTwo) throws RemoteException {
        return parameterOne + parameterTwo;
    }
    @Override
    public long sub(long parameterOne, long parameterTwo) throws RemoteException {
        return parameterOne - parameterTwo;
    }
    @Override
    public long mul(long parameterOne, long parameterTwo) throws RemoteException {
        return parameterOne * parameterTwo;
    }
    @Override
    public long div(long parameterOne, long parameterTwo) throws RemoteException {
        return parameterOne / parameterTwo;
    }
}