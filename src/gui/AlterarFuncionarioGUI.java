package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarFuncionarioGUI extends JFrame {
    private JTextField codigoField, cargoField, telefoneField, enderecoField;
    private JButton salvarButton, voltarButton;

    public AlterarFuncionarioGUI() {
        setTitle("Banco Malvader - Alterar Funcionário");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Alterar Funcionário", SwingConstants.CENTER);
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

        JLabel codigoLabel = new JLabel("Código:");
        codigoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(codigoLabel, gbc);

        codigoField = new JTextField(15);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(codigoField, gbc);

        JLabel cargoLabel = new JLabel("Cargo:");
        cargoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(cargoLabel, gbc);

        cargoField = new JTextField(15);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(cargoField, gbc);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(telefoneLabel, gbc);

        telefoneField = new JTextField(15);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(telefoneField, gbc);

        JLabel enderecoLabel = new JLabel("Endereço Completo:");
        enderecoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(enderecoLabel, gbc);

        enderecoField = new JTextField(15);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(enderecoField, gbc);

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
        SwingUtilities.invokeLater(() -> new AlterarFuncionarioGUI().setVisible(true));
    }
}
