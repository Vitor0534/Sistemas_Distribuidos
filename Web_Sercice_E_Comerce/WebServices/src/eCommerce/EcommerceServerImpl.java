package eCommerce;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebService;
 

@WebService(endpointInterface = "eCommerce.EcommerceServer")
public class EcommerceServerImpl implements EcommerceServer {
     
    ArrayList<Item> buffer;
    int tam;
    
    ArrayList<Item> listaComprados;
    
    
    
    EcommerceServerImpl(int tam)
    {
        this.tam=tam;
        buffer=new ArrayList<Item>(this.tam);
        listaComprados=new ArrayList<Item>(this.tam);
    }

   
    @Override
    public boolean inserirItem(String nome, double preco){
       try{
            
            if(buffer.size()==tam)
            {
               return false;  //caso esteja cheio
            }
            else
            {
               Item aux=new Item(nome,preco);
               buffer.add(aux);
               return true;
            }
    
        }catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
        return false;
    }
    
    
    @Override
    public String AlterarItem(String nome,String NovoNome,double NovoPreco){
        
        Item  item1 = null;
        String saida=null;
        if(buffer.isEmpty())
            {
                System.out.println("não tem itens");
                return null;
            }
            else
            {
              for(int i=0;i<this.tam;i++)
              {
                  
                  if(buffer.get(i).getNome().equals(nome))
                  {
                      item1 =buffer.remove(i);
                      Item novo=new Item(NovoNome,NovoPreco);
                      buffer.add(i,novo);
                      
                      break;
                  }
                       
              }
              
              
              
              if(item1!=null){
                  saida="item Alterado: \nnome:"+  item1.getNome() + "\npreco: " + String.valueOf(item1.getPreco());
                  System.out.println(saida);
              }
              else
              {
                  System.out.println("item não encontrado");
              }
              return saida;
            }
        
        
    }
    
    
    @Override
    public String MostrarItem(String item){
        
        Item item1 = null;
        String saida=null;
        if(buffer.isEmpty())
            {
                System.out.println("não tem itens");
                return null;
            }
            else
            {
              for(int i=0;i<this.tam;i++)
              {
                  
                  if(buffer.get(i).getNome().equals(item))
                  {
                      item1=buffer.get(i);
                      break;
                  }
                       
              }
              if(item1!=null){
                  saida="item: \nnome:"+  item1.getNome() + "\npreco: " + String.valueOf(item1.getPreco());
                  System.out.println(saida);
              }
              else
              {
                  System.out.println("item não encontrado");
                  return "Item não encontrado";
              }
              return saida;
              
            }
        
    }
    
    

    @Override
    public String removerItem(String item){
         try{
            
            Item item1 = null; 
            String saida=null;
             
            if(buffer.isEmpty())
            {
                System.out.println("não há itens");
                return null;
            }
            else
            {
                
              for(int i=0;i<this.tam;i++)
              {
                  if(buffer.get(i).getNome().equals(item))
                  {
                      item1=buffer.remove(i);
                      break;
                  }
                       
              }
              
       /*Iterator itr = buffer.iterator(); 
        while (itr.hasNext()) 
        { 
                 String x = (String)itr.next(); 
                 if (x==item) 
                    itr.remove(); 
        }*/
              
              
              if(item1!=null){
                  saida="item removido: \nnome:"+  item1.getNome() + "\npreco: " + String.valueOf(item1.getPreco());
                  System.out.println(saida);
              }
              else
              {
                  System.out.println("item não encontrado");
                  return "Item não econtrado";
              }
              return saida;

            }
            
        }catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
        return null;
    }
    
    
    

    @Override
    public String imprimirBuffer() {
        try
        {
            int size=buffer.size();
            String saida="\n\n*************Lista de itens*************\n\n";
            for(int i=0;i<size;i++)
            {
                saida+="\n<" + String.valueOf(i)+ ">"
                        + ": " + "\n    nome: " +  buffer.get(i).getNome()
                        +"\n    preco: "+ String.valueOf(buffer.get(i).getPreco());
            }
            saida+="\n\n********************************************\n\n";
            return saida;
 
        }catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
        return null;
    }
    
    
    public String montarItem(Item item)
    {
        String saida="nome: "+ item.getNome()+"\npreco: "+ String.valueOf(item.getPreco());
        return saida;
    }

    @Override
    public String ComprarItem(String nome,String nomeCliente) {
        try{
            
            Item item1 = null; 
            String saida=null;
             
            if(buffer.isEmpty())
            {
                System.out.println("não há itens");
                return null;
            }
            else
            {
                
              for(int i=0;i<this.tam;i++)
              {
                  System.out.println("aaa");
                  if(buffer.get(i).getNome().equals(nome))
                  {
                      item1=buffer.remove(i);
                      break;
                  }
                       
              }
              
       /*Iterator itr = buffer.iterator(); 
        while (itr.hasNext()) 
        { 
                 String x = (String)itr.next(); 
                 if (x==item) 
                    itr.remove(); 
        }*/
              
              
              if(item1!=null){
                  saida="item Comprador: \nnome:"+  item1.getNome() + "\npreco: " + String.valueOf(item1.getPreco())
                           + "\ncliente: "+ nomeCliente;
                  System.out.println(saida);
                  listaComprados.add(item1);
              }
              else
              {
                  System.out.println("item: " + nome + " não encontrado");
                  return "item: " + nome + " não encontrado";
              }
              return saida;

            }
            
        }catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
        
        
        
        return null;
    }

    @Override
    public String imprimirComprados() {
        try
        {
            int size=listaComprados.size();
            String saida="\n\n*************Lista de itens Comprados*************\n\n";
            for(int i=0;i<size;i++)
            {
                saida+="\n<" + String.valueOf(i)+ ">"
                        + ": " + "\n    nome: " +  listaComprados.get(i).getNome()
                        +"\n    preco: "+ String.valueOf(listaComprados.get(i).getPreco());
            }
            saida+="\n\n********************************************\n\n";
            return saida;
 
        }catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
        return null;
    }
    
   
}