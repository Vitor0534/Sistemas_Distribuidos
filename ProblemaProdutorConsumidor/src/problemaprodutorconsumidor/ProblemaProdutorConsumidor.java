package problemaprodutorconsumidor;
import java.util.ArrayList; //biblioteca para se usar a estrutura de lista 
import java.lang.Math;      //biblioteca para usar função de numero aleatório double
import java.util.Random;    //bibloteca para usar a função de numero aleatório
import java.util.Scanner;  // Import the Scanner class
            /* a class scanner pode-se ler valores do tecladop
               w=obj.nextline() --- string
               w=obj.nextint()  --- int
               w=obj.nextchar() --- char
*/
import java.util.concurrent.locks.ReentrantReadWriteLock; // biblioteca para usar funções de lock
//essas funções server para tratar erros de leitura e escrita e de visibiliade 
// do buffer por várias threads

/**
 *
 * @author Vitor
 */

//vetores e listas quando mandados por parametro são "referênciados"
//quando se retira um item da lista todos são deslocados para a esquerda

//consumer tira um item da lista
//worker coloca um item na lsita

class Consumer implements Runnable {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    //cadeado usado para quando se tem concorrencia de threds do tipo
    //varios leitores e 1 escritor, so pode uma escrever por vez
    //tanto o consumer quando o worker retiram retiram e colocam coisas 
    //no buffer, logo os dois são scritores
    criaObjetos cria=new criaObjetos();
    ArrayList<Integer> buffer;  
    String nome;
    int tam;
    public Consumer(ArrayList<Integer> arr, String nome, int tamanho) {
        this.buffer = new ArrayList<Integer>(tamanho);
        this.buffer = arr;
        this.nome=nome;
        this.tam=tamanho;
    }

    @Override
    public void run() {
        while (true) {
            lock.writeLock().lock();
            try {
                
            Random r = new Random();
            int x= r.nextInt((5000 - 1000) + 1) + 1000;
             
            Thread.sleep(x); //tempo aleatório para consumer cosumir 1 a 5 segundos
      
              if(buffer.isEmpty()){
                 System.out.println("buffer está vazio " +nome + " em espera...");
               //  Thread.sleep(8000);
              }else{
                  System.out.println(nome + " está consumindo!" );
                  buffer.remove(0);
                  cria.imprimeBuffer(buffer);
              }
              
            }
            catch (Exception erro) {
                System.out.println(nome + "Deu pau...");
            }finally{
                lock.writeLock().unlock();
            }
        }
    }
        
}




class Worker implements Runnable {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    criaObjetos cria=new criaObjetos();
    ArrayList<Integer> buffer;  
    String nome;
    int tam;
    public Worker (ArrayList<Integer> arr, String nome, int tamanho) {
        this.buffer =new ArrayList<Integer>(tamanho); 
        this.buffer=arr;
        this.nome=nome;
        this.tam=tamanho;
    }

    @Override
    public void run() {
        
        while (true) {
            lock.writeLock().lock();
            try {
                
             Random r = new Random();
             int x= r.nextInt((5000 - 1000) + 1) + 1000;
             
             Thread.sleep(x); //tempo aleatório para worker produzir 1 a 5 segundos
    
              if(buffer.size()== tam){
                  System.out.println("buffer está cheio " + nome + " em espera...");
                  
              }else{
                  System.out.println(nome + " está colocando item!" );
                  buffer.add(1);
                  cria.imprimeBuffer(buffer);
              }
              
            }
            catch (Exception erro) {
                System.out.println(nome + "Deu pau...");
            }finally{
                lock.writeLock().unlock();
            }
        }
        
        
       
    }
    
}

class criaObjetos{
    
    public void criaObj(int Workers, int Cons, 
            int tamanhoBuffer)
    {
        ArrayList<Integer> arr = new ArrayList<Integer>(tamanhoBuffer);
        ArrayList<Worker> worker = new ArrayList<Worker>(Workers);
        ArrayList<Consumer> consumers = new ArrayList<Consumer>(Cons);
        
        for(int i=0;i<Workers;i++)
        { 
            //In Java, you can use Integer.parseInt() to convert a String to int
            //Convert using Integer.toString(int) The Integer class has a static
            //method that returns a String object representing the specified int parameter. ...
            //Convert using String.valueOf(int) ...
            
            Worker aux=new Worker(arr,"W"+String.valueOf(i+1),tamanhoBuffer);
            worker.add(aux);
            Thread tW1= new Thread(aux);
            tW1.start();   
        }
        for(int i=0;i<Cons;i++)
        { 
            Consumer aux=new Consumer(arr,"C"+String.valueOf(i+1),tamanhoBuffer);
            consumers.add(aux);
            Thread tC1= new Thread(aux);
            tC1.start();   
        }
        
    }
    
    public void Infos(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("insira o número de workers: ");
        int w=myObj.nextInt();
        System.out.println("insira o número de Consumers: ");
        int c=myObj.nextInt();
        System.out.println("insira o tamanho do buffer: ");
        int b=myObj.nextInt();
        
        criaObjetos cria=new criaObjetos();
        cria.criaObj(w,c,b);
    }
    
    public void imprimeBuffer(ArrayList<Integer> arr)
    {
        System.out.print("[");
        for(int i=0;i<arr.size();i++)
        {
            if(i==0)
              System.out.print(arr.get(i));
            else
              System.out.print(","+arr.get(i));
                
            
            
        }
        System.out.println("]");
    }
    
}

public class ProblemaProdutorConsumidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          
       // int tamanhoBuffer=5; //variável para fixar o tamanho total do buffer
        
        //ArrayList<Integer> arr = new ArrayList<Integer>(tamanhoBuffer); 
        
        criaObjetos cria=new criaObjetos();
        cria.Infos();
        
        
        

//        //Criando os consumers
//        Consumer C1=new Consumer(arr,"C1",tamanhoBuffer);
//        Consumer C2=new Consumer(arr,"C2",tamanhoBuffer);
//        Consumer C3=new Consumer(arr,"C3",tamanhoBuffer);
//        
//        //Criando os workers
//        Worker W1 = new Worker(arr,"W1",tamanhoBuffer);
//        Worker W2 = new Worker(arr,"W2",tamanhoBuffer);
//        Worker W3 = new Worker(arr,"W3",tamanhoBuffer);
//        
//        
//        //criando as treds para os workes 
//        Thread tW1= new Thread(W1);
//        Thread tW2= new Thread(W2);
//        Thread tW3= new Thread(W3);
//        
//        //criando as treds para os consumers
//        Thread tC1= new Thread(C1);
//        Thread tC2= new Thread(C2);
//        Thread tC3= new Thread(C3);
//        
//        //iniciando os processos de threads 
//        tW1.start();
//        tC1.start();
//        tW2.start();
//        tC2.start();
//        tW3.start();
//        tC3.start();
       
        
    }
    
}
