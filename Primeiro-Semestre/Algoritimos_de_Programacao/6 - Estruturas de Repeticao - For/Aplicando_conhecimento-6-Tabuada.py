#Escreva um programa em Python que leia um número inteiro, entre 0 e 10 e mostre a tabuada deste número multiplicado de 1 até 10.

#O valor de entrada dever ser validado, pois o programa somente aceitará números entre 0 e 10 (inclusive). Caso o valor de entrada 
# esteja fora do intervalo, o programa emitirá a mensagem VALOR INVÁLIDO e solicitará a entrada deste dado até que ela seja válida.

#Com a entrada de dados válida, o programa irá mostrar a tabuada do número digitado no formato do caso de teste.

x=int(input())
while x<0 or x>=11:
  print('VALOR INVÁLIDO')
  x=int(input())
else:  
  for i in range (1,11,1):
    print(f'{x}x{i}={x*i}')
