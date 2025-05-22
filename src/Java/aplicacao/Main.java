package Java.aplicacao;

import Java.modelo.Palavra;
import Java.estrutura.TabelaHash;
import Java.util.LeitorDeArquivo;
import Java.util.EscritorDeArquivo;

import java.text.Normalizer;
import java.util.List;

public class Main {

    public static String normalizar(String p) {
        return Normalizer.normalize(p, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .replaceAll("[^a-z\\s-]", "");
    }

    public static String simplificarPlural(String palavra) {

        if (palavra.endsWith("s") && palavra.length() > 3) {
            return palavra.substring(0, palavra.length() - 1);
        }
        return palavra;
    }

    public static void main(String[] args) {
        String caminhoTexto = "texto_projeto.txt";
        String caminhoPalavras = "palavras_chaves_projeto.txt";
        String caminhoSaida = "saida_indice.txt";


        List<String> palavrasChave = LeitorDeArquivo.lerPalavrasChave(caminhoPalavras).stream()
                .map(s -> simplificarPlural(normalizar(s.toLowerCase())))
                .toList();

        List<String> linhasTexto = LeitorDeArquivo.lerLinhas(caminhoTexto);

        TabelaHash tabelaHash = new TabelaHash();

        for (int i = 0; i < linhasTexto.size(); i++) {
            String linha = simplificarPlural(normalizar(linhasTexto.get(i).toLowerCase()));
            String[] palavras = linha.split("\\s+");
            int numeroLinha = i + 1;

            for (String palavra : palavras) {
                palavra = simplificarPlural(palavra);
                if (palavrasChave.contains(palavra)) {
                    tabelaHash.inserirPalavra(palavra, numeroLinha);
                }
            }
        }

        List<Palavra> resultado = tabelaHash.todasPalavrasOrdenadas();
        EscritorDeArquivo.escreverIndiceRemissivo(caminhoSaida, resultado.stream().map(Palavra::toString).toList());

        System.out.println("📄 Índice remissivo gerado:");
        LeitorDeArquivo.lerLinhas(caminhoSaida).forEach(System.out::println);
    }
}
