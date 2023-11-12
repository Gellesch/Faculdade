/*
Continuando nosso jogo digital chamado “As Aventuras de Superpadrãozinho”, são previstos dois níveis com dois cenários diferentes: um deserto e uma selva jurássica. Como aplicar o padrão Factory Method para representar a criação desses cenários?
R:
*/
// Passo 1: Criação da interface Cenário
public interface Cenário {
    public void iniciar();
}

// Passo 2: Criação das classes concretas Deserto e SelvaJurassica que
// implementam a interface Cenário
public class Deserto implements Cenário {
    public void iniciar() {
        System.out.println("Iniciando jogo no cenário do deserto...");
    }
}

public class SelvaJurassica implements Cenário {
    public void iniciar() {
        System.out.println("Iniciando jogo no cenário da selva jurássica...");
    }
}

// Passo 3: Criação da classe abstrata CriadorDeCenario
public abstract class CriadorDeCenario {
    public abstract Cenário criarCenario();
}

// Passo 4: Criação das classes concretas CriadorDeCenarioDeserto e
// CriadorDeCenarioSelvaJurassica que estendem a classe CriadorDeCenario
public class CriadorDeCenarioDeserto extends CriadorDeCenario {
    public Cenário criarCenario() {
        return new Deserto();
    }
}

public class CriadorDeCenarioSelvaJurassica extends CriadorDeCenario {
    public Cenário criarCenario() {
        return new SelvaJurassica();
    }
}