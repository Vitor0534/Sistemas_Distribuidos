Autor: Vitor de Almeida Silva

# Português:
Implementação do problema produtor consumidor em RMI. O programa agora utiliza de uma interface que serve para implementar os metodos remotamente para o cliente e o consumidor. 

o funcionamento do programa é semelhante ao produtor consumidor simples. os conceitos de produtor e consumidor permanecem os mesmos. o produtor é responsável por gerenciar o buffer, o consumidor retira os itens do buffer. porém, como está versão foi implementada com uso de RMI, os serviços de inserir/retirar produto do buffer, são feitos remotamente, por meio da comunicação do produtor/consumidor com o servidor solicitando tais serviços do buffer.

funcionamento:

1- Servidor inicia: usuário insere numero e produtores, consumidores e tamanho do buffer;
2- Os produtores começam a preencher o buffer, por meio da solicitação de serviço de inserção de produto, caso o buffer esteja cheio, o produtor espera até ter espaço no buffer;
3- Ao mesmo tempo o consumidor irá solicitar serviços de retirada de produtos do buffer em tempos aleatórios. sempre que um produto é retirado todos os intens são deslocados uma posição e o produtor insere o novo item no fim;
4 - o programa permanece em loop até que seja parado; 

.
.
.

# English:
Implementation of the producer-consumer problem in RMI. The program now uses an interface that serves to implement the methods remotely for the customer and the consumer.

the program works similarly to the simple consumer-producer. the concepts of producer and consumer remain the same. the producer is responsible for managing the buffer, the consumer removes the items from the buffer. however, as this version was implemented using RMI, the services of inserting/removing products from the buffer are done remotely, through the communication between the producer/consumer and the server requesting such services from the buffer.

operation:

1- Server starts: user enters number and producers, consumers and buffer size;
2- Producers start filling the buffer, by requesting a product insertion service, if the buffer is full, the producer waits until there is space in the buffer;
3- At the same time, the consumer will request services to remove products from the buffer at random times. whenever a product is removed, all intensities are moved to a position and the producer inserts the new item at the end;
4 - the program remains in loop until it is stopped;
