package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        itens.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                itensParaRemover.add(item);
            }
        }
        itens.removeAll(itensParaRemover);
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }

    public void exibirItens() {
        if (itens.isEmpty()) {
            System.out.println("O carrinho está vazio.");
        } else {
            System.out.println("Itens no carrinho:");
            for (Item item : itens) {
                System.out.println(item);
            }
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        carrinho.adicionarItem("Notebook", 3500.00, 1);
        carrinho.adicionarItem("Mouse", 120.50, 2);
        carrinho.adicionarItem("Teclado", 250.75, 1);

        carrinho.exibirItens();
        System.out.printf("Valor total do carrinho: R$ %.2f%n", carrinho.calcularValorTotal());

        carrinho.removerItem("Mouse");
        System.out.println("\nApós remover o Mouse:");

        carrinho.exibirItens();
        System.out.printf("Valor total do carrinho: R$ %.2f%n", carrinho.calcularValorTotal());
    }
}
