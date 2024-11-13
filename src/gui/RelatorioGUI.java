package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RelatorioGUI extends JFrame {
    private JTextArea textArea;
    private JButton visualizarRelatorioButton, exportarParaExcelButton, voltarButton;

    public RelatorioGUI() {
        setTitle("Banco Malvader - Relatórios e Estatísticas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBackground(Color.BLACK);

        JLabel titulo = new JLabel("Relatórios e Estatísticas da Horta", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        painelPrincipal.add(titulo, BorderLayout.NORTH);

        // Área de texto para exibir o relatório
        textArea = new JTextArea("Exemplo de relatório gerado...\nDados estatísticos...");
        textArea.setEditable(true);  // Permite edição na área de texto
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(Color.WHITE);
        textArea.setForeground(Color.BLACK);
        painelPrincipal.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Painel de botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(Color.BLACK);

        visualizarRelatorioButton = new JButton("Visualizar Relatório");
        exportarParaExcelButton = new JButton("Exportar para Excel");
        voltarButton = new JButton("Voltar");

        painelBotoes.add(visualizarRelatorioButton);
        painelBotoes.add(exportarParaExcelButton);
        painelBotoes.add(voltarButton);

        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        // Configurações de ações dos botões
        visualizarRelatorioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("Relatório atualizado com os dados mais recentes...");
            }
        });

        exportarParaExcelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Relatório exportado para Excel com sucesso!");
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RelatorioGUI().setVisible(true));
    }
}
