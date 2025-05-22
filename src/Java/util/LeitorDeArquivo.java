/*
package Java.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeitorDeArquivo {

    public static List<String> lerLinhas(String caminhoArquivo) {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + caminhoArquivo);
            e.printStackTrace();
        }
        return linhas;
    }

    public static List<String> lerPalavrasChave(String caminhoArquivo) {
        List<String> palavras = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                for (String palavra : linha.split("\\s+")) {
                    palavras.add(palavra.toLowerCase().replaceAll("[^a-zA-Z-]", ""));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler palavras-chave.");
            e.printStackTrace();
        }
        return palavras;
    }
}
*/
package Java.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class LeitorDeArquivo {

    public static List<String> lerLinhas(String caminhoArquivo) {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(caminhoArquivo), StandardCharsets.UTF_8))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + caminhoArquivo);
            e.printStackTrace();
        }
        return linhas;
    }

    public static List<String> lerPalavrasChave(String caminhoArquivo) {
        List<String> palavras = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(caminhoArquivo), StandardCharsets.UTF_8))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                for (String palavra : linha.split("\\s+")) {
                    palavras.add(palavra);
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler palavras-chave.");
            e.printStackTrace();
        }
        return palavras;
    }
}
