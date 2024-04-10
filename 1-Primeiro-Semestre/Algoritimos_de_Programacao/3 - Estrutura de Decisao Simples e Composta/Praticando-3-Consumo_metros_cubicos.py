#Consumo em metros cúbicos:24
#Valor  da conta = 21

consumo = int  (input ("Consumo em metros cúbicos:")) 
if consumo <= 10: 
    conta = 7  
elif consumo>=11 and  consumo<=30: 
    conta = (consumo-10) * 1 + 7  
elif consumo>=31 and  consumo<=100: 
    conta = (consumo-30) * 2 + 27  
else: 
    conta = (consumo-100) * 5 + 167  
print(f'Valor  da conta = {conta}')