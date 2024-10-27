package br.com.cenaflix.podcast;

import br.com.cenaflix.podcast.gui.CenaflixLogin;

/**
 * Método principal que inicia a aplicação.
 *
 */
public class PodcastJPA {

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CenaflixLogin().setVisible(true);
            }
        });
    }
}
