from flask import Flask, render_template, url_for, request
import hashlib
import os
from random import randrange



class BruteForce:
    h = hashlib.sha256()
    def __init__(self, str_hash):
        self.h.update(str_hash)
    def verifica_hash(self, str_atual):
        h1 = hashlib.sha256()
        h1.update(str_atual.encode())
        return self.h.hexdigest() == h1.hexdigest()

passo = 100000 
i = -passo 

senha = ""


basedir = os.path.abspath(os.path.dirname(__file__))
arq = open(basedir + '\\wordlist.txt', 'r',  errors='ignore')
lista_arq = arq.readlines()
len_lista_arq = len(lista_arq)
print(len_lista_arq)



print(f'Senha escolhida:  elsewehere')
breaker = BruteForce(b'elsewehere\n')


app = Flask(__name__)

 
@app.route('/')
def index():
    print(f'{request.remote_addr} -> Está na raiz')
    global i
    print(f'Server -> Indice: {i}')
    global senha
    if senha != "":
        return render_template('descoberta.html', senha = senha)
    return render_template('index.html')


@app.route('/falha', methods=['GET', 'POST'])
def falha():
    global i
    print(f'{request.remote_addr}  Senha nao quebrada')
    print(f'Indice: {i}')
    return render_template('falha.html')
	
	
@app.route('/quebrar', methods=['GET', 'POST'])
def quebrar_senha():
    global i
    print(f'{request.remote_addr} -> Quebrando...')
    print(f'Server -> Indice: {i}')
    i = i + passo
    if (i == len_lista_arq):
        i = -passo
    return render_template('quebrar.html', arq = lista_arq[i:i + passo], breaker = breaker)



@app.route('/exito', methods=['GET', 'POST'])
def exito():
    global i
    global senha
    senha = request.form["senha"]
    print(f'{request.remote_addr} Quebrou a senha {senha}')
    print(f'{request.remote_addr} A senha encontrada foi: {senha}')
    print(f'Server -> Indice: {i}')
    return render_template('exito.html', senha = senha)


if __name__ == '__main__':
    print('Server -> Iniciando...')
    print(f'Server -> Indice: {i}')
    app.run(host = '127.0.0.1', port=5000, debug = False)
