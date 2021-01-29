package produtorconsumidorrmi;
import java.net.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
/**
 *
 * @author Vitor
 */
public class BufferRMI implements BufferRemoto{
    
    ArrayList<Integer> buffer;
    int tam;
    
    BufferRMI(int tam)
    {
        this.tam=tam;
        buffer=new ArrayList<Integer>(this.tam);
    }
   
    @Override
    public boolean inserirItem(int item) throws RemoteException {
       try{
            
            if(buffer.size()==tam)
            {
               return false;
            }
            else
            {
               buffer.add(item);
               return true;
            }
    
        }catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int removerItem() throws RemoteException {
         try{
            
            if(buffer.isEmpty())
            {
                System.out.println("buffer fazio cliente");
                return 0;
            }
            else
            {
              int item= buffer.remove(0);
              System.out.println("item consumido: "+  String.valueOf(item));
              
              return item;
            }
            
        }catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String imprimirBuffer() {
        try
        {
            int size=buffer.size();
            String saida="[";
            for(int i=0;i<size;i++)
            {
                saida+=" " + String.valueOf(buffer.get(i));
            }
            saida+=" ]";
            return saida;
 
        }catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
        return null;
    }
    
}

