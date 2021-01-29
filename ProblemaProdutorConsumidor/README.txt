Autor: Vitor de Almeida Silva


# Português: 
Implementação de algoritmo para problema produtor/consumidor. O presente programa tem 3 partes principais, são elas:

- Produtor;
- Consumidor;
- Buffer;

De início o usuário deve informar via teclado o numero de consumidores e produtores, como também o tamanho do buffer a ser usado. O buffer representa um armazenamento de produtor, que é reposto pelos produtores. Deste modo, o Consumidor fica a cargo de retirar retirar os produtos desse armazenamento. Os produtores vão verificar o buffer para sempre mante-lo cheio de produtos.

funcionamento:

1- usuário insere numero e produtores, consumidores e tamanho do buffer;
2- Os produtores começam a preencher o buffer, caso o buffer esteja cheio, o produtor espera até ter espaço no buffer;
3- Ao mesmo tempo o consumidor irá retirar produtos do buffer em tempos aleatórios. sempre que um produto é retirado todos os intens são deslocados uma posição e o produtor insere o novo item no fim;
4 - o programa permanece em loop até que seja parado; 

.
.
.

# English:
Implementation of algorithm for producer/consumer problem. The present program has 3 main parts, which are:

- Producer;
- Consumer;
- Buffer;

The user must initially inform the number of consumers and producers via the keyboard, as well as the size of the buffer to be used. The buffer represents a producer storage, which is replaced by the producers. In this way, the Consumer is in charge of removing the products from that storage. Producers will check the buffer to always keep it full of products.

operation:

1- user enters number and producers, consumers and buffer size;
2- Producers start filling the buffer, if the buffer is full, the producer waits until there is space in the buffer;
3- At the same time the consumer will remove products from the buffer at random times. whenever a product is removed, all intensities are moved to a position and the producer inserts the new item at the end;
4 - the program remains in loop until it is stopped;
