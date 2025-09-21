package principal.supernosso;

import java.util.ArrayList;

public class Estoque {
    private ArrayList<Produto> produtos;

    public Estoque(){
        produtos = new ArrayList<>();
    }

    public void addProduto(Produto item){
        for (int i = 0; i < produtos.size(); i++){
            if (produtos.get(i).getCodigo() == item.getCodigo()){
                produtos.get(i).setQuantidade(produtos.get(i).getQuantidade() + item.getQuantidade());
                return;
            }
        }
        produtos.add(item);
    }

    public boolean removerProduto(Produto item){
        for (int i = 0; i < produtos.size(); i++){
            if (produtos.get(i).getCodigo() == item.getCodigo()){
                if (produtos.get(i).getQuantidade() > item.getQuantidade()){
                    produtos.get(i).setQuantidade(produtos.get(i).getQuantidade() - item.getQuantidade());
                    return true;
                }
                else{
                    produtos.remove(i);
                    return true;
                }
            }
        }
        return false;

    }

    public Produto consultarProduto(int codigo){
        for (Produto e : produtos){
            if (e.getCodigo() == codigo){
                return e;
            }
        }
        return null;
    }

    public String listarProdutos(){
        String retorno = "";
        for (Produto e : produtos){
            retorno = retorno + e.getDescricao() + "\n";
        }
        return retorno;
    }
}
