
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Muchsin
 */
public class Login extends javax.swing.JFrame {
    static String user;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        disableMaximize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Logo.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, -20, 170, 230);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Mitratel.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(180, 40, 310, 120);

        jLabel3.setFont(new java.awt.Font("Futura Bk BT", 1, 14)); // NOI18N
        jLabel3.setText("Username");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 180, 90, 30);

        jLabel4.setFont(new java.awt.Font("Futura Bk BT", 1, 14)); // NOI18N
        jLabel4.setText("Password");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 220, 90, 30);
        jPanel1.add(txtnama);
        txtnama.setBounds(110, 180, 250, 30);
        jPanel1.add(txtpass);
        txtpass.setBounds(110, 220, 250, 30);

        btnLogin.setFont(new java.awt.Font("Futura Bk BT", 1, 12)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin);
        btnLogin.setBounds(370, 220, 110, 30);

        btnSignUp.setFont(new java.awt.Font("Futura Bk BT", 1, 12)); // NOI18N
        btnSignUp.setText("Sign Up");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        jPanel1.add(btnSignUp);
        btnSignUp.setBounds(370, 180, 110, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 500, 270);

        setSize(new java.awt.Dimension(512, 303));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        // TODO add your handling code here:
        String username = txtnama.getText();
        String password = txtpass.getText();

        try {
            try (Statement statement = (Statement) file_koneksi.GetConnection().createStatement()){
                statement.executeUpdate("INSERT INTO `tb_akun`(`username`, `password`) VALUES ('"+username+"','"+password+"');");
            }
            JOptionPane.showMessageDialog(null,"Selamat! Anda berhasil Sign Up!");
        }catch (Exception t){
            JOptionPane.showMessageDialog(null, "Mohon Maaf anda gagal Sign Up ,\n, Coba Lagi ya!");
        }
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        Connection connection;
        PreparedStatement ps;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mitratel?zeroDateTimeBehavior=convertToNull", "root", "");
            ps = connection.prepareStatement("SELECT `username`, `password` FROM `tb_akun` WHERE username = ? AND password = ?");
            ps.setString(1, txtnama.getText());
            ps.setString(2, txtpass.getText());
            ResultSet result = ps.executeQuery();
            if(result.next()){
                new Main().show();
                user = txtnama.getText();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(rootPane,"Username atau Password salah!");
                txtpass.setText("");
                txtnama.requestFocus();
            }
        }   
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "GAGAL");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void disableMaximize(){
        setExtendedState(Main.MAXIMIZED_HORIZ);
        setVisible(true);
        setResizable(false);
    }
    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtnama;
    private javax.swing.JPasswordField txtpass;
    // End of variables declaration//GEN-END:variables
}
