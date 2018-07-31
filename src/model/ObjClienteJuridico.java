
package model;

public class ObjClienteJuridico extends ObjCliente{
    
    private String cnpj, ie;

    public ObjClienteJuridico() {
    }

    public ObjClienteJuridico(String cnpj, String ie, int codigo, String nome, String endereco, String telefone, String tipo, ObjCidade cidade) {
        super(codigo, nome, endereco, telefone, tipo, cidade);
        this.cnpj = cnpj;
        this.ie = ie;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }
    
    
    
    
}
