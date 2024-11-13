package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroFuncionarioGUI extends JFrame {
    private JTextField codigoField, cargoField, nomeField, cpfField, dataNascimentoField, telefoneField, enderecoField;
    private JButton cadastrarButton, voltarButton;

    public CadastroFuncionarioGUI() {
        setTitle("Cadastro de Funcionário");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel principal com fundo preto
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.BLACK);
        add(mainPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Título
        JLabel titleLabel = new JLabel("Cadastro de Funcionário");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(titleLabel, gbc);
        gbc.gridwidth = 1;

        // Campos de entrada
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridy = 1;
        mainPanel.add(createLabel("Código:"), gbc);
        codigoField = createTextField();
        gbc.gridx = 1;
        mainPanel.add(codigoField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(createLabel("Cargo:"), gbc);
        cargoField = createTextField();
        gbc.gridx = 1;
        mainPanel.add(cargoField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(createLabel("Nome:"), gbc);
        nomeField = createTextField();
        gbc.gridx = 1;
        mainPanel.add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(createLabel("CPF:"), gbc);
        cpfField = createTextField();
        gbc.gridx = 1;
        mainPanel.add(cpfField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(createLabel("Data de Nascimento:"), gbc);
        dataNascimentoField = createTextField();
        gbc.gridx = 1;
        mainPanel.add(dataNascimentoField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(createLabel("Telefone:"), gbc);
        telefoneField = createTextField();
        gbc.gridx = 1;
        mainPanel.add(telefoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(createLabel("Endereço Completo:"), gbc);
        enderecoField = createTextField();
        gbc.gridx = 1;
        mainPanel.add(enderecoField, gbc);

        // Painel para botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        cadastrarButton = new JButton("Cadastrar");
        voltarButton = new JButton("Voltar");

        // Estilo dos botões
        cadastrarButton.setBackground(Color.LIGHT_GRAY);
        voltarButton.setBackground(Color.LIGHT_GRAY);

        buttonPanel.add(cadastrarButton);
        buttonPanel.add(voltarButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Ações dos botões
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ação de cadastro
                JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FuncionarioMenuGUI().setVisible(true);
            }
        });
    }

    // Método auxiliar para criar labels
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        return label;
    }

    // Método auxiliar para criar campos de texto
    private JTextField createTextField() {
        return new JTextField(15);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CadastroFuncionarioGUI().setVisible(true);
            }
        });
    }
}
