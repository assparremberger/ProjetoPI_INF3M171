
package model;

public class ObjCidade {
    private int codigo;
    private String nome;
    
    public ObjCidade(){
        
    }
    public ObjCidade(int codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    public int getCodigo(){
        return this.codigo;
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }  
}








