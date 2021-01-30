package eCommerce;
import java.net.InetAddress;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.Scanner;
 
class EcommerceClient {
 
  public static void main(String args[]) throws Exception {
    URL url = new URL("http://127.0.0.1:7777/eCommerce?wsdl");
    QName qname = new QName("http://eCommerce/","ECommerceServerImplService");
    Service ws = Service.create(url, qname);
    EcommerceServer eCommerce = ws.getPort(EcommerceServer.class);
    
    System.out.println("************escolha o modo**************");
    System.out.println("<1>Servidor;\n<2>consumidor;");
    int escolha=new Scanner(System.in).nextInt();
    
    while(true)
    {
             if(escolha ==1)
             {
                 
                 System.out.println(
                         "************menu Servidor**************"
                         + "\n<1>inserir item;"
                         + "\n<2>remover item;"
                         + "\n<3>mostrar todos os itens;"
                         + "\n<4>mostrar item;"
                         + "\n<5>alterar item;"
                         + "\n<6>listarCompras;");
                 int escolha2=new Scanner(System.in).nextInt();
                 
                 switch(escolha2)
                 {
                     case 1:
                         
                         System.out.println("insira o nome do item: ");
                         String nome=new Scanner(System.in).next();
                         System.out.println("insira o preço do item: ");
                         double preco=new Scanner(System.in).nextDouble();
                         System.out.println(eCommerce.inserirItem(nome,preco));
                         
                         
                         break;
                     case 2:
                         
                         System.out.println("insira o nome do item: ");
                         System.out.println(eCommerce.removerItem(new Scanner(System.in).next()));
                         
                         break;
                     case 3:
                         
                         System.out.println(eCommerce.imprimirBuffer());
                         
                         break;
                     case 4:
                         
                         System.out.println("insira o nome do item: ");
                         System.out.println(eCommerce.MostrarItem(new Scanner(System.in).next()));
                         
                         break;
                     case 5:
                         
                         System.out.println("insira o nome do item:\n ");
                         nome=new Scanner(System.in).next();
                         
                         System.out.println("insira o nome alterado:\n ");
                         String alter = new Scanner(System.in).next();
                         
                         System.out.println("insira o preco alterado:\n ");
                         preco=new Scanner(System.in).nextDouble();
                         
                         System.out.println(eCommerce.AlterarItem(nome,alter,preco));
                         
                         
                         break;
                     case 6:
                         
                         System.out.println(eCommerce.imprimirComprados());

                         break;
                         
                     default:
                         
                         System.out.println("opção inesistente");
                         
                         break;
                     
                 }
                 
             }
             else
             {
                 System.out.println(
                         "************menu Cliente**************"
                         + "\n<1>mostrar todos os itens;"
                         + "\n<2>mostrar item;"
                         + "\n<3>Comprar item;"
                         );
                 int escolha2=new Scanner(System.in).nextInt();
                 
                 switch(escolha2)
                 {
                     case 1:
                         
                         System.out.println(eCommerce.imprimirBuffer());
                         
                         
                         break;
                     case 2:
                         
                         System.out.println("insira o nome do item: ");
                         System.out.println(eCommerce.MostrarItem(new Scanner(System.in).next()));
                         
                         break;
                     case 3:
                         
                         System.out.println("insira o nome do item: ");
                         System.out.println(eCommerce.ComprarItem(new Scanner(System.in).next(),InetAddress.getLocalHost().toString()));
                         
                         break;
            
                         
                     default:
                         
                         System.out.println("opção inesistente");
                         
                         break;
                     
                 }
             }
             
         
    
    }
    
  }
}