package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ObjCidade;

public class CidadeDAO {
    
    public static void inserir( ObjCidade cid ){
        String sql = "INSERT INTO cidades "
                + " ( nome ) VALUES "
                + " ( '" + cid.getNome() + "' );" ;
        Conexao.executar( sql );
    }
    
    public static void editar( ObjCidade cid ){
        String sql = "UPDATE cidades SET "
                + " nome = '" + cid.getNome() + "' "
                + " WHERE codigo = " + cid.getCodigo() ;
        Conexao.executar( sql );
    }
    
    public static void excluir( ObjCidade cid ){
        String sql = "DELETE FROM cidades "
                + " WHERE codigo = " + cid.getCodigo() ;
        Conexao.executar( sql );
    }
    
    
    public static List<ObjCidade> getCidades(){
        List<ObjCidade> lista = new ArrayList<>();
        String sql = "SELECT * FROM cidades ORDER BY nome";
        ResultSet rs = Conexao.consultar(sql);
        if( rs != null ){
            try {
                while ( rs.next() ) {                    
                    ObjCidade cid = new ObjCidade();
                    cid.setCodigo( rs.getInt(1) );
                    cid.setNome( rs.getString(2));
                    lista.add(cid);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        return lista;
    }
    
    public static ObjCidade getCidadeByCodigo(int codigo){
        ObjCidade cidade = new ObjCidade();
        
        String sql = "SELECT codigo, nome FROM cidades "
                   + " WHERE codigo = " + codigo;
        ResultSet rs = Conexao.consultar( sql );
        try {
            rs.first();
            cidade.setCodigo( rs.getInt( 1 ) );
            cidade.setNome( rs.getString( 2 ) );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return cidade;
    }
    
    
}









