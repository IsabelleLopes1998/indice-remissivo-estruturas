package Java.modelo;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class Nodo {
    private int elemento;
    private Nodo proximo;

    public Nodo(int elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public Nodo getProximo() {
        return proximo;
    }

    public void setProximo(Nodo proximo) {
        this.proximo = proximo;
    }
}

public class ListaEncadeada {
    private Nodo inicio;
    private static int n_elemento;
    private Nodo ultimo;

    public ListaEncadeada() {
        n_elemento = 0;
        this.inicio = null;
        this.ultimo = null;
    }

    public boolean estaVazia() {
        return this.inicio == null;
    }

    public boolean contem(int valor) {
        Nodo atual = this.inicio;
        while (atual != null) {
            if (atual.getElemento() == valor) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    public void insereInicio(int elemento) {
        Nodo novoNodo = new Nodo(elemento);
        if (this.inicio == null) {
            this.inicio = novoNodo;
            this.ultimo = novoNodo;
        } else {
            novoNodo.setProximo(this.inicio);
            this.inicio = novoNodo;
        }

        ++n_elemento;
    }

    public void insereFinal(int elemento) {
        Nodo novoNodo = new Nodo(elemento);
        if (this.inicio == null) {
            this.inicio = novoNodo;
            this.ultimo = novoNodo;
        } else {
            this.ultimo.setProximo(novoNodo);
            this.ultimo = novoNodo;
        }

        ++n_elemento;
    }

    public void inserePos(int pos, int elemento) {
        if (pos >= 0 && pos <= n_elemento) {
            if (pos == 0) {
                this.insereInicio(elemento);
            } else {
                Nodo novoNodo = new Nodo(elemento);
                Nodo nodoAtual = this.inicio;

                for(int i = 0; i < pos - 1; ++i) {
                    nodoAtual = nodoAtual.getProximo();
                }

                novoNodo.setProximo(nodoAtual.getProximo());
                nodoAtual.setProximo(novoNodo);
                ++n_elemento;
            }

        } else {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
    }

    public void imprimir() {
        ListaEncadeada lista = new ListaEncadeada();
        if (lista == null) {
            System.out.println("A lista está vazia");
        } else {
            for(Nodo atual = this.inicio; atual != null; atual = atual.getProximo()) {
                System.out.print("Lista: " + atual.getElemento() + " ");
            }
        }

    }

    public void removeInicio() {
        if (this.inicio == null) {
            throw new NoSuchElementException("A lista está vazia");
        } else {
            this.inicio = this.inicio.getProximo();
            --n_elemento;
            if (this.inicio == null) {
                this.ultimo = null;
            }

        }
    }

    public void removeFinal() {
        if (this.inicio == null) {
            throw new NoSuchElementException("A lista está vazia");
        } else {
            if (this.inicio.getProximo() == null) {
                this.inicio = null;
            } else {
                Nodo anterior = null;

                for(Nodo atual = this.inicio; atual.getProximo() != null; atual = atual.getProximo()) {
                    anterior = atual;
                }

                anterior.setProximo((Nodo)null);
            }

            --n_elemento;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Nodo atual = this.inicio;

        while (atual != null) {
            sb.append(atual.getElemento());
            if (atual.getProximo() != null) {
                sb.append(", ");
            }
            atual = atual.getProximo();
        }

        return sb.toString();
    }
    public List<Integer> getElementos() {
        List<Integer> elementos = new ArrayList<>();
        Nodo atual = this.inicio;
        while (atual != null) {
            elementos.add(atual.getElemento());
            atual = atual.getProximo();
        }
        return elementos;
    }


}


