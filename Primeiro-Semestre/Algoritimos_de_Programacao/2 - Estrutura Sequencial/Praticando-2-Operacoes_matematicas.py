
#EXERCÍCIO 1 – Escreva um programa em Python que permita ao usuário digitar dois números inteiros e exibir o resultado para cada uma 
#das seguintes operações: soma, subtração, multiplicação, divisão, divisão truncada, resto e exponenciação. 

n1 = int(input('')) 
n2 = int(input('')) 
 
soma = n1 + n2 
sub = n1 - n2 
mult = n1 * n2 
div = n1 / n2 
div_trunc = n1 // n2 
resto = n1 % n2 
expo = n1 ** n2 
 
print(f'{soma}') 
print(f'{sub}') 
print(f'{mult}') 
print(f'{div}') 
print(f'{div_trunc}') 
print(f'{resto}') 
print(f'{expo}')
 