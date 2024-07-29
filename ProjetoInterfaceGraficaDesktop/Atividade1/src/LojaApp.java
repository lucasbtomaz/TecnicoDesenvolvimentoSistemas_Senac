
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author oluca
 */
public class LojaApp {
    public static void main(String[] args) {
        // Criação da janela principal
        JFrame frame = new JFrame("Loja - Valor de Venda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        // Campo de entrada de texto
        JTextField valorVendaField = new JTextField(10);
        frame.add(new JLabel("Valor da Venda:"));
        frame.add(valorVendaField);

        // Botão para submeter o valor
        JButton submitButton = new JButton("Calcular");
        frame.add(submitButton);

        // Adicionando ação ao botão
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double valorVenda = Double.parseDouble(valorVendaField.getText());
                    if (valorVenda > 500) {
                        // Mostrar diálogo para informar desconto
                        String descontoStr = JOptionPane.showInputDialog(frame, "Informe o percentual de desconto (%):");
                        if (descontoStr != null && !descontoStr.trim().isEmpty()) {
                            double desconto = Double.parseDouble(descontoStr);
                            double valorFinal = valorVenda - (valorVenda * (desconto / 100));
                            JOptionPane.showMessageDialog(frame, "Valor final com desconto: " + valorFinal);
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Valor final sem desconto: " + valorVenda);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira um valor válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Tornar a janela visível
        frame.setVisible(true);
    }
}