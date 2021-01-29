Autor: Vitor de Almeida Silva

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