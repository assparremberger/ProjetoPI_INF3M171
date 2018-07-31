package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ObjCidade;
import model.ObjCliente;
import model.ObjClienteFisico;
import model.ObjClienteJuridico;

public class ClienteJuridicoDAO {
    
     public static void inserir( ObjClienteJuridico cli ){
        String sql = "INSERT INTO clientes "
                + " ( nome, endereco, telefone, tipo, codCidade, "
                + "  cpf_cnpj, rg_ie ) "
                + " VALUES ( "
                + "  '" + cli.getNome()               + "' , "
                + "  '" + cli.getEndereco()           + "' , "
                + "  '" + cli.getTelefone()           + "' , "
                + "  '" + cli.getTipo()               + "' , "
                + "   " + cli.getCidade().getCodigo() + "  , "
                + "  '" + cli.getCnpj()               + "' ,  "
                + "  '" + cli.getIe()                 + "'    "
                + " );" ;
        Conexao.executar( sql );
    }
     
    public static void editar( ObjClienteJuridico cli ){
        String sql = "UPDATE clientes SET "
                + " nome =      '" + cli.getNome()               + "' , "
                + " endereco =  '" + cli.getEndereco()           + "' , "
                + " telefone =  '" + cli.getTelefone()           + "' , "
                + " tipo =      '" + cli.getTipo()               + "' , "
                + " codCidade =  " + cli.getCidade().getCodigo() + "  , "
                + " cpf_cnpj =  '" + cli.getCnpj()+ "' , "
                + " rg_ie =     '" + cli.getIe()+ "'   "
                + " WHERE codigo = " + cli.getCodigo() ;
        Conexao.executar( sql );
    }
      
    public static void excluir( ObjClienteJuridico cli ){
        String sql = "DELETE FROM clientes "
                + " WHERE codigo = " + cli.getCodigo() ;
        Conexao.executar( sql );
    }
    
    public static List<ObjClienteJuridico> getClientes(){
        List<ObjClienteJuridico> lista = new ArrayList<>();
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
                    ObjClienteJuridico cli = new ObjClienteJuridico();
                  
                    cli.setCodigo( rs.getInt(1) );
                    cli.setNome( rs.getString(3) );
                    cli.setEndereco( rs.getString(5) );
                    cli.setTelefone( rs.getString(6) );
                    cli.setTipo( rs.getString(7) );
                    ObjCidade cid = new ObjCidade();
                    cid.setCodigo( rs.getInt(2) );
                    cid.setNome( rs.getString(4) );
                    cli.setCidade( cid );
                    
                    cli.setCnpj( rs.getString(8) );
                    cli.setIe( rs.getString(9) );
                    
                    lista.add( cli );
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        return lista;
    }
     
}







