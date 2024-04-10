#Faça um programa modularizado em Python com as seguintes funções: 


#a) atualiza_preco(valor): a função deve receber como parâmetro o valor de um produto, calcular e retornar este valor com aumento de 10% 

#b) taxa(valor): a função calcula e retorna o valor da taxa de 2.5% sobre o valor do produto atualizado (após a chamada da função atualiza_preco). 

#c) main(): terá o programa principal que deve, nesta ordem, fazer a entrada via teclado (digitada pelo usuário) do valor do produto, depois chamar as funções atualiza_preco e taxa e apresentar os valores calculados do valor atualizado com duas casas decimais e do valor da taxa também com duas casas decimais. 

#Ao final, chame a função main() para que o programa seja executado. 


def valorPagamento(valor,dias):
  if dias<=0:
    return valor
  else:
    cobranca=((valor*1.03)+(valor*0.001*dias))
    return cobranca