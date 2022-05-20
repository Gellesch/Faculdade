#O programa deve ter as seguintes funções: 

#- entrada_carro(): faz a entrada do modelo de quatro carros via teclado (o usuário digitará o modelo de quatro carros); 

#- entrada_consumo(): faz a entrada de um número inteiro que é o consumo (em litros) de cada modelo de carro por quilometro 
# (o usuário digita o consumo correspondente a cada carro); 

#- economico(): retorna o modelo do carro mais econômico. Observe que o modelo do carro e seu consumo estará na mesma posição 
# na lista, porém em vetores diferentes (carro e consumo). 

#A entrada de dados deve ser feita da seguinte forma: 

#- O usuário digitará o modelo de cada um dos quatro carros, linha por linha, seguidas uma da outra. 

#- O usuário digitará o consumo de cada um dos quatro carros, linha por linha. 

#O programa apresentará, na tela, o modelo do carro que tiver o menor valor de consumo.

listacarro=[]
listaconsumo=[]
def entrada_carro():
    for i in range(0,4):
        carro=input()
        listacarro.append(carro)

def entrada_consumo():
    for i in range(0,4):
        consumo=int(input())
        listaconsumo.append(consumo)
def economico():
    if listaconsumo[0]<listaconsumo[1] and listaconsumo[0]<listaconsumo[2]and listaconsumo[0]<listaconsumo[3]:
        return listacarro[0]
    elif listaconsumo[1]<listaconsumo[0] and listaconsumo[1]<listaconsumo[2]and listaconsumo[1]<listaconsumo[3]:
        return listacarro[1]
    elif listaconsumo[2]<listaconsumo[0] and listaconsumo[2]<listaconsumo[1]and listaconsumo[2]<listaconsumo[3]:
        return listacarro[2]
    else:
        return listacarro[3]