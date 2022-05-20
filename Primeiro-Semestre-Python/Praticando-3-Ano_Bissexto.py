#O ano bissexto

print("Insira o ano a ser analisado:\n")  

a = int(input())  

if (a % 400 == 0) or (a % 4 == 0 and a % 100 != 0): 

    print( "O ano é bissexto!") 

else: 

    print( "O ano não é bissexto") 