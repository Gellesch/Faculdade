/*1)  Obtenha o nome e salário dos professores que possuem um salário entre 2500 e 4000 (inclusive estes valores), em ordem decrescente de salário.
*/
SELECT Nome_Professor, Salario 
FROM Professor 
WHERE (Salario BETWEEN 2500 AND 4000)
ORDER BY Salario DESC;

/*2) Obtenha o nome e idade dos alunos cujo nome contenha a letra 'i' e que tenha mais de 19 anos, em ordem crescente do nome do aluno.
*/
SELECT Nome_Aluno, Idade
FROM Aluno 
WHERE(Nome_Aluno LIKE '%i%') AND (Idade > 19)
ORDER BY Nome_Aluno ASC;

/*3) Obtenha a média de idade e a quantidade de alunos do curso de código igual a 1001.
*/
SELECT AVG(Idade) AS Media, COUNT(Matricula) AS Total
FROM Aluno
WHERE (Cod_Curso = 1001);

/*4) Obtenha a nota média que o aluno de matrícula igual a 1 teve nas disciplinas que ele já cursou.
*/
SELECT AVG(Nota) AS Media
FROM Aluno_Disc
WHERE (Matricula = 1);

/*5) Obtenha, para cada matrícula de aluno, a nota média e a quantidade de disciplinas que cada um já cursou (considere somente os alunos que já cursaram alguma disciplina).
*/
SELECT Matricula, AVG(Nota) AS Media, COUNT(Cod_Disciplina) AS Total
FROM Aluno_Disc
GROUP BY Matricula;
