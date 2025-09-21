package principal.supernosso;

import java.util.Scanner;

public class Caixa {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Produto p1 = new Produto(11111, "Detergente ABC", 1.00, 500);
        Produto p2 = new Produto(22222, "Sabao em po OMO", 6.50, 500);
        Produto p3 = new Produto(33333, "Shampoo beleza facial", 12.00, 500);
        Produto p4 = new Produto(44444, "Creme dental colgate", 3.50, 500);
        Produto p5 = new Produto(55555, "Sabonete Nivea", 1.80, 500);
        Produto p6 = new Produto(66666, "Biscoito maizena", 2.00, 500);
        Produto p7 = new Produto(77777, "Leite Desnatado Parmalat", 3.00, 500);

        estoque.addProduto(p1);
        estoque.addProduto(p2);
        estoque.addProduto(p3);
        estoque.addProduto(p4);
        estoque.addProduto(p5);
        estoque.addProduto(p6);
        estoque.addProduto(p7);

        boolean run = true;
        while (run){
            System.out.println("Bem vindo ao supermercado da tia Lu!");
            System.out.println("Digite 1 para iniciar uma nova compra");
            System.out.println("Digite 0 para sair");
            Scanner input = new Scanner(System.in);
            int opt = input.nextInt();
            if (opt == 0){
                run = false;
            }
            else if (opt == 1){
                Carrinho carrinho = new Carrinho();
                int cdg = -1, quantidades = 0;
                while (cdg != 0){
                    System.out.println("Digite o codigo do produto:");
                    cdg = input.nextInt();
                    if (cdg != 0){
                        if (estoque.consultarProduto(cdg) == null){
                            System.out.println("Produto nao encontrado");
                        }
                        else{
                            System.out.println("Digite o numero de unidades:");
                            quantidades = input.nextInt();
                            Produto p = estoque.consultarProduto(cdg);
                            p.setQuantidade(quantidades);
                            carrinho.addItemProduto(p);
                        }
                    }
                }
                //imprime todos os produtos + valor total
                System.out.println(carrinho.listarProdutos());
                System.out.println("TOTAL: R$" + carrinho.getValorTotal());
            }
        }
    }
}