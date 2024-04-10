//Considere um jogo digital chamado “As Aventuras de Superpadrãozinho”, que tem apenas um personagem principal, chamado Superpadrãozinho. Como aplicar o padrão Singleton para representá-lo?
//R:
public class Superpadrãozinho {
    private static Superpadrãozinho instance = null;

    private Superpadrãozinho() {
    }

    public static Superpadrãozinho getInstance() {
        if (instance == null) {
            instance = new Superpadrãozinho();
        }
        return instance;
    }
}