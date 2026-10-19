public class ProdEstoque {
    private int cod;
    private String nome;
    private double preco;
    private int quantidade;

    public ProdEstoque(int cod, String nome, double preco, int quantidade){
        this.cod = cod;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    public int getCodigo(){
        return cod;
    }

    public String getNome(){
        return nome;
    }

    public double getPreco(){
        return preco;
    } 

    public int getQuantidade(){
        return quantidade;
    } 
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

}