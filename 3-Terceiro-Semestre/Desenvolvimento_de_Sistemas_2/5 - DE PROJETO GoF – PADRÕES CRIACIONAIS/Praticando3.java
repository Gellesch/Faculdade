//Continuando nosso jogo “As Aventuras de Superpadrãozinho”, para cada nível (cenário) devem ser criados vários objetos que representam animais desses biomas. Necessariamente, todo cenário deve ter um animal perigoso e um animal que possa ser usado como meio de transporte. Para o deserto, a serpente será o animal perigoso, enquanto na selva jurássica será o T-Rex. Já quanto ao animal de transporte, no deserto será o dromedário e na selva jurássica, o pterodátilo. Como aplicar o padrão Abstract Factory para modelar essa situação?
//R:
// Interface Animal
public interface Animal {
    void mover();

    void atacar();
}

// Interface AnimalPerigoso
public interface AnimalPerigoso extends Animal {
    void atacar();
}

// Interface AnimalDeTransporte
public interface AnimalDeTransporte extends Animal {
    void mover();
}

// Classe Serpente
public class Serpente implements AnimalPerigoso {
    @Override
    public void mover() {
        // Implementação para mover a serpente
    }

    @Override
    public void atacar() {
        // Implementação para a serpente atacar
    }
}

// Classe Dromedario
public class Dromedario implements AnimalDeTransporte {
    @Override
    public void mover() {
        // Implementação para o dromedário se mover
    }
}

// Classe T-Rex
public class TRex implements AnimalPerigoso {
    @Override
    public void mover() {
        // Implementação para o T-Rex se mover
    }

    @Override
    public void atacar() {
        // Implementação para o T-Rex atacar
    }
}

// Classe Pterodatilo
public class Pterodatilo implements AnimalDeTransporte {
    @Override
    public void mover() {
        // Implementação para o Pterodátilo se mover
    }
}

// Interface FabricaDeAnimais
public interface FabricaDeAnimais {
    AnimalPerigoso criarAnimalPerigoso();

    AnimalDeTransporte criarAnimalDeTransporte();
}

// Classe FabricaDeAnimaisDeserto
public class FabricaDeAnimaisDeserto implements FabricaDeAnimais {
    @Override
    public AnimalPerigoso criarAnimalPerigoso() {
        return new Serpente();
    }

    @Override
    public AnimalDeTransporte criarAnimalDeTransporte() {
        return new Dromedario();
    }
}

// Classe FabricaDeAnimaisSelvaJurassica
public class FabricaDeAnimaisSelvaJurassica implements FabricaDeAnimais {
    @Override
    public AnimalPerigoso criarAnimalPerigoso() {
        return new TRex();
    }

    @Override
    public AnimalDeTransporte criarAnimalDeTransporte() {
        return new Pterodatilo();
    }
}

// Classe Cenario
public abstract class Cenario {
    private String nome;

    public Cenario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract void criarAnimais();
}

// Classe Deserto
public class Deserto extends Cenario {
    private FabricaDeAnimais fabrica;

    public Deserto(String nome, FabricaDeAnimais fabrica) {
        super(nome);
        this.fabrica = fabrica;
    }

    @Override
    public void criarAnimais() {
        AnimalPerigoso animalPerigoso = fabrica.criarAnimalPerigoso();
        AnimalDeTransporte animalDeTransporte = fabrica.criarAnimalDeTransporte();
        System.out.println("Criando animais para o cenário " + getNome() + ":");
        System.out.println("- Animal perigoso: " + animalPerigoso.getClass().getSimpleName());
        System.out.println("- Animal de transporte: " + animalDeTransporte.getClass().getSimpleName());
    }
}

// Classe SelvaJurassica
public class SelvaJurassica extends Cenario {
    private FabricaDeAnimais fabrica;

    public SelvaJurassica(String nome, FabricaDeAnimais fabrica) {
        super(nome);
        this.fabrica = fabrica;
    }

    @Override
    public void criarAnimais() {
        AnimalPerigoso animalPerigoso = fabrica.criarAnimalPerigoso();
        AnimalDeTransporte animalDeTransporte = fabrica.criarAnimalDeTransporte();
        System.out.println("Criando animais para o cenário " + getNome() + ":");
        System.out.println("- Animal perigoso: " + animalPerigoso.getClass().getSimpleName());
        System.out.println("- Animal de transporte: " + animalDeTransporte.getClass().getSimpleName());
    }
}

// Classe Jogo
public class Jogo {
    public static void main(String[] args) {
        Cenario deserto = new Deserto("Deserto", new FabricaDeAnimaisDeserto());
        Cenario selva = new SelvaJurassica("Selva Jurássica", new FabricaDeAnimaisSelvaJurassica());
        deserto.criarAnimais();
        selva.criarAnimais();
    }
}