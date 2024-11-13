package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncionarioMenuGUI extends JFrame {
    private JButton abrirContaButton, encerrarContaButton, consultaDadosButton, alterarDadosButton, cadastroFuncionarioButton, relatorioButton, logoutButton;

    public FuncionarioMenuGUI() {
        setTitle("Banco Malvader - Menu do Funcionário");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBackground(new Color(30, 30, 30)); // Fundo cinza escuro

        JLabel titulo = new JLabel("Menu do Funcionário", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(Color.WHITE);
        painelPrincipal.add(titulo, BorderLayout.NORTH);

        JPanel painelCentral = new JPanel(new GridLayout(0, 1, 10, 10));
        painelCentral.setBackground(new Color(30, 30, 30));

        abrirContaButton = createButton("Abertura de Conta");
        encerrarContaButton = createButton("Encerramento de Conta");
        consultaDadosButton = createButton("Consulta de Dados");
        alterarDadosButton = createButton("Alteração de Dados");
        cadastroFuncionarioButton = createButton("Cadastro de Funcionário");
        relatorioButton = createButton("Relatórios e Estatísticas");
        logoutButton = createButton("Logout");

        painelCentral.add(abrirContaButton);
        painelCentral.add(encerrarContaButton);
        painelCentral.add(consultaDadosButton);
        painelCentral.add(alterarDadosButton);
        painelCentral.add(cadastroFuncionarioButton);
        painelCentral.add(relatorioButton);
        painelCentral.add(logoutButton);

        painelPrincipal.add(painelCentral, BorderLayout.CENTER);
        add(painelPrincipal);

        // Ações dos botões
        abrirContaButton.addActionListener(e -> {
            new AberturaContaGUI().setVisible(true);
            dispose();
        });

        encerrarContaButton.addActionListener(e -> {
            new EncerrarContaGUI().setVisible(true);
            dispose();
        });

        consultaDadosButton.addActionListener(e -> {
            new ConsultaDadosGUI().setVisible(true);
            dispose();
        });

        alterarDadosButton.addActionListener(e -> {
            new AlteracaoDadosGUI().setVisible(true);
            dispose();
        });

        cadastroFuncionarioButton.addActionListener(e -> {
            new CadastroFuncionarioGUI().setVisible(true);
            dispose();
        });

        relatorioButton.addActionListener(e -> {
            new RelatorioGUI().setVisible(true);
            dispose();
        });

        logoutButton.addActionListener(e -> {
            new LoginGUI().setVisible(true);
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
        SwingUtilities.invokeLater(() -> new FuncionarioMenuGUI().setVisible(true));
    }
}
