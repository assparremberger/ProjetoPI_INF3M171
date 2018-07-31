package model;

public class ObjProduto {
    private int codigo;
    private String nome;
    private double preco, quantidade;
    private ObjCategoria categoria;
    private boolean perecivel;

    public ObjProduto() {
    }

    public ObjProduto(String nome) {
        this.nome = nome;
    }

    public ObjProduto(int codigo, String nome, double preco, double quantidade, ObjCategoria categoria, boolean perecivel) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.perecivel = perecivel;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public ObjCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(ObjCategoria categoria) {
        this.categoria = categoria;
    }

    public boolean isPerecivel() {
        return perecivel;
    }

    public void setPerecivel(boolean perecivel) {
        this.perecivel = perecivel;
    }
    
    
    
}
