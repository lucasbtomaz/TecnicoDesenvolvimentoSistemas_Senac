package br.com.pridecare.entity;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe de funções utilitárias.
 * 
 * @autor oluca
 */
public class Functions {

    // Constantes para a geração de senha temporária
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int PASSWORD_LENGTH = 6;
    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * Método para validar o endereço de email.
     * 
     * @param email Endereço de email a ser validado.
     * @return true se o endereço de email for válido, caso contrário false.
     */
    public static boolean isValidEmailAddress(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Método para gerar uma senha temporária.
     * 
     * @return Uma senha temporária gerada.
     */
    public static String gerarSenhaTemporaria() {
        StringBuilder senha = new StringBuilder(PASSWORD_LENGTH);
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            senha.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return senha.toString();
    }
}
