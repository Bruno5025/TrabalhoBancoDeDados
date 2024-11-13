package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositoGUI extends JFrame {
    private JTextField valorDepositoField;
    private JButton confirmarButton, voltarButton;

    public DepositoGUI() {
        setTitle("Banco Malvader - Depósito");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBackground(new Color(45, 45, 45));

        JLabel titulo = new JLabel("Depósito", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        painelPrincipal.add(titulo, BorderLayout.NORTH);

        // Painel central para o campo de entrada
        JPanel painelCentral = new JPanel(new GridBagLayout());
        painelCentral.setBackground(new Color(45, 45, 45));
        painelPrincipal.add(painelCentral, BorderLayout.CENTER);

        JPanel painelCampos = new JPanel(new GridLayout(2, 1, 10, 10));
        painelCampos.setBackground(new Color(45, 45, 45));

        JLabel valorLabel = new JLabel("Valor do Depósito:", SwingConstants.CENTER);
        valorLabel.setForeground(Color.WHITE);
        painelCampos.add(valorLabel);

        valorDepositoField = new JTextField(15);
        painelCampos.add(valorDepositoField);

        painelCentral.add(painelCampos, new GridBagConstraints());

        // Painel de botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(new Color(45, 45, 45));

        confirmarButton = new JButton("Confirmar Depósito");
        voltarButton = new JButton("Voltar");

        painelBotoes.add(confirmarButton);
        painelBotoes.add(voltarButton);

        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        // Configurações de ações
        confirmarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String valor = valorDepositoField.getText();
                if (!valor.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Depósito de R$ " + valor + " realizado com sucesso!");
                    valorDepositoField.setText(""); // Limpa o campo após o depósito
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um valor para o depósito.");
                }
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ClienteMenuGUI().setVisible(true);
                dispose();
            }
        });

        add(painelPrincipal);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DepositoGUI().setVisible(true));
    }
}
