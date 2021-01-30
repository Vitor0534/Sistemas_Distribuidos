package eCommerce;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
 
@WebService
@SOAPBinding(style = Style.RPC)
public interface EcommerceServer {
   @WebMethod  public boolean inserirItem(String nome,double preco);
   @WebMethod  public String removerItem (String item);
   @WebMethod  public String MostrarItem (String item);
   @WebMethod  public String imprimirBuffer();
   @WebMethod  public String imprimirComprados();
   @WebMethod  public String AlterarItem (String nome,String NovoNome,double NovoPreco);
   @WebMethod  public String ComprarItem (String nome,String nomeCliente);
}