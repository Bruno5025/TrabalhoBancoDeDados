package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncerrarContaGUI extends JFrame {
    private JTextField numeroContaField;
    private JPasswordField senhaAdminField;
    private JButton encerrarButton, voltarButton;

    public EncerrarContaGUI() {
        setTitle("Banco Malvader - Encerramento de Conta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.DARK_GRAY);

        // Título
        JLabel titleLabel = new JLabel("Encerramento de Conta", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel, BorderLayout.NORTH);

        // Painel de campos de entrada
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBackground(Color.DARK_GRAY);

        JLabel numeroContaLabel = new JLabel("Número da Conta:", SwingConstants.CENTER);
        numeroContaLabel.setForeground(Color.WHITE);
        numeroContaField = new JTextField();

        JLabel senhaAdminLabel = new JLabel("Senha de Administrador:", SwingConstants.CENTER);
        senhaAdminLabel.setForeground(Color.WHITE);
        senhaAdminField = new JPasswordField();

        panel.add(numeroContaLabel);
        panel.add(numeroContaField);
        panel.add(senhaAdminLabel);
        panel.add(senhaAdminField);

        add(panel, BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(Color.DARK_GRAY);

        encerrarButton = new JButton("Encerrar Conta");
        voltarButton = new JButton("Voltar");

        buttonPanel.add(encerrarButton);
        buttonPanel.add(voltarButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Ações dos botões
        encerrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                encerrarConta();
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltarParaMenuFuncionario();
            }
        });
    }

    private void encerrarConta() {
        String numeroConta = numeroContaField.getText();
        String senhaAdmin = new String(senhaAdminField.getPassword());

        // Simulação de verificação de senha e encerramento de conta
        if (senhaAdmin.equals("admin123")) { // Exemplo de senha, ajustar conforme necessidade
            JOptionPane.showMessageDialog(this, "Conta encerrada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Senha de administrador incorreta!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void voltarParaMenuFuncionario() {
        new FuncionarioMenuGUI().setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EncerrarContaGUI().setVisible(true);
            }
        });
    }
}
