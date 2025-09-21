package principal.supernosso;

import java.util.ArrayList;

public class Carrinho {
    private double valorTotal;
    private ArrayList<Produto> produtos;

    public Carrinho(){
        valorTotal = 0;
        produtos = new ArrayList<>();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void addItemProduto(Produto item){
        for (int i = 0; i < produtos.size(); i++){
            if (produtos.get(i).getCodigo() == item.getCodigo()){
                produtos.get(i).setQuantidade(produtos.get(i).getQuantidade() + item.getQuantidade());
                valorTotal += item.getQuantidade() * item.getPreco();
                return;
            }
        }
        produtos.add(item);
        valorTotal += item.getQuantidade() * item.getPreco();
    }

    public boolean removeProduto(Produto item){
        for (int i = 0; i < produtos.size(); i++){
            if (produtos.get(i).getCodigo() == item.getCodigo()){
                if (produtos.get(i).getQuantidade() > item.getQuantidade()){
                    produtos.get(i).setQuantidade(produtos.get(i).getQuantidade() - item.getQuantidade());
                    valorTotal -= item.getQuantidade() * item.getPreco();
                    return true;
                }
                else{
                    valorTotal -= produtos.get(i).getQuantidade() * produtos.get(i).getPreco();
                    produtos.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public String listarProdutos(){
        String retorno = "";
        for (Produto e : produtos){
            retorno = retorno + e.getDescricao() + "   R$" + e.getPreco() + "   *" + e.getQuantidade() + "\n";
        }
        return retorno;
    }
}
