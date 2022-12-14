/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.LeituraAgua.Telas;
import java.sql.*;
import br.com.LeituraAgua.DAO.ConexaoDAO;
import br.com.LeituraAgua.controler.UsuarioControler;
import br.com.model.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Alunos
 */
public class TelaLogin extends javax.swing.JFrame {
    Connection connect = null;
    PreparedStatement pst = null;
    ResultSet result = null;
    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
        connect = ConexaoDAO.createConnection();
        if (connect != null) {
            /*
            criar uma label na tela com id lblStatus
            para apresentar status da conexão
            lblStatus.setText(conexão ok)
            */
            System.out.println(connect +"conexão ok");
        } else {
            /*
            lblStatus.setText(falha conexão)
            */
            System.out.println("falha de conexão");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAcessar = new javax.swing.JButton();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jLabelLogo = new javax.swing.JLabel();
        jLabelversão = new javax.swing.JLabel();
        mensagemlogin = new javax.swing.JLabel();
        jLabelFundoLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButtonAcessar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAcessar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButtonAcessar.setForeground(new java.awt.Color(49, 74, 110));
        jButtonAcessar.setText("Acessar");
        jButtonAcessar.setAlignmentY(0.0F);
        jButtonAcessar.setAutoscrolls(true);
        jButtonAcessar.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jButtonAcessar.setBorderPainted(false);
        jButtonAcessar.setInheritsPopupMenu(true);
        jButtonAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcessarActionPerformed(evt);
            }
        });
        jButtonAcessar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcessarKeyPressed(evt);
            }
        });
        getContentPane().add(jButtonAcessar);
        jButtonAcessar.setBounds(560, 300, 310, 50);
        jButtonAcessar.getAccessibleContext().setAccessibleParent(jButtonAcessar);

        jLabelUsuario.setBackground(new java.awt.Color(51, 255, 102));
        jLabelUsuario.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(49, 74, 110));
        jLabelUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUsuario.setLabelFor(jLabelUsuario);
        jLabelUsuario.setText("Usuário:");
        jLabelUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabelUsuario.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        getContentPane().add(jLabelUsuario);
        jLabelUsuario.setBounds(350, 140, 220, 40);
        jLabelUsuario.getAccessibleContext().setAccessibleParent(jLabelUsuario);

        jLabelSenha.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabelSenha.setForeground(new java.awt.Color(49, 74, 110));
        jLabelSenha.setText("Senha:");
        jLabelSenha.setAlignmentY(0.0F);
        getContentPane().add(jLabelSenha);
        jLabelSenha.setBounds(400, 200, 210, 40);

        jTextFieldUsuario.setBackground(new java.awt.Color(200, 200, 200));
        jTextFieldUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldUsuario.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextFieldUsuario.setInheritsPopupMenu(true);
        jTextFieldUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldUsuario);
        jTextFieldUsuario.setBounds(530, 140, 370, 40);

        jPasswordFieldSenha.setBackground(new java.awt.Color(200, 200, 200));
        jPasswordFieldSenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordFieldSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordFieldSenha);
        jPasswordFieldSenha.setBounds(530, 200, 370, 40);

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/LeituraAgua/Imagens/Icon login.png"))); // NOI18N
        getContentPane().add(jLabelLogo);
        jLabelLogo.setBounds(650, 20, 120, 120);

        jLabelversão.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelversão.setText("Versão 1.0.1");
        getContentPane().add(jLabelversão);
        jLabelversão.setBounds(470, 640, 80, 15);
        getContentPane().add(mensagemlogin);
        mensagemlogin.setBounds(700, 380, 0, 0);

        jLabelFundoLogin.setBackground(new java.awt.Color(0, 0, 0));
        jLabelFundoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/LeituraAgua/Imagens/Water-Background-1024x682.png"))); // NOI18N
        getContentPane().add(jLabelFundoLogin);
        jLabelFundoLogin.setBounds(0, -20, 1024, 690);

        setSize(new java.awt.Dimension(1036, 703));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcessarActionPerformed
        UsuarioControler controller = new UsuarioControler();
        int senha = Integer.parseInt(new String(jPasswordFieldSenha.getPassword()));
        Usuario usuarioLogado = controller.logarUsuario(jTextFieldUsuario.getText(), senha);
        
        JOptionPane.showMessageDialog(null, controller.getMensagem());
        
        if (usuarioLogado != null && !controller.getMensagem().contains("Erro")){
            TelaPrincipal principal = new TelaPrincipal();
            principal.setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_jButtonAcessarActionPerformed

    private void jTextFieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsuarioActionPerformed

    private void jPasswordFieldSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldSenhaActionPerformed

    private void jButtonAcessarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonAcessarKeyPressed
        // TODO add your handling code here:
         UsuarioControler controller = new UsuarioControler();
        int senha = Integer.parseInt(new String(jPasswordFieldSenha.getPassword()));
        Usuario usuarioLogado = controller.logarUsuario(jTextFieldUsuario.getText(), senha);
        
        JOptionPane.showMessageDialog(null, controller.getMensagem());
        
        if (usuarioLogado != null && !controller.getMensagem().contains("Erro")){
            TelaPrincipal principal = new TelaPrincipal();
            principal.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButtonAcessarKeyPressed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAcessar;
    private javax.swing.JLabel jLabelFundoLogin;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelversão;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldUsuario;
    private javax.swing.JLabel mensagemlogin;
    // End of variables declaration//GEN-END:variables
}
