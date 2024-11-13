package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarContaGUI extends JFrame {
    private JTextField numeroContaField;
    private JTextArea resultadoArea;

    public ConsultarContaGUI() {
        setTitle("Banco Malvader - Consultar Conta");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Título
        JLabel tituloLabel = new JLabel("Consultar Conta", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 22));
        tituloLabel.setForeground(Color.WHITE);

        // Painel de entrada de dados
        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new GridBagLayout());
        painelEntrada.setBackground(Color.DARK_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Número da conta
        JLabel numeroContaLabel = new JLabel("Número da Conta:");
        numeroContaLabel.setForeground(Color.WHITE);
        numeroContaLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        painelEntrada.add(numeroContaLabel, gbc);

        numeroContaField = new JTextField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        painelEntrada.add(numeroContaField, gbc);

        // Área de resultados
        resultadoArea = new JTextArea(8, 40);
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(resultadoArea);

        // Painel de botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(Color.DARK_GRAY);
        JButton consultarButton = new JButton("Consultar");
        JButton voltarButton = new JButton("Voltar");

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarConta();
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FuncionarioMenuGUI().setVisible(true);
            }
        });

        painelBotoes.add(consultarButton);
        painelBotoes.add(voltarButton);

        // Adicionar componentes ao frame
        add(tituloLabel, BorderLayout.NORTH);
        add(painelEntrada, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
        add(painelBotoes, BorderLayout.PAGE_END);

        getContentPane().setBackground(Color.DARK_GRAY); // Cor de fundo do frame
    }

    private void consultarConta() {
        String numeroConta = numeroContaField.getText().trim();

        if (numeroConta.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira o número da conta.", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Exibir informações simuladas
            resultadoArea.setText("Exibindo informações da conta número: " + numeroConta + "\n...");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConsultarContaGUI().setVisible(true));
    }
}
