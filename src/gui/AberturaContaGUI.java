package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AberturaContaGUI extends JFrame {
    private JTextField agenciaField, numeroContaField, nomeClienteField, cpfField, dataNascimentoField, telefoneField, enderecoField, cepField, localField, numeroCasaField, bairroField, cidadeField, estadoField, senhaField;
    private JTextField limiteField, dataVencimentoField;
    private JComboBox<String> tipoContaComboBox;
    private JButton abrirContaButton, voltarButton;

    public AberturaContaGUI() {
        setTitle("Banco Malvader - Abertura de Conta");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBackground(new Color(45, 45, 45)); // Fundo cinza escuro

        JLabel titulo = new JLabel("Abertura de Conta", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        painelPrincipal.add(titulo, BorderLayout.NORTH);

        // Painel centralizado para os campos de entrada
        JPanel painelCentral = new JPanel(new GridBagLayout());
        painelCentral.setBackground(new Color(45, 45, 45));
        painelPrincipal.add(painelCentral, BorderLayout.CENTER);

        JPanel painelCampos = new JPanel(new GridLayout(0, 2, 10, 10));
        painelCampos.setBackground(new Color(45, 45, 45));

        tipoContaComboBox = new JComboBox<>(new String[]{"Conta Poupança", "Conta Corrente"});
        painelCampos.add(new JLabel("Tipo de Conta:", SwingConstants.RIGHT)).setForeground(Color.WHITE);
        painelCampos.add(tipoContaComboBox);

        agenciaField = createTextField(painelCampos, "Agência:");
        numeroContaField = createTextField(painelCampos, "Número da Conta:");
        nomeClienteField = createTextField(painelCampos, "Nome do Cliente:");
        cpfField = createTextField(painelCampos, "CPF:");
        dataNascimentoField = createTextField(painelCampos, "Data de Nascimento:");
        telefoneField = createTextField(painelCampos, "Telefone:");
        enderecoField = createTextField(painelCampos, "Endereço Completo:");
        cepField = createTextField(painelCampos, "CEP:");
        localField = createTextField(painelCampos, "Local:");
        numeroCasaField = createTextField(painelCampos, "Número da Casa:");
        bairroField = createTextField(painelCampos, "Bairro:");
        cidadeField = createTextField(painelCampos, "Cidade:");
        estadoField = createTextField(painelCampos, "Estado:");
        senhaField = createTextField(painelCampos, "Senha do Cliente:");

        limiteField = createTextField(painelCampos, "Limite da Conta:");
        dataVencimentoField = createTextField(painelCampos, "Data de Vencimento:");

        // Inicialmente, esconde campos específicos da Conta Corrente
        limiteField.setVisible(false);
        dataVencimentoField.setVisible(false);

        tipoContaComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean isContaCorrente = tipoContaComboBox.getSelectedItem().equals("Conta Corrente");
                limiteField.setVisible(isContaCorrente);
                dataVencimentoField.setVisible(isContaCorrente);
            }
        });

        painelCentral.add(painelCampos, new GridBagConstraints());

        // Painel de botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(new Color(45, 45, 45));

        abrirContaButton = new JButton("Abrir Conta");
        voltarButton = new JButton("Voltar");

        painelBotoes.add(abrirContaButton);
        painelBotoes.add(voltarButton);

        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        // Configurações de ações
        abrirContaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Conta aberta com sucesso!");
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FuncionarioMenuGUI().setVisible(true);
                dispose();
            }
        });

        add(painelPrincipal);
    }

    private JTextField createTextField(JPanel panel, String label) {
        JLabel jLabel = new JLabel(label, SwingConstants.RIGHT);
        jLabel.setForeground(Color.WHITE);
        panel.add(jLabel);
        JTextField textField = new JTextField(15);
        panel.add(textField);
        return textField;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AberturaContaGUI().setVisible(true));
    }
}
