package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarClienteGUI extends JFrame {
    private JTextField cpfClienteField;
    private JTextArea resultadoArea;

    public ConsultarClienteGUI() {
        setTitle("Banco Malvader - Consultar Cliente");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Título
        JLabel tituloLabel = new JLabel("Consultar Cliente", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 22));
        tituloLabel.setForeground(Color.WHITE);

        // Painel de entrada de dados
        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new GridBagLayout());
        painelEntrada.setBackground(Color.DARK_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // CPF do Cliente
        JLabel cpfClienteLabel = new JLabel("CPF do Cliente:");
        cpfClienteLabel.setForeground(Color.WHITE);
        cpfClienteLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        painelEntrada.add(cpfClienteLabel, gbc);

        cpfClienteField = new JTextField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        painelEntrada.add(cpfClienteField, gbc);

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
                consultarCliente();
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

    private void consultarCliente() {
        String cpfCliente = cpfClienteField.getText().trim();

        if (cpfCliente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira o CPF do cliente.", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Exibir informações simuladas
            resultadoArea.setText("Exibindo informações do cliente com CPF: " + cpfCliente + "\n...");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConsultarClienteGUI().setVisible(true));
    }
}
