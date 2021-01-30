package eCommerce;
import javax.xml.ws.Endpoint;
 
public class EcommerceServerPublisher {
 
  public static void main(String[] args)
  {
    Endpoint.publish("http://127.0.0.1:7777/eCommerce", new EcommerceServerImpl(10));
  }
}