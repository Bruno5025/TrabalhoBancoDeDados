package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualizarContaGUI extends JFrame {
    private JTextField numeroContaField, nomeClienteField, saldoField, tipoContaField, limiteField;
    private JButton voltarButton;

    public VisualizarContaGUI() {
        setTitle("Banco Malvader - Visualizar Conta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBackground(new Color(45, 45, 45)); // Fundo cinza escuro

        JLabel titulo = new JLabel("Visualizar Conta", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        painelPrincipal.add(titulo, BorderLayout.NORTH);

        // Painel centralizado para os campos de visualização com espaçamento para centralizar
        JPanel painelCentral = new JPanel(new GridBagLayout());
        painelCentral.setBackground(new Color(45, 45, 45));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        addLabelAndField(painelCentral, gbc, "Número da Conta:", numeroContaField = new JTextField(15));
        addLabelAndField(painelCentral, gbc, "Nome do Cliente:", nomeClienteField = new JTextField(15));
        addLabelAndField(painelCentral, gbc, "Tipo de Conta:", tipoContaField = new JTextField(15));
        addLabelAndField(painelCentral, gbc, "Saldo:", saldoField = new JTextField(15));
        addLabelAndField(painelCentral, gbc, "Limite:", limiteField = new JTextField(15));

        numeroContaField.setEditable(false);
        nomeClienteField.setEditable(false);
        tipoContaField.setEditable(false);
        saldoField.setEditable(false);
        limiteField.setEditable(false);

        painelPrincipal.add(painelCentral, BorderLayout.CENTER);

        // Painel de botão centralizado
        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(new Color(45, 45, 45));
        voltarButton = new JButton("Voltar");
        painelBotoes.add(voltarButton);

        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        // Configuração de ações
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ClienteMenuGUI().setVisible(true);
                dispose();
            }
        });

        add(painelPrincipal);
    }

    private void addLabelAndField(JPanel panel, GridBagConstraints gbc, String labelText, JTextField textField) {
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        JLabel label = new JLabel(labelText, SwingConstants.RIGHT);
        label.setForeground(Color.WHITE);
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(textField, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VisualizarContaGUI().setVisible(true));
    }
}
