package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ObjCidade;
import model.ObjCliente;
import model.ObjClienteFisico;
import model.ObjClienteJuridico;

public class ClienteDAO {
    
     public static void inserir( ObjCliente cli ){
        String sql = "INSERT INTO clientes "
                + " ( nome, endereco, telefone, tipo, codCidade ) "
                + " VALUES ( "
                + "  '" + cli.getNome()               + "' , "
                + "  '" + cli.getEndereco()           + "' , "
                + "  '" + cli.getTelefone()           + "' , "
                + "  '" + cli.getTipo()               + "' , "
                + "   " + cli.getCidade().getCodigo() + "    "
                + " );" ;
        Conexao.executar( sql );
    }
     
    public static void editar( ObjCliente cli ){
        String sql = "UPDATE clientes SET "
                + " nome =      '" + cli.getNome()               + "' , "
                + " endereco =  '" + cli.getEndereco()           + "' , "
                + " telefone =  '" + cli.getTelefone()           + "' , "
                + " tipo =      '" + cli.getTipo()               + "' , "
                + " codCidade =  " + cli.getCidade().getCodigo() + "    "
                + " WHERE codigo = " + cli.getCodigo() ;
        Conexao.executar( sql );
    }
      
    public static void excluir( ObjCliente cli ){
        String sql = "DELETE FROM clientes "
                + " WHERE codigo = " + cli.getCodigo() ;
        Conexao.executar( sql );
    }
    
    public static List<ObjCliente> getClientes(){
       
        List<ObjCliente> lista = new ArrayList<>();
        String sql = "SELECT c.codigo, d.codigo, c.nome,      "
            + " d.nome, c.endereco, c.telefone, c.tipo,       "
            + " c.cpf_cnpj, c.rg_ie                           "
            + " FROM clientes c                               "
            + " INNER JOIN cidades d ON c.codCidade = d.codigo"
            + " ORDER BY c.nome";
        ResultSet rs = Conexao.consultar(sql);
        if( rs != null ){
            try {
                while ( rs.next() ) {                    
                    ObjCliente cli = new ObjCliente();
                    cli.setCodigo( rs.getInt(1) );
                    cli.setNome( rs.getString(3) );
                    cli.setEndereco( rs.getString(5) );
                    cli.setTelefone( rs.getString(6) );
                    cli.setTipo( rs.getString(7) );
                    ObjCidade cid = new ObjCidade();
                    cid.setCodigo( rs.getInt(2) );
                    cid.setNome( rs.getString(4) );
                    cli.setCidade( cid );
                    lista.add( cli );
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        return lista;
    }
    
    public static Object getClienteByCodigo( int codigo){
        Object cliente = null;
        String sql = "SELECT c.codigo, d.codigo, c.nome,      "
            + " d.nome, c.endereco, c.telefone, c.tipo,       "
            + " c.cpf_cnpj, c.rg_ie                           "
            + " FROM clientes c                               "
            + " INNER JOIN cidades d ON c.codCidade = d.codigo"
            + " WHERE c.codigo = " + codigo
            + " ORDER BY c.nome";
        ResultSet rs = Conexao.consultar( sql );
        try {
            rs.first();
            
            ObjCidade cidade = new ObjCidade();
            cidade.setCodigo( rs.getInt( 2 ) );
            cidade.setNome( rs.getString( 4 ));
            
            String tipo = rs.getString( 7 );
            if( tipo.equals( "" ) ){
                ObjCliente cli = new ObjCliente();
                cli.setCodigo( rs.getInt( 1 ) );
                cli.setNome( rs.getString( 3 ) );
                cli.setEndereco( rs.getString( 5 ) );
                cli.setTelefone( rs.getString( 6 ) );
                cli.setTipo( tipo );
                cli.setCidade( cidade );
                cliente = cli;
            }
           
            if( tipo.equals( ObjCliente.PESSOA_FISICA) ){
                ObjClienteFisico cf = new ObjClienteFisico();
                cf.setCodigo( rs.getInt( 1 ) );
                cf.setNome( rs.getString( 3 ) );
                cf.setEndereco( rs.getString( 5 ) );
                cf.setTelefone( rs.getString( 6 ) );
                cf.setTipo( tipo );
                cf.setCidade( cidade );
                cf.setCpf( rs.getString( 8 ));
                cf.setRg(rs.getString( 9 ));
                cliente = cf;
            }
            
            if( tipo.equals( ObjCliente.PESSOA_JURIDICA) ){
                ObjClienteJuridico cj = new ObjClienteJuridico();
                cj.setCodigo( rs.getInt( 1 ) );
                cj.setNome( rs.getString( 3 ) );
                cj.setEndereco( rs.getString( 5 ) );
                cj.setTelefone( rs.getString( 6 ) );
                cj.setTipo( tipo );
                cj.setCidade( cidade );
                cj.setCnpj(rs.getString( 8 ));
                cj.setIe(rs.getString( 9 ));
                cliente = cj;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        
        
        return cliente;
    }
     
}







