/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.ClienteDAO;
import dao.ClienteFisicoDAO;
import dao.ClienteJuridicoDAO;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ObjCliente;
import model.ObjClienteFisico;
import model.ObjClienteJuridico;

/**
 *
 * @author assparremberger
 */
public class ListClientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListClientes
     */
    
    private JDesktopPane painelTelaInicial;
    
    public ListClientes( JDesktopPane painelTelaInicial ) {
        initComponents();
        this.painelTelaInicial = painelTelaInicial;
        carregarTabela("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista de Clientes");

        jLabel1.setText("Tipo: ");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Clientes", "Clientes Físicos", "Clientes Jurídicos", "Todos" }));
        cmbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoItemStateChanged(evt);
            }
        });

        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableClientes);

        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditar)
                            .addComponent(btnExcluir))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnEditar)
                        .addGap(97, 97, 97)
                        .addComponent(btnExcluir)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoItemStateChanged
       int posicao = cmbTipo.getSelectedIndex();
       switch( posicao ){
           case 0:
               carregarTabela("");
               break;
           case 1:
               carregarTabela( ObjCliente.PESSOA_FISICA );
               break;
           case 2 :
               carregarTabela( ObjCliente.PESSOA_JURIDICA );
               break;
       }
    }//GEN-LAST:event_cmbTipoItemStateChanged

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tableClientes.getSelectedRow();
        if( linha == -1 ){
            JOptionPane.showMessageDialog(this, 
                    "Você deve selecionar um cliente!");
        }else{
            int codigo = (int) tableClientes.getValueAt(linha, 0);
            FrmCliente tela = new FrmCliente( codigo, this );
            this.painelTelaInicial.add( tela );
            tela.setVisible(true);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    public void carregarTabela(String tipo ){
        DefaultTableModel modelo = new DefaultTableModel();
        String[] colunas = {};
        
        switch( tipo ){
            case "" :
                colunas = new String[]{"Código", "Nome", 
                    "Telefone", "Endereço", "Cidade"};
                modelo.setColumnIdentifiers( colunas );
                List<ObjCliente> listaClientes =  ClienteDAO.getClientes();
                for ( ObjCliente cli : listaClientes ) {
                    Object[] obj = {
                        cli.getCodigo() ,
                        cli.getNome() , 
                        cli.getTelefone() , 
                        cli.getEndereco() ,
                        cli.getCidade().getNome() 
                    };
                    modelo.addRow( obj );
                }
                break;
            case ObjCliente.PESSOA_FISICA :
                colunas =  new String[]{"Código", "Nome", 
                    "Telefone", "Endereço", "Cidade", "CPF", "RG"};
                List<ObjClienteFisico> listaFisicos = 
                        ClienteFisicoDAO.getClientes();
                for( ObjClienteFisico cli : listaFisicos ){
                    Object[] obj = {
                        cli.getCodigo() ,
                        cli.getNome() , 
                        cli.getTelefone() , 
                        cli.getEndereco() ,
                        cli.getCidade().getNome() ,
                        cli.getCpf() ,
                        cli.getRg()
                    };
                    modelo.addRow( obj );
                }
                break;
            case ObjCliente.PESSOA_JURIDICA :
                colunas =  new String[]{"Código", "Nome", 
                    "Telefone", "Endereço", "Cidade", "CNPJ", "IE"};
                List<ObjClienteJuridico> listaJuridicos = 
                        ClienteJuridicoDAO.getClientes();
                for( ObjClienteJuridico cli : listaJuridicos ){
                    Object[] obj = {
                        cli.getCodigo() ,
                        cli.getNome() , 
                        cli.getTelefone() , 
                        cli.getEndereco() ,
                        cli.getCidade().getNome() ,
                        cli.getCnpj(),
                        cli.getIe()
                    };
                    modelo.addRow( obj );
                }
                break;
        }
     
        
        tableClientes.setModel( modelo );
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableClientes;
    // End of variables declaration//GEN-END:variables
}