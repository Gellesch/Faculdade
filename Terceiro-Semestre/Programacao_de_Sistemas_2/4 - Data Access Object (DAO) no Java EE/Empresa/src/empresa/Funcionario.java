/**
CREATE TABLE funcionario(
    numat BIGINT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    salario DECIMAL,
    sexo CHAR,
    ndepto INTEGER,
    nsuper BIGINT,
    PRIMARY KEY (numat)
);
 **/
public class Funcionario {
    private int numat;
    private String nome;
    private Double salario;
    private char sexo;
    private int ndepto;
    private int nsuper;
    
    public int getNumat(){
        return numat;
    }
    
    public void setNumat(int numat){
        this.numat = numat;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public Double getSalario(){
        return salario;
    }
    
    public void setSalario(Double salario){
        this.salario = salario;
    }
    
    public char getSexo(){
        return sexo;
    }
    
    public void setSexo(char sexo){
        this.sexo = sexo;
    }
    
    public int getNdepto(){
        return ndepto;
    }
    
    public void setNdepto(int ndepto){
        this.ndepto = ndepto;
    }
    
    public int getNsuper(){
        return nsuper;
    }
    
    public void setNsuper(int nsuper){
        this.nsuper = nsuper;
    }
    
}
