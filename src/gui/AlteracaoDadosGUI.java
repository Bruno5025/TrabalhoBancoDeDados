package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlteracaoDadosGUI extends JFrame {
    public AlteracaoDadosGUI() {
        setTitle("Banco Malvader - Alteração de Dados");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Título
        JLabel tituloLabel = new JLabel("Alteração de Dados", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 22));
        tituloLabel.setForeground(Color.WHITE);

        // Painel de botões de opções
        JPanel painelOpcoes = new JPanel(new GridLayout(3, 1, 10, 10));
        painelOpcoes.setBackground(Color.DARK_GRAY);

        JButton alterarContaButton = new JButton("Alterar Conta");
        JButton alterarFuncionarioButton = new JButton("Alterar Funcionário");
        JButton alterarClienteButton = new JButton("Alterar Cliente");

        painelOpcoes.add(alterarContaButton);
        painelOpcoes.add(alterarFuncionarioButton);
        painelOpcoes.add(alterarClienteButton);

        // Painel de botão de voltar
        JPanel painelVoltar = new JPanel();
        painelVoltar.setBackground(Color.DARK_GRAY);
        JButton voltarButton = new JButton("Voltar");

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FuncionarioMenuGUI().setVisible(true);
            }
        });

        painelVoltar.add(voltarButton);

        // Ação dos botões de alteração
        alterarContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AlterarContaGUI().setVisible(true);  // Esta interface será criada em breve
            }
        });

        alterarFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AlterarFuncionarioGUI().setVisible(true);  // Esta interface será criada em breve
            }
        });

        alterarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AlterarClienteGUI().setVisible(true);  // Esta interface será criada em breve
            }
        });

        // Adicionar componentes ao frame
        add(tituloLabel, BorderLayout.NORTH);
        add(painelOpcoes, BorderLayout.CENTER);
        add(painelVoltar, BorderLayout.SOUTH);

        getContentPane().setBackground(Color.DARK_GRAY); // Cor de fundo do frame
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AlteracaoDadosGUI().setVisible(true));
    }
}
