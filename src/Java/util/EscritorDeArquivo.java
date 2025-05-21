/*
package Java.util;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscritorDeArquivo {

    public static void escreverIndiceRemissivo(String caminhoArquivo, List<String> linhas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (String linha : linhas) {
                bw.write(linha);
                bw.newLine();
            }
            System.out.println("Arquivo de índice remissivo gerado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + caminhoArquivo);
            e.printStackTrace();
        }
    }
}
*/
package Java.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class EscritorDeArquivo {

    public static void escreverIndiceRemissivo(String caminhoArquivo, List<String> linhas) {
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(caminhoArquivo), StandardCharsets.UTF_8))) {

            for (String linha : linhas) {
                bw.write(linha);
                bw.newLine();
            }
            System.out.println("Arquivo de índice remissivo gerado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + caminhoArquivo);
            e.printStackTrace();
        }
    }
}
