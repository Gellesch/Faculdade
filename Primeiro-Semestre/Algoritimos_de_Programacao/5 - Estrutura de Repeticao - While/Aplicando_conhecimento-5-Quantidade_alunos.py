#Faça um programa em Python que solicite a quantidade de alunos de uma turma. 

#Após esta informação, o usuário deve digitar a média de cada aluno da turma, e o programa apresentará a mensagem PARABÉNS, 
#VOCÊ ESTÁ APROVADO aos alunos com média maior ou igual a 6,.0. 

#O programa deve calcular e mostrar, no final da entrada de dados, a média geral da turma.

#Obs.: Caso a quantidade informada de alunos da turma for igual a zero, o programa deve emitir a seguinte mensagem: NÃO HOUVE PROCESSAMENTO

qtd_aluno = int(input())
i = 0
soma = 0
if qtd_aluno != 0:
    while i < qtd_aluno:
        media = float(input())
        soma += media
        i = i + 1
        media_final = soma / qtd_aluno
        if media >= 6:
            print("PARABÉNS VOCÊ ESTÁ APROVADO")
    if media_final >= 6:
        print(media_final)
    if media_final < 6:
        print(media_final)
if qtd_aluno == 0:
    print("NÃO HOUVE PROCESSAMENTO")