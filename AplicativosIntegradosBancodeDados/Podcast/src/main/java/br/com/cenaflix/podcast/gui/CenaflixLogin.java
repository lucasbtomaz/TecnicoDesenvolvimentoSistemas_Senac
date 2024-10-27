/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.cenaflix.podcast.gui;

import br.com.cenaflix.podcast.Usuario;
import br.com.cenaflix.podcast.service.UsuarioService;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 * Classe que representa a tela de login da aplicação Cenaflix. Permite aos
 * usuários inserir suas credenciais para acessar o sistema. Baseada em Java
 * Swing, oferece acessibilidade com leitores de tela.
 *
 *  oluca
 */
public class CenaflixLogin extends javax.swing.JFrame {

    private UsuarioService usuarioService = new UsuarioService();

    /**
     * Construtor da classe CenaflixLogin. Inicializa os componentes gráficos da
     * interface de login.
     */
    public CenaflixLogin() {
        initComponents();
    }

    /**
     * Inicializa os componentes da interface gráfica de login. Inclui botões,
     * campos de texto e acessibilidade para leitores de tela.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cenaflix = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        textLogin = new javax.swing.JTextField();
        textSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Cenaflix.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        Cenaflix.setText("CENAFLIX");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Senha:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Login:");

        btnLogin.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnLogin.setText("LOGIN");
        btnLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        textLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textLoginActionPerformed(evt);
            }
        });

        textSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(193, Short.MAX_VALUE)
                .addComponent(Cenaflix)
                .addGap(241, 241, 241))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(textLogin)
                            .addComponent(textSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(156, 156, 156)
                    .addComponent(jLabel2)
                    .addContainerGap(461, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(Cenaflix)
                .addGap(125, 125, 125)
                .addComponent(textLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(textSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnLogin)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(167, 167, 167)
                    .addComponent(jLabel2)
                    .addContainerGap(274, Short.MAX_VALUE)))
        );

        btnLogin.getAccessibleContext().setAccessibleDescription("Botão para acessar o sistema após inserir login e senha");
        textLogin.getAccessibleContext().setAccessibleDescription("Campo para inserir o login do usuário");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textLoginActionPerformed
        textLogin.getAccessibleContext().setAccessibleDescription("Campo de entrada para o login do usuário.");
    }//GEN-LAST:event_textLoginActionPerformed
    /**
     * Método responsável por capturar a ação ao pressionar o botão de login.
     * Verifica as credenciais do usuário e, em caso de sucesso, redireciona
     * para a tela apropriada com base no tipo de usuário.
     *
     * @param evt o evento acionado ao clicar no botão de login
     */
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        btnLogin.getAccessibleContext().setAccessibleDescription("Botão para acessar o sistema após inserir login e senha.");

        String login = textLogin.getText();
        String senha = new String(textSenha.getPassword());

        try {

            Usuario usuarioLogado = usuarioService.validarLogin(login, senha);

            if (usuarioLogado != null) {
                String tipo = usuarioService.verificarPermissoes(usuarioLogado);
                JOptionPane.showMessageDialog(this, "Olá " + usuarioLogado.getNome()
                        + ", sua permissão é de " + usuarioLogado.getTipo() + ". Seja bem-vindo!");

                if (null == tipo) {
                    JOptionPane.showMessageDialog(this, "Você não tem permissões suficientes.",
                            "Erro de permissão", JOptionPane.ERROR_MESSAGE);
                } else // Redirecionar para a tela correspondente de acordo com a permissão do usuário
                switch (tipo) {
                    case "acessoTotal" -> // Administrador, acesso a todas as telas
                        abrirTelaCadastro();
                    case "cadastroListagem" -> // Operador, pode cadastrar e listar
                        abrirTelaCadastro();
                    case "somenteListagem" -> // Usuário, pode apenas listar
                        abrirTelaListagem();
                    default -> JOptionPane.showMessageDialog(this, "Você não tem permissões suficientes.",
                                "Erro de permissão", JOptionPane.ERROR_MESSAGE);
                }
                this.dispose(); // Fecha a tela de login
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao validar login: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnLoginActionPerformed

    private void textSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSenhaActionPerformed
        textSenha.getAccessibleContext().setAccessibleDescription("Campo de entrada para a senha do usuário.");
    }//GEN-LAST:event_textSenhaActionPerformed
    private void abrirTelaCadastro() {
        CadastroPodcast telaCadastro = new CadastroPodcast();
        telaCadastro.setVisible(true);
    }

    private void abrirTelaListagem() {
        ListagemPodcast telaListagem = new ListagemPodcast();
        telaListagem.setVisible(true);
    }

    /**
     * Método principal que inicia a aplicação.
     * 
     * @param args os argumentos de linha de comando
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
            java.util.logging.Logger.getLogger(CenaflixLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CenaflixLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CenaflixLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CenaflixLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CenaflixLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cenaflix;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField textLogin;
    private javax.swing.JPasswordField textSenha;
    // End of variables declaration//GEN-END:variables
}
