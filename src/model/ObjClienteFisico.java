package model;

public class ObjClienteFisico extends ObjCliente {
    private String cpf, rg;

    public ObjClienteFisico() {
    }

    public ObjClienteFisico(String cpf, String rg, int codigo, String nome, String endereco, String telefone, String tipo, ObjCidade cidade) {
        super(codigo, nome, endereco, telefone, tipo, cidade);
        this.cpf = cpf;
        this.rg = rg;
    }

    
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    
    
    
}
