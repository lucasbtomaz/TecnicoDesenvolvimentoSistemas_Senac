package br.com.pridecare;

import br.com.pridecare.gui.Login;

/**
 * Classe principal do projeto que abre a tela de Login ao iniciar a aplicação.
 */
public class PrideCare {

    public static void main(String[] args) {
        // Exibir a tela de Login
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }
}

