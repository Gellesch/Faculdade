#consumo medio carro

print("insira o valor de km:\n")  

km = float (input()) 

print("Insira o valor de litros:\n")  

l = float(input()) 

cons = km/l 

if cons  < 8: 

    print( "Venda o carro!") 

elif cons <= 12: 

    print(" Econômico!") 

else: 

    print( "Supereconômico!") 
    