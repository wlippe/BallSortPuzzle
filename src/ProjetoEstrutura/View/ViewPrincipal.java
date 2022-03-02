package ProjetoEstrutura.View;

import ProjetoEstrutura.Controller.ControllerPrincipal;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * Tela principal do Projeto de Algoritmos e Estruturas de Dados   
 * @package View
 * @author Walter Felipe Bachmann
 * @since Dezembro/2021
 */
public class ViewPrincipal extends ViewPadrao {

    public ViewPrincipal() {
        initComponents();
        initComponentsPadrao();
        setController(new ControllerPrincipal(this));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_carregar = new javax.swing.JButton();
        btn_largura = new javax.swing.JButton();
        btn_profundidade = new javax.swing.JButton();
        btn_sobre = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTubosEnsaio = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trabalho 45ALG - Ball Sort Puzzle");
        setMaximumSize(new java.awt.Dimension(1125, 400));
        setMinimumSize(new java.awt.Dimension(1125, 400));
        setResizable(false);

        btn_carregar.setText("Carregar");
        btn_carregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_carregarActionPerformed(evt);
            }
        });

        btn_largura.setText("Largura");
        btn_largura.setActionCommand("");
        btn_largura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_larguraActionPerformed(evt);
            }
        });

        btn_profundidade.setText("Profundidade");
        btn_profundidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_profundidadeActionPerformed(evt);
            }
        });

        btn_sobre.setText("Sobre");
        btn_sobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_sobreMouseClicked(evt);
            }
        });

        tableTubosEnsaio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableTubosEnsaio.setFocusable(false);
        tableTubosEnsaio.setShowGrid(true);
        jScrollPane1.setViewportView(tableTubosEnsaio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(378, 378, 378)
                .addComponent(btn_carregar)
                .addGap(18, 18, 18)
                .addComponent(btn_largura)
                .addGap(18, 18, 18)
                .addComponent(btn_profundidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_sobre)
                .addContainerGap(378, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_carregar)
                    .addComponent(btn_largura)
                    .addComponent(btn_profundidade)
                    .addComponent(btn_sobre))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_carregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_carregarActionPerformed
        controller.loadFile();
    }//GEN-LAST:event_btn_carregarActionPerformed

    private void btn_larguraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_larguraActionPerformed
        try {
            controller.buscaEmLargura();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro interno");
        }
    }//GEN-LAST:event_btn_larguraActionPerformed

    private void btn_sobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sobreMouseClicked
        this.abreJanelaSobre();
    }//GEN-LAST:event_btn_sobreMouseClicked

    private void btn_profundidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_profundidadeActionPerformed
        try {
            controller.buscaProfundidade();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro interno");
        }
    }//GEN-LAST:event_btn_profundidadeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_carregar;
    private javax.swing.JButton btn_largura;
    private javax.swing.JButton btn_profundidade;
    private javax.swing.JButton btn_sobre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableTubosEnsaio;
    // End of variables declaration//GEN-END:variables
  
    private void abreJanelaSobre() {
        new ViewSobre().setVisible(true);
    }

    public JTable getTableTubosEnsaio() {
        return tableTubosEnsaio;
    }

}