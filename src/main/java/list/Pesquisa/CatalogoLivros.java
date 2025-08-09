package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> livroList;

    public CatalogoLivros() {
        this.livroList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        livroList.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();
        if (!livroList.isEmpty()) {
            for (Livro l : livroList) {
                if (l.getAutor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.add(l);
                }
            }
            return livrosPorAutor;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        List<Livro> livrosPorIntervaloAnos = new ArrayList<>();
        if (!livroList.isEmpty()) {
            for (Livro l : livroList) {
                if (l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal) {
                    livrosPorIntervaloAnos.add(l);
                }
            }
            return livrosPorIntervaloAnos;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public Livro pesquisarPorTitulo(String titulo) {
        Livro livroPorTitulo = null;
        if (!livroList.isEmpty()) {
            for (Livro l : livroList) {
                if (l.getTitulo().equalsIgnoreCase(titulo)) {
                    livroPorTitulo = l;
                    break;
                }
            }
            return livroPorTitulo;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public static void main(String[] args) {

        CatalogoLivros catalogoLivros = new CatalogoLivros();

        catalogoLivros.adicionarLivro("Microsserviços Prontos Para a Produção", "Susan J. Fowler", 2017);
        catalogoLivros.adicionarLivro("Java Guia do Programador", "Peter Jandl Junior", 2021);
        catalogoLivros.adicionarLivro("Código Limpo", "Robert C. Martin", 2009);
        catalogoLivros.adicionarLivro("O Codificador Limpo", "Robert C. Martin", 2012);

        System.out.println("======================================");
        System.out.printf("📚 Livros do autor '%s': %s%n",
                "Robert C. Martin",
                catalogoLivros.pesquisarPorAutor("Robert C. Martin"));

        System.out.printf("📚 Livros do autor '%s': %s%n",
                "Autor Inexistente",
                catalogoLivros.pesquisarPorAutor("Autor Inexistente"));

        System.out.println("--------------------------------------");
        System.out.printf("📅 Livros publicados entre %d e %d: %s%n",
                2010, 2022,
                catalogoLivros.pesquisarPorIntervaloAnos(2010, 2022));

        System.out.printf("📅 Livros publicados entre %d e %d: %s%n",
                2025, 2030,
                catalogoLivros.pesquisarPorIntervaloAnos(2025, 2030));

        System.out.println("--------------------------------------");
        System.out.printf("🔎 Pesquisa por título '%s': %s%n",
                "Java Guia do Programador",
                catalogoLivros.pesquisarPorTitulo("Java Guia do Programador"));

        System.out.printf("🔎 Pesquisa por título '%s': %s%n",
                "Título Inexistente",
                catalogoLivros.pesquisarPorTitulo("Título Inexistente"));
        System.out.println("======================================");
    }
}