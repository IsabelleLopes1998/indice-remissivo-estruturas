package Java.estrutura;


import Java.modelo.Palavra;
import java.util.ArrayList;
import java.util.List;

public class TabelaHash {
    private ArvoreBinaria[] tabela;

    public TabelaHash() {
        this.tabela = new ArvoreBinaria[26]; // uma árvore para cada letra
        for (int i = 0; i < 26; i++) {
            tabela[i] = new ArvoreBinaria();
        }
    }

    /*private int calcularIndice(String texto) {
        char inicial = Character.toLowerCase(texto.charAt(0));
        return inicial - 'a'; // 'a' = 0, 'b' = 1, ..., 'z' = 25
    }*/
    private int calcularIndice(String texto) {
        if (texto == null || texto.isEmpty()) return 0;

        char inicial = Character.toLowerCase(texto.charAt(0));
        if (inicial < 'a' || inicial > 'z') return 0;

        return inicial - 'a';
    }



    /*public void inserirPalavra(String texto, int linha) {
        int indice = calcularIndice(texto);
        Palavra nova = new Palavra(texto);
        nova.adicionarOcorrencia(linha);
        tabela[indice].inserirOuAtualizar(nova);
    }*/

    public void inserirPalavra(String texto, int linha) {
        int indice = calcularIndice(texto);
        //System.out.println("🔎 Inserindo '" + texto + "' no índice da tabela: " + indice);
        Palavra nova = new Palavra(texto);
        nova.adicionarOcorrencia(linha);
        tabela[indice].inserirOuAtualizar(nova);
    }


    public Palavra buscarPalavra(String texto) {
        int indice = calcularIndice(texto);
        return tabela[indice].buscar(texto);
    }

    public List<Palavra> todasPalavrasOrdenadas() {
        List<Palavra> resultado = new ArrayList<>();
        for (ArvoreBinaria abb : tabela) {
            abb.percorrerEmOrdem(resultado);
        }
        return resultado;
    }
}
