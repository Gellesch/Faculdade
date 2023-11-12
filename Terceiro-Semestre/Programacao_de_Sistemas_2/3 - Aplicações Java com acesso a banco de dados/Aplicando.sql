/*desenvolver essa atividade é necessário que você já tenha realizado a instalação e configuração do servidor GlassFish no NetBeans 12.0 LTS. 
Com a configuração finalizada, crie um banco de dados denominado empresa; lembre-se de definir login e senha para esse novo banco de dados. Você pode usar a mesma pasta (Database Location) na qual já está armazenado o banco de dados sistema_academico.  
Depois de criar o banco de dados empresa, crie a tabela funcionario que terá os seguintes campos: a chave primária da tabela deve ser o número de matrícula do funcionário (numat) e é um número BIGINT que não pode ser nulo (NOT NULL), o nome é uma sequência de caracteres (VARCHAR) e também não pode ser nulo, o salario é um ponto flutuante (DECIMAL), o sexo é um caractere (CHAR), o número de departamento (ndepto) é um inteiro (INTEGER) e, por fim, o número do supervisor (nsuper) é do mesmo tipo que o numat e pode ser nulo. 
Com a tabela funcionario criada, inclua os registros na tabela. Para tanto, utilize o comando INSERT INTO para inserir cada uma das linhas acima. 
 
numat 	nome 	salario 	sexo 	ndepto 	nsuper 
1234 	João B Silva 	30000.0 	M 	5 	3334 
3334 	Franco T Welss 	40000.0 	M 	5 	8886 
9998 	Alice J Zeus 	25000.0 	F 	4 	9876 
9876 	Janice S Costa 	43000.0 	F 	4 	8886 
6668 	Rildo K Neves 	38000.0 	M 	5 	3334 
4534 	Joice A Santos 	25000.0 	F 	5 	3334 
9879 	Amo B Jahvi 	25000.0 	M 	4 	9876 
8886 	Jaime E Boulos 	55000.0 	M 	1 	NULL 
 
Em seguida, verifique as informações armazenadas na tabela funcionario, usando o comando SELECT e, por fim, escreva uma consulta usando o comando SELECT para listar todos os funcionários que têm salário maior ou igual a 40 mil. 
*/

/*    Criação da tabela funcionario: */


CREATE TABLE funcionario (
    numat BIGINT NOT NULL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    salario DECIMAL(10, 2),
    sexo CHAR(1),
    ndepto INTEGER,
    nsuper BIGINT,
    FOREIGN KEY (nsuper) REFERENCES funcionario(numat)
);

 /*   Inserção de registros na tabela funcionario: */


INSERT INTO funcionario (numat, nome, salario, sexo, ndepto, nsuper) VALUES
(1234, 'João B Silva', 30000.0, 'M', 5, 3334),
(3334, 'Franco T Welss', 40000.0, 'M', 5, 8886),
(9998, 'Alice J Zeus', 25000.0, 'F', 4, 9876),
(9876, 'Janice S Costa', 43000.0, 'F', 4, 8886),
(6668, 'Rildo K Neves', 38000.0, 'M', 5, 3334),
(4534, 'Joice A Santos', 25000.0, 'F', 5, 3334),
(9879, 'Amo B Jahvi', 25000.0, 'M', 4, 9876),
(8886, 'Jaime E Boulos', 55000.0, 'M', 1, NULL);

 /*   Verificação das informações na tabela funcionario:*/


SELECT * FROM funcionario;

/*Este comando irá mostrar todos os registros na tabela funcionario.

    Consulta para listar funcionários com salário maior ou igual a 40 mil:*/


SELECT * FROM funcionario WHERE salario >= 40000.0;