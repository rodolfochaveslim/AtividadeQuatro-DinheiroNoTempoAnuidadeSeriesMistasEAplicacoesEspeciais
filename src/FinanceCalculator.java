public class FinanceCalculator {

    public double calcularAnuidadeOrdinaria(double fluxoCaixa, int anos, double taxa) {
        return fluxoCaixa * ((1 - Math.pow(1 + taxa, -anos)) / taxa);
    }

    public double calcularAnuidadeVencida(double fluxoCaixa, int anos, double taxa) {
        return calcularAnuidadeOrdinaria(fluxoCaixa, anos, taxa) * (1 + taxa);
    }

    public double calcularPerpetuidade(double fluxoAnual, double taxa) {
        return fluxoAnual / taxa;
    }

    public double calcularSerieMista(double[] fluxos, double taxa) {
        double valorPresente = 0;
        for (int t = 0; t < fluxos.length; t++) {
            valorPresente += fluxos[t] / Math.pow(1 + taxa, t + 1);
        }
        return valorPresente;
    }

    public double[] calcularAmortizacao(double principal, double taxa, int anos) {
        double[] valoresDevidos = new double[anos];
        for (int ano = 1; ano <= anos; ano++) {
            valoresDevidos[ano - 1] = principal * Math.pow(1 + taxa, ano);
        }
        return valoresDevidos;
    }
}
