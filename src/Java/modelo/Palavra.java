package Java.modelo;
import Java.modelo.ListaEncadeada;


public class Palavra implements Comparable<Palavra> {
    private String texto;
    private ListaEncadeada ocorrencias;

    public Palavra(String texto) {
        this.texto = texto;
        this.ocorrencias = new ListaEncadeada();
    }

    public void adicionarOcorrencia(int linha) {
        if (!ocorrencias.contem(linha)) {
            ocorrencias.insereFinal(linha);
        }
    }

    @Override
    public String toString() {
        return texto + ": " + ocorrencias.toString();
    }

    @Override
    public int compareTo(Palavra outra) {
        return this.texto.compareTo(outra.texto);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Palavra outra) {
            return this.texto.equalsIgnoreCase(outra.texto);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return texto.toLowerCase().hashCode();
    }

    public ListaEncadeada getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(ListaEncadeada ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
