package ProjetoEstrutura.View;

import javax.swing.JTable;


/**
 * Tela de informações do projeto Ball Sort Puzzle 
 * Trabalho realizado na disciplica de Algoritmos e Estruturas de Dados
 * @package View
 * @author Walter Felipe Bachmann
 * @since Dezembro/2021
 */
public class ViewSobre extends ViewPadrao {

    public ViewSobre() {
        initComponents();
        initComponentsPadrao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTituloDesenvolvimento = new javax.swing.JLabel();
        nomeWalter = new javax.swing.JLabel();
        emailWalter = new javax.swing.JLabel();
        nomeDaniel = new javax.swing.JLabel();
        emailDaniel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sobre");
        setMinimumSize(new java.awt.Dimension(400, 300));
        setName("viewSobre"); // NOI18N
        setResizable(false);

        labelTituloDesenvolvimento.setText("Desenvolvimento");

        nomeWalter.setBackground(new java.awt.Color(51, 51, 51));
        nomeWalter.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        nomeWalter.setText("Walter Felipe Bachmann");

        emailWalter.setBackground(new java.awt.Color(51, 51, 51));
        emailWalter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emailWalter.setText("wlippe@msn.com");

        nomeDaniel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        nomeDaniel.setText("Daniel Valdo Dallabeneta");

        emailDaniel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emailDaniel.setText("danielvaldo@hotmail.com");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(147, 147, 147)
                            .addComponent(labelTituloDesenvolvimento)
                            .addGap(38, 38, 38))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeWalter)
                            .addComponent(nomeDaniel)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(emailDaniel))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(emailWalter)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTituloDesenvolvimento)
                .addGap(67, 67, 67)
                .addComponent(nomeDaniel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailDaniel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(nomeWalter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailWalter, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewSobre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel emailDaniel;
    private javax.swing.JLabel emailWalter;
    private javax.swing.JLabel labelTituloDesenvolvimento;
    private javax.swing.JLabel nomeDaniel;
    private javax.swing.JLabel nomeWalter;
    // End of variables declaration//GEN-END:variables

    @Override
    public JTable getTableTubosEnsaio() {
        return null;
    }
}
