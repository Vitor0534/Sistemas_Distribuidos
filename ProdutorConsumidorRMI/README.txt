Autor: Vitor de Almeida Silva

Implementa��o do problema produtor consumidor em RMI. O programa agora utiliza de uma interface que serve para implementar os metodos remotamente para o cliente e o consumidor. 

o funcionamento do programa � semelhante ao produtor consumidor simples. os conceitos de produtor e consumidor permanecem os mesmos. o produtor � respons�vel por gerenciar o buffer, o consumidor retira os itens do buffer. por�m, como est� vers�o foi implementada com uso de RMI, os servi�os de inserir/retirar produto do buffer, s�o feitos remotamente, por meio da comunica��o do produtor/consumidor com o servidor solicitando tais servi�os do buffer.

funcionamento:

1- Servidor inicia: usu�rio insere numero e produtores, consumidores e tamanho do buffer;
2- Os produtores come�am a preencher o buffer, por meio da solicita��o de servi�o de inser��o de produto, caso o buffer esteja cheio, o produtor espera at� ter espa�o no buffer;
3- Ao mesmo tempo o consumidor ir� solicitar servi�os de retirada de produtos do buffer em tempos aleat�rios. sempre que um produto � retirado todos os intens s�o deslocados uma posi��o e o produtor insere o novo item no fim;
4 - o programa permanece em loop at� que seja parado; 