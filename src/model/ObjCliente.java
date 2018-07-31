package model;

public class ObjCliente {
    
    public static final String PESSOA_FISICA = "pf";
    public static final String PESSOA_JURIDICA = "pj";
    
    private int codigo;
    private String nome, endereco, telefone, tipo;
    private ObjCidade cidade;

    public ObjCliente() {
    }

    public ObjCliente(String nome) {
        this.nome = nome;
    }

    
    public ObjCliente(int codigo, String nome, String endereco, String telefone, String tipo, ObjCidade cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.tipo = tipo;
        this.cidade = cidade;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ObjCidade getCidade() {
        return cidade;
    }

    public void setCidade(ObjCidade cidade) {
        this.cidade = cidade;
    }
    
    
    
    
    
    
}
