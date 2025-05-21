package Java.estrutura;


import Java.modelo.Palavra;
import java.util.List;

public class ArvoreBinaria {
    private No raiz;

    private static class No {
        Palavra valor;
        No esquerda;
        No direita;

        No(Palavra valor) {
            this.valor = valor;
        }
    }

    public void inserirOuAtualizar(Palavra nova) {
        raiz = inserirOuAtualizarRec(raiz, nova);
    }

    private No inserirOuAtualizarRec(No atual, Palavra nova) {
        if (atual == null) return new No(nova);

        int cmp = nova.compareTo(atual.valor);
        if (cmp < 0) {
            atual.esquerda = inserirOuAtualizarRec(atual.esquerda, nova);
        } else if (cmp > 0) {
            atual.direita = inserirOuAtualizarRec(atual.direita, nova);
        } else {
            // Mesma palavra: só adiciona ocorrência
            for (int linha : nova.getOcorrencias().getElementos()) {
                atual.valor.adicionarOcorrencia(linha);
            }
        }
        return atual;
    }

    public Palavra buscar(String texto) {
        return buscarRec(raiz, texto);
    }

    private Palavra buscarRec(No atual, String texto) {
        if (atual == null) return null;

        int cmp = texto.compareTo(atual.valor.getTexto());
        if (cmp < 0) return buscarRec(atual.esquerda, texto);
        else if (cmp > 0) return buscarRec(atual.direita, texto);
        else return atual.valor;
    }

    public void percorrerEmOrdem(List<Palavra> destino) {
        percorrerRec(raiz, destino);
    }

    private void percorrerRec(No atual, List<Palavra> destino) {
        if (atual == null) return;
        percorrerRec(atual.esquerda, destino);
        destino.add(atual.valor);
        percorrerRec(atual.direita, destino);
    }
}
