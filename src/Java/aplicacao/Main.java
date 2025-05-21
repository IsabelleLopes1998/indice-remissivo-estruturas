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

    public static void main(String[] args) {
        String caminhoTexto = "texto_projeto.txt";
        String caminhoPalavras = "palavras_chaves_projeto.txt";
        String caminhoSaida = "saida_indice.txt";

        List<String> linhasTexto = LeitorDeArquivo.lerLinhas(caminhoTexto);
        List<String> palavrasChave = LeitorDeArquivo.lerPalavrasChave(caminhoPalavras).stream()
                .map(s -> normalizar(s.toLowerCase()))
                .toList();


        TabelaHash tabelaHash = new TabelaHash();


        for (int i = 0; i < linhasTexto.size(); i++) {
            String linha = normalizar(linhasTexto.get(i).toLowerCase());

            String[] palavras = linha.split("\\s+");
            int numeroLinha = i + 1;

            for (String palavra : palavras) {
                /*for (String p : palavras) {
                    System.out.println("🔍 Palavra encontrada no texto (normalizada): " + p); // DEBUG

                    if (palavrasChave.contains(palavra)) {
                        System.out.println("✅ Palavra está na lista de palavras-chave: " + p); // DEBUG
                        tabelaHash.inserirPalavra(palavra, numeroLinha);
                    }
                }*/
                if (palavrasChave.contains(palavra)) {
                    tabelaHash.inserirPalavra(palavra, numeroLinha);
                }
            }
        }


        List<Palavra> resultado = tabelaHash.todasPalavrasOrdenadas();
        EscritorDeArquivo.escreverIndiceRemissivo(caminhoSaida, resultado.stream().map(Palavra::toString).toList());

        // Imprime o conteúdo do arquivo de saída
        System.out.println("📄 Índice remissivo gerado:");
        LeitorDeArquivo.lerLinhas(caminhoSaida).forEach(System.out::println);

    }
}
