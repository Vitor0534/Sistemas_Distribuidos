import java.rmi.Remote;
import java.rmi.RemoteException;



class Item {
    int id;
    String conteudo;

    public Item(int id, String conteudo) {
        this.id = id;
        this.conteudo = conteudo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
    
}

public interface BufferRemoto extends Remote {
    public boolean inserir (Item i) throws RemoteException;
    public Item remover() throws RemoteException;
}
