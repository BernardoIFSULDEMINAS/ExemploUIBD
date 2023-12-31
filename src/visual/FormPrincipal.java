/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
/**
 *
 * @author 13828523633
 */
public class FormPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FormPrincipal
     */
    public FormPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraMenu = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuCidade = new javax.swing.JMenuItem();
        menuFuncionario = new javax.swing.JMenuItem();
        menuAJuda = new javax.swing.JMenu();
        menuSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de cadastro");

        menuCadastro.setText("Cadastro");

        menuCidade.setText("Cidade");
        menuCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCidadeActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCidade);

        menuFuncionario.setText("Funcionário");
        menuFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFuncionarioActionPerformed(evt);
            }
        });
        menuCadastro.add(menuFuncionario);

        barraMenu.add(menuCadastro);

        menuAJuda.setText("Ajuda");

        menuSobre.setText("Sobre");
        menuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSobreActionPerformed(evt);
            }
        });
        menuAJuda.add(menuSobre);

        barraMenu.add(menuAJuda);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCidadeActionPerformed
        FormCidade fc = new FormCidade(this, true);
        // O construtor leva dois parâmetros: a janela pai e um booleano especificando
        // se é uma janela modal (uma janela subordinada a outra).
        fc.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        // A janela não fecha pelo x, a não ser que você programe a operação
        fc.setLocationRelativeTo(null); // por que no centro da tela? Não seria melhor se fosse no centro dessa janela?
        fc.setResizable(false); // Por quê?
        fc.setVisible(true); //visualiza o formCidade
    }//GEN-LAST:event_menuCidadeActionPerformed

    private void menuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSobreActionPerformed
        JOptionPane.showMessageDialog(null, "Sistema de Cadastro\nVersão 1.0\nEste software é software livre: você pode distribui-lo sobre a versão 3 da Licença Pública Geral (GPL-3.0)");
    }//GEN-LAST:event_menuSobreActionPerformed

    private void menuFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFuncionarioActionPerformed
        FormFuncionario ff = new FormFuncionario(this, true);
        // O construtor leva dois parâmetros: a janela pai e um booleano especificando
        // se é uma janela modal (uma janela subordinada a outra).
        ff.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        // A janela não fecha pelo x, a não ser que você programe a operação
        ff.setLocationRelativeTo(null); // por que no centro da tela? Não seria melhor se fosse no centro dessa janela?
        ff.setResizable(false); // Por quê?
        ff.setVisible(true); //visualiza o formCidade
    }//GEN-LAST:event_menuFuncionarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FormPrincipal().setVisible(true);
                FormPrincipal form = new FormPrincipal();
                form.setLocationRelativeTo(null); //centraliza na tela
                form.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenu menuAJuda;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenuItem menuCidade;
    private javax.swing.JMenuItem menuFuncionario;
    private javax.swing.JMenuItem menuSobre;
    // End of variables declaration//GEN-END:variables
}
