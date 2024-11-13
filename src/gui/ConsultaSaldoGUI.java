package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultaSaldoGUI extends JFrame {
    private JLabel saldoLabel;
    private JButton consultarButton, voltarButton;

    public ConsultaSaldoGUI() {
        setTitle("Banco Malvader - Consulta de Saldo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBackground(new Color(45, 45, 45)); // Fundo cinza escuro

        JLabel titulo = new JLabel("Consulta de Saldo", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        painelPrincipal.add(titulo, BorderLayout.NORTH);

        // Painel centralizado para exibir o saldo
        JPanel painelCentral = new JPanel(new GridBagLayout());
        painelCentral.setBackground(new Color(45, 45, 45));

        saldoLabel = new JLabel("Seu Saldo: R$ 0,00", SwingConstants.CENTER);
        saldoLabel.setFont(new Font("Arial", Font.BOLD, 18));
        saldoLabel.setForeground(Color.WHITE);
        painelCentral.add(saldoLabel);

        painelPrincipal.add(painelCentral, BorderLayout.CENTER);

        // Painel de botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(new Color(45, 45, 45));

        consultarButton = new JButton("Consultar Saldo");
        voltarButton = new JButton("Voltar");

        painelBotoes.add(consultarButton);
        painelBotoes.add(voltarButton);

        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        // Configurações de ações
        consultarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Exemplo de saldo para demonstração
                saldoLabel.setText("Seu Saldo: R$ 1000,00");
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
        SwingUtilities.invokeLater(() -> new ConsultaSaldoGUI().setVisible(true));
    }
}
