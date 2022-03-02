package ProjetoEstrutura.View;

import ProjetoEstrutura.Controller.ControllerPrincipal;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author wlipp
 */
public class ViewSolucao extends ViewPadrao {

    public ViewSolucao() {
        initComponents();
        initComponentsPadrao();
        setController(new ControllerPrincipal(this));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_inicio = new javax.swing.JButton();
        btn_voltar = new javax.swing.JButton();
        btn_avancar = new javax.swing.JButton();
        btn_final = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTubosEnsaio = new javax.swing.JTable();
        label_informacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Solucao");
        setMaximumSize(new java.awt.Dimension(1125, 400));
        setMinimumSize(new java.awt.Dimension(1125, 400));
        setResizable(false);

        btn_inicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_inicio.setText("|<<");
        btn_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inicioActionPerformed(evt);
            }
        });

        btn_voltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_voltar.setText("<<");
        btn_voltar.setActionCommand("");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });

        btn_avancar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_avancar.setText(">>");
        btn_avancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_avancarActionPerformed(evt);
            }
        });

        btn_final.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_final.setText(">>|");
        btn_final.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finalActionPerformed(evt);
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

        label_informacao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_informacao.setText("Profundidade e Tempo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label_informacao)
                        .addGap(0, 958, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_inicio)
                .addGap(18, 18, 18)
                .addComponent(btn_voltar)
                .addGap(18, 18, 18)
                .addComponent(btn_avancar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_final)
                .addGap(378, 378, 378))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(label_informacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_inicio)
                    .addComponent(btn_voltar)
                    .addComponent(btn_avancar)
                    .addComponent(btn_final))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inicioActionPerformed
        controller.setaTabelaFirstNode();
    }//GEN-LAST:event_btn_inicioActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        controller.setaTabelaPreviousNode();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_avancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_avancarActionPerformed
        controller.setaTabelaNextNode();
    }//GEN-LAST:event_btn_avancarActionPerformed

    private void btn_finalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finalActionPerformed
        controller.setaTabelaLastNode();
    }//GEN-LAST:event_btn_finalActionPerformed

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
            java.util.logging.Logger.getLogger(ViewSolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewSolucao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_avancar;
    private javax.swing.JButton btn_final;
    private javax.swing.JButton btn_inicio;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_informacao;
    private javax.swing.JTable tableTubosEnsaio;
    // End of variables declaration//GEN-END:variables

    public JTable getTableTubosEnsaio() {
        return tableTubosEnsaio;
    }

    public JButton getBtnAvancar() {
        return btn_avancar;
    }

    public void setBtnAvancar(JButton btn_avancar) {
        this.btn_avancar = btn_avancar;
    }

    public JButton getBtnInicio() {
        return btn_inicio;
    }

    public void setBtnInicio(JButton btn_inicio) {
        this.btn_inicio = btn_inicio;
    }

    public JButton getBtnVoltar() {
        return btn_voltar;
    }

    public void setBtnVoltar(JButton btn_voltar) {
        this.btn_voltar = btn_voltar;
    }

    public void setTextoLabelInformacao(String informacao) {
        this.label_informacao.setText(informacao);
    }

    public JButton getBtnFinal() {
        return btn_final;
    }

    public void setBtnFinal(JButton btn_final) {
        this.btn_final = btn_final;
    }

}