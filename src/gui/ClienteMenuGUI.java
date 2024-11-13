package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteMenuGUI extends JFrame {
    private JButton visualizarContaButton, consultarSaldoButton, depositoButton, saqueButton, logoutButton;

    public ClienteMenuGUI() {
        setTitle("Banco Malvader - Menu do Cliente");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBackground(new Color(45, 45, 45));

        JLabel titulo = new JLabel("Menu do Cliente", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        painelPrincipal.add(titulo, BorderLayout.NORTH);

        // Painel central com as opções
        JPanel painelOpcoes = new JPanel(new GridLayout(5, 1, 10, 10)); // 5 linhas para incluir o Logout
        painelOpcoes.setBackground(new Color(45, 45, 45));

        visualizarContaButton = createStyledButton("Visualizar Conta");
        consultarSaldoButton = createStyledButton("Consultar Saldo");
        depositoButton = createStyledButton("Depósito");
        saqueButton = createStyledButton("Saque");
        logoutButton = createStyledButton("Logout");

        painelOpcoes.add(visualizarContaButton);
        painelOpcoes.add(consultarSaldoButton);
        painelOpcoes.add(depositoButton);
        painelOpcoes.add(saqueButton);
        painelOpcoes.add(logoutButton);

        painelPrincipal.add(painelOpcoes, BorderLayout.CENTER);

        // Ações dos botões
        visualizarContaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new VisualizarContaGUI().setVisible(true);
                dispose();
            }
        });

        consultarSaldoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ConsultaSaldoGUI().setVisible(true);
                dispose();
            }
        });

        depositoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DepositoGUI().setVisible(true);
                dispose();
            }
        });

        saqueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SaqueGUI().setVisible(true);
                dispose();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginGUI().setVisible(true);
                dispose();
            }
        });

        add(painelPrincipal);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setBackground(new Color(200, 200, 200));
        button.setForeground(Color.BLACK);
        button.setPreferredSize(new Dimension(380, 50)); // Ajuste para preencher bem o painel
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClienteMenuGUI().setVisible(true));
    }
}
