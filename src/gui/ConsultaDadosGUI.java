package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultaDadosGUI extends JFrame {
    private JButton consultarContaButton, consultarFuncionarioButton, consultarClienteButton, voltarButton;

    public ConsultaDadosGUI() {
        setTitle("Banco Malvader - Consulta de Dados");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBackground(new Color(30, 30, 30)); // Fundo cinza escuro

        JLabel titulo = new JLabel("Consulta de Dados", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        painelPrincipal.add(titulo, BorderLayout.NORTH);

        JPanel painelCentral = new JPanel(new GridLayout(0, 1, 10, 10));
        painelCentral.setBackground(new Color(30, 30, 30));

        consultarContaButton = createButton("Consultar Conta");
        consultarFuncionarioButton = createButton("Consultar Funcionário");
        consultarClienteButton = createButton("Consultar Cliente");
        voltarButton = createButton("Voltar");

        painelCentral.add(consultarContaButton);
        painelCentral.add(consultarFuncionarioButton);
        painelCentral.add(consultarClienteButton);
        painelCentral.add(voltarButton);

        painelPrincipal.add(painelCentral, BorderLayout.CENTER);
        add(painelPrincipal);

        // Ações dos botões
        consultarContaButton.addActionListener(e -> {
            new ConsultarContaGUI().setVisible(true);
            dispose();
        });

        consultarFuncionarioButton.addActionListener(e -> {
            new ConsultarFuncionarioGUI().setVisible(true);
            dispose();
        });

        consultarClienteButton.addActionListener(e -> {
            new ConsultarClienteGUI().setVisible(true);
            dispose();
        });

        voltarButton.addActionListener(e -> {
            new FuncionarioMenuGUI().setVisible(true);
            dispose();
        });
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setBackground(new Color(200, 200, 200));
        button.setFocusPainted(false);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConsultaDadosGUI().setVisible(true));
    }
}
