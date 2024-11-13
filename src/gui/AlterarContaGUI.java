package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarContaGUI extends JFrame {
    private JTextField limiteField, vencimentoField;
    private JButton salvarButton, voltarButton;

    public AlterarContaGUI() {
        setTitle("Banco Malvader - Alterar Conta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Alterar Conta", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(30, 30, 30)); // Fundo escuro para combinar com o tema

        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 30, 30));
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel limiteLabel = new JLabel("Limite da Conta:");
        limiteLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(limiteLabel, gbc);

        limiteField = new JTextField(15);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(limiteField, gbc);

        JLabel vencimentoLabel = new JLabel("Data de Vencimento:");
        vencimentoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(vencimentoLabel, gbc);

        vencimentoField = new JTextField(15);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(vencimentoField, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(30, 30, 30));

        salvarButton = new JButton("Salvar Alterações");
        voltarButton = new JButton("Voltar");
        buttonPanel.add(salvarButton);
        buttonPanel.add(voltarButton);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementação da lógica para salvar alterações
                JOptionPane.showMessageDialog(null, "Alterações salvas com sucesso!");
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AlteracaoDadosGUI().setVisible(true);
            }
        });

        add(titleLabel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AlterarContaGUI().setVisible(true));
    }
}
