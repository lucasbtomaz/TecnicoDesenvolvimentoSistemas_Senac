/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MedicaoPressaoApp;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 *  oluca
 */
public class MedicaoPressaoApp extends JFrame {

    private JTextField txtData, txtHora, txtSistolica, txtDiastolica;
    private JCheckBox chkEstresse;
    private JTable tabelaHistorico;
    private DefaultTableModel modeloTabela;
    private Font fonteMaior = new Font("Arial", Font.PLAIN, 18);

    public MedicaoPressaoApp() {
        setTitle("Registro de Medições de Pressão");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Instanciando campos de texto antes de serem usados
        txtData = new JTextField();
        txtHora = new JTextField();
        txtSistolica = new JTextField();
        txtDiastolica = new JTextField();
        chkEstresse = new JCheckBox("Em situação de estresse");

        // Configurando a fonte maior para os componentes
        JLabel lblData = new JLabel("Data (dd/mm/yyyy): ");
        lblData.setLabelFor(txtData);
        lblData.setDisplayedMnemonic('D');
        lblData.setFont(fonteMaior);
        txtData.setToolTipText("Informe a data da medição no formato dd/mm/aaaa");
        txtData.setFont(fonteMaior);

        JLabel lblHora = new JLabel("Hora (HH:mm): ");
        lblHora.setLabelFor(txtHora);
        lblHora.setDisplayedMnemonic('H');
        lblHora.setFont(fonteMaior);
        txtHora.setToolTipText("Informe a hora da medição no formato HH:mm");
        txtHora.setFont(fonteMaior);

        JLabel lblSistolica = new JLabel("Pressão Sistólica: ");
        lblSistolica.setLabelFor(txtSistolica);
        lblSistolica.setDisplayedMnemonic('S');
        lblSistolica.setFont(fonteMaior);
        txtSistolica.setToolTipText("Informe a pressão sistólica");
        txtSistolica.setFont(fonteMaior);

        JLabel lblDiastolica = new JLabel("Pressão Diastólica: ");
        lblDiastolica.setLabelFor(txtDiastolica);
        lblDiastolica.setDisplayedMnemonic('I');
        lblDiastolica.setFont(fonteMaior);
        txtDiastolica.setToolTipText("Informe a pressão diastólica");
        txtDiastolica.setFont(fonteMaior);

        chkEstresse.setMnemonic('E');
        chkEstresse.setToolTipText("Marque se estava em situação de estresse no momento da medição");
        chkEstresse.setFont(fonteMaior);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setMnemonic('V');
        btnSalvar.setToolTipText("Clique para salvar a medição");
        btnSalvar.setFont(fonteMaior);

        modeloTabela = new DefaultTableModel(new String[]{"Data", "Hora", "Sistólica", "Diastólica", "Estresse"}, 0);
        tabelaHistorico = new JTable(modeloTabela);
        tabelaHistorico.setFont(fonteMaior);
        tabelaHistorico.getTableHeader().setFont(fonteMaior);
        tabelaHistorico.getAccessibleContext().setAccessibleDescription("Tabela exibindo o histórico de medições de pressão");

        JScrollPane scrollPane = new JScrollPane(tabelaHistorico);
        tabelaHistorico.setFillsViewportHeight(true);

        JPanel painelCampos = new JPanel(new GridLayout(5, 2, 5, 5));
        painelCampos.add(lblData);
        painelCampos.add(txtData);
        painelCampos.add(lblHora);
        painelCampos.add(txtHora);
        painelCampos.add(lblSistolica);
        painelCampos.add(txtSistolica);
        painelCampos.add(lblDiastolica);
        painelCampos.add(txtDiastolica);
        painelCampos.add(new JLabel(""));  // Placeholder
        painelCampos.add(chkEstresse);

        JPanel painelSalvar = new JPanel();
        painelSalvar.add(btnSalvar);

        add(painelCampos, BorderLayout.NORTH);
        add(painelSalvar, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarMedicao();
            }
        });

        carregarHistorico();
    }

    private void carregarHistorico() {
        try (BufferedReader br = new BufferedReader(new FileReader("medicoes.csv"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                modeloTabela.addRow(dados);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Arquivo de histórico não encontrado. Um novo será criado ao salvar a primeira medição.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar o histórico de medições.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void salvarMedicao() {
        try {
            String data = txtData.getText().trim();
            String hora = txtHora.getText().trim();
            String sistolicaStr = txtSistolica.getText().trim();
            String diastolicaStr = txtDiastolica.getText().trim();

            if (!data.matches("\\d{2}/\\d{2}/\\d{4}")) {
                JOptionPane.showMessageDialog(this, "Por favor, insira a data no formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!hora.matches("\\d{2}:\\d{2}")) {
                JOptionPane.showMessageDialog(this, "Por favor, insira a hora no formato HH:mm.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int sistolica = Integer.parseInt(sistolicaStr);
            int diastolica = Integer.parseInt(diastolicaStr);

            boolean estresse = chkEstresse.isSelected();
            String estresseTexto = estresse ? "Sim" : "Não";
            String[] linha = {data, hora, String.valueOf(sistolica), String.valueOf(diastolica), estresseTexto};

            modeloTabela.addRow(linha);

            try (FileWriter writer = new FileWriter("medicoes.csv", true)) {
                writer.write(String.join(",", linha) + "\n");
            }

            txtData.setText("");
            txtHora.setText("");
            txtSistolica.setText("");
            txtDiastolica.setText("");
            chkEstresse.setSelected(false);

            JOptionPane.showMessageDialog(this, "Medição salva com sucesso!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos para pressão.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar a medição.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MedicaoPressaoApp().setVisible(true);
        });
    }
}
