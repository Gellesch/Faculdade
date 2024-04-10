#include <stdio.h>
#include <stdlib.h>
int main()
{
float var1, var2, result;
var1=var2=result=0;
int op;
op=0;
while (op!=9)
  {
    printf("\n * * * Lab03 - Caculadora * * *");
    printf("\n 1 - Somar       ");
    printf("\n 2 - Subtrair    ");
    printf("\n 3 - Multiplicar ");
    printf("\n 4 - Dividir     ");
    printf("\n 9 - Finalizar   ");
     
    do {
        printf ("\n Entre com a opcao ");
        scanf("%d", &op);
    } while ( op == 1 && op == 2 && op == 3 && op == 4 && op == 9);  

   if (op == 1 || op == 2 || op == 3 || op == 4) {
        printf("\n Variavel 1 "); 
        scanf("%f", &var1);
        printf("\n Variavel 2 ");
        scanf("%f", &var2);
        switch(op)
         {
         case 1:
           result = var1 + var2;
           break;
         case 2:
           result = var1 - var2;
           break;
         case 3:
           result = var1 * var2;
           break;
        case 4:
            result = var1 / var2;
        break;
     } // switch   
    printf("\n Resultado %.2f " , result);
   } // if
} // while
return 0;
} // main