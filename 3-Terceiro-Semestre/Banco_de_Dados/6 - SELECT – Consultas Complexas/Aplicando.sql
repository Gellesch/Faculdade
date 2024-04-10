
/*1)	Obtenha o nome de cada aluno e o nome do curso que cada um pertence.

R:
*/
SELECT A.Nome_Aluno, C.Nome_Curso
FROM Curso C INNER JOIN Aluno A
ON (C.Cod_Curso = A.Cod_Curso);

/*2) Obtenha a maior idade, a menor idade e a idade média dos alunos do curso de 'Ciencia da Computacao'.

R:
*/
SELECT MAX(A.Idade) AS MaxIdade, MIN(A.Idade) AS MinIdade,
AVG(A.Idade) AS MediaIdade
FROM Curso C INNER JOIN Aluno A
ON (C.Cod_Curso = A.Cod_Curso)
WHERE (C.Nome_Curso = 'Ciencia da Computacao');

/*3) Obtenha o nome de cada curso (que tenha aluno) e, para cada curso, a média de idade e a quantidade de alunos.

R:
*/
SELECT C.Nome_Curso, AVG(A.Idade) AS Media, COUNT(A.Cod_Curso) AS Total
FROM Curso C INNER JOIN Aluno A
ON (C.Cod_Curso = A.Cod_Curso)
GROUP BY C.Nome_Curso;

/*4) Obtenha o nome de cada aluno da universidade (mesmo aqueles que não cursaram disciplinas ainda) e a quantidade de disciplinas que cada um já cursou. Retorne em ordem crescente da quantidade de disciplinas e, se houver empate na quantidade, em ordem crescente de nome do aluno.

R:
*/
SELECT A.Nome_Aluno, COUNT(AD.Cod_Disciplina) AS Total_Disc
FROM Aluno A LEFT JOIN Aluno_Disc AD
ON (A.Matricula = AD.Matricula)
GROUP BY A.Nome_Aluno
ORDER BY COUNT(AD.Cod_Disciplina) ASC, A.Nome_Aluno ASC;

/*5) Obtenha o nome das disciplinas que a aluna 'Claudia' cursou e a nota que ela tirou em cada uma das disciplinas.

R:
*/
SELECT D.Nome_Disciplina, AD.Nota
FROM Aluno A INNER JOIN Aluno_Disc AD
ON (A.Matricula = AD.Matricula)
INNER JOIN Disciplina D
ON (AD.Cod_Disciplina = D.Cod_Disciplina)
WHERE (A.Nome_Aluno = 'Claudia');

/*6) Obtenha o nome de cada disciplina e o nome do instituto que cada uma pertence.

R:
*/
SELECT D.Nome_disciplina, I.Nome_Instituto
FROM Disciplina D INNER JOIN Curso C
ON (D.Cod_curso = C.Cod_curso)
INNER JOIN Instituto I
ON (I.Cod_instituto = C.Cod_instituto);

/*7) Obtenha o nome de todos os professores da universidade (mesmo aqueles que não ministraram
disciplinas ainda), e os nomes das disciplinas que eles ministram. Retorne em ordem crescente do nome do professor.

R:
*/
SELECT P.Nome_Professor, D.Nome_Disciplina
FROM Professor P LEFT JOIN Prof_Disc PD
ON (P.Cod_Professor = PD.Cod_Professor)
LEFT JOIN Disciplina D
ON (PD.Cod_disciplina = D.Cod_Disciplina)
ORDER BY P.Nome_Professor ASC;

/*8) Obtenha o nome dos alunos (de qualquer curso) que tem idade superior à média de idade dos alunos do curso de 'Administracao de Empresas'.

R:
*/
SELECT Nome_Aluno, Idade
FROM Aluno
WHERE Idade > (SELECT AVG(A.Idade)
FROM Aluno A INNER JOIN Curso C
ON (A.Cod_curso = C.Cod_curso)
WHERE (C.Nome_Curso = 'Administracao de Empresas')
);

/*9) Obtenha o nome de cada professor (que orienta aluno) e a quantidade de alunos que cada um orienta, mas somente aqueles que orientam mais alunos que o professor ‘Joao’.

R:
*/
SELECT P.Nome_Professor, COUNT(A.Cod_Professor_Orientador) AS Total_Alunos
FROM Professor P INNER JOIN Aluno A
ON (P.Cod_Professor = A.Cod_Professor_Orientador)
GROUP BY P.Nome_Professor
HAVING COUNT(A.Cod_Professor_Orientador) > (SELECT COUNT(A.Cod_Professor_Orientador)
FROM Professor P INNER JOIN Aluno A
ON(P.Cod_Professor = A.Cod_Professor_Orientador)
WHERE (P.Nome_Professor = 'Joao')
);
