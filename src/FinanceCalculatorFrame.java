import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinanceCalculatorFrame extends JFrame {

    private final FinanceCalculator calculator;

    public FinanceCalculatorFrame() {
        calculator = new FinanceCalculator();
        setTitle("Finance Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de Botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1));

        JButton btnAnuidadeOrdinaria = new JButton("Anuidade Ordinária");
        JButton btnAnuidadeVencida = new JButton("Anuidade Vencida");
        JButton btnPerpetuidade = new JButton("Perpetuidade");
        JButton btnSerieMista = new JButton("Série Mista");
        JButton btnAmortizacao = new JButton("Amortização");

        buttonPanel.add(btnAnuidadeOrdinaria);
        buttonPanel.add(btnAnuidadeVencida);
        buttonPanel.add(btnPerpetuidade);
        buttonPanel.add(btnSerieMista);
        buttonPanel.add(btnAmortizacao);

        add(buttonPanel, BorderLayout.CENTER);

        // Configurar ações dos botões
        btnAnuidadeOrdinaria.addActionListener(e -> calcularAnuidadeOrdinaria());
        btnAnuidadeVencida.addActionListener(e -> calcularAnuidadeVencida());
        btnPerpetuidade.addActionListener(e -> calcularPerpetuidade());
        btnSerieMista.addActionListener(e -> calcularSerieMista());
        btnAmortizacao.addActionListener(e -> calcularAmortizacao());
    }

    private void calcularAnuidadeOrdinaria() {
        double fluxoCaixa = Double.parseDouble(JOptionPane.showInputDialog("Fluxo de Caixa:"));
        int anos = Integer.parseInt(JOptionPane.showInputDialog("Número de anos:"));
        double taxa = Double.parseDouble(JOptionPane.showInputDialog("Taxa (em decimal):"));

        double resultado = calculator.calcularAnuidadeOrdinaria(fluxoCaixa, anos, taxa);
        JOptionPane.showMessageDialog(this, "O valor máximo a pagar pela anuidade ordinária é: $" + resultado);
    }

    private void calcularAnuidadeVencida() {
        double fluxoCaixa = Double.parseDouble(JOptionPane.showInputDialog("Fluxo de Caixa:"));
        int anos = Integer.parseInt(JOptionPane.showInputDialog("Número de anos:"));
        double taxa = Double.parseDouble(JOptionPane.showInputDialog("Taxa (em decimal):"));

        double resultado = calculator.calcularAnuidadeVencida(fluxoCaixa, anos, taxa);
        JOptionPane.showMessageDialog(this, "O valor máximo a pagar pela anuidade vencida é: $" + resultado);
    }

    private void calcularPerpetuidade() {
        double fluxoAnual = Double.parseDouble(JOptionPane.showInputDialog("Fluxo Anual:"));
        double taxa = Double.parseDouble(JOptionPane.showInputDialog("Taxa (em decimal):"));

        double resultado = calculator.calcularPerpetuidade(fluxoAnual, taxa);
        JOptionPane.showMessageDialog(this, "O valor presente da perpetuidade é: $" + resultado);
    }

    private void calcularSerieMista() {
        int numFluxos = Integer.parseInt(JOptionPane.showInputDialog("Número de fluxos de caixa:"));
        double[] fluxos = new double[numFluxos];
        for (int i = 0; i < numFluxos; i++) {
            fluxos[i] = Double.parseDouble(JOptionPane.showInputDialog("Fluxo " + (i + 1) + ":"));
        }
        double taxa = Double.parseDouble(JOptionPane.showInputDialog("Taxa (em decimal):"));

        double resultado = calculator.calcularSerieMista(fluxos, taxa);
        JOptionPane.showMessageDialog(this, "O valor presente da série mista é: $" + resultado);

    }


    private void calcularAmortizacao() {
        double principal = Double.parseDouble(JOptionPane.showInputDialog("Principal:"));
        double taxa = Double.parseDouble(JOptionPane.showInputDialog("Taxa (em decimal):"));
        int anos = Integer.parseInt(JOptionPane.showInputDialog("Número de anos:"));

        double[] resultados = calculator.calcularAmortizacao(principal, taxa, anos);
        StringBuilder sb = new StringBuilder("Ano | Valor Devido\n");
        for (int i = 0; i < resultados.length; i++) {
            sb.append(i + 1).append("   | $").append(String.format("%.2f", resultados[i])).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }
}


