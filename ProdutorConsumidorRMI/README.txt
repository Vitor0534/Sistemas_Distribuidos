Autor: Vitor de Almeida Silva

Implementação do problema produtor consumidor em RMI. O programa agora utiliza de uma interface que serve para implementar os metodos remotamente para o cliente e o consumidor. 

o funcionamento do programa é semelhante ao produtor consumidor simples. os conceitos de produtor e consumidor permanecem os mesmos. o produtor é responsável por gerenciar o buffer, o consumidor retira os itens do buffer. porém, como está versão foi implementada com uso de RMI, os serviços de inserir/retirar produto do buffer, são feitos remotamente, por meio da comunicação do produtor/consumidor com o servidor solicitando tais serviços do buffer.

funcionamento:

1- Servidor inicia: usuário insere numero e produtores, consumidores e tamanho do buffer;
2- Os produtores começam a preencher o buffer, por meio da solicitação de serviço de inserção de produto, caso o buffer esteja cheio, o produtor espera até ter espaço no buffer;
3- Ao mesmo tempo o consumidor irá solicitar serviços de retirada de produtos do buffer em tempos aleatórios. sempre que um produto é retirado todos os intens são deslocados uma posição e o produtor insere o novo item no fim;
4 - o programa permanece em loop até que seja parado; 