Autor: Vitor de Almeida Silva

Implementa��o de algoritmo para problema produtor/consumidor. O presente programa tem 3 partes principais, s�o elas:

- Produtor;
- Consumidor;
- Buffer;

De in�cio o usu�rio deve informar via teclado o numero de consumidores e produtores, como tamb�m o tamanho do buffer a ser usado. O buffer representa um armazenamento de produtor, que � reposto pelos produtores. Deste modo, o Consumidor fica a cargo de retirar retirar os produtos desse armazenamento. Os produtores v�o verificar o buffer para sempre mante-lo cheio de produtos.

funcionamento:

1- usu�rio insere numero e produtores, consumidores e tamanho do buffer;
2- Os produtores come�am a preencher o buffer, caso o buffer esteja cheio, o produtor espera at� ter espa�o no buffer;
3- Ao mesmo tempo o consumidor ir� retirar produtos do buffer em tempos aleat�rios. sempre que um produto � retirado todos os intens s�o deslocados uma posi��o e o produtor insere o novo item no fim;
4 - o programa permanece em loop at� que seja parado; 