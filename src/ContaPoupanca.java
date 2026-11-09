public class ContaPoupanca extends Conta {
    private double taxaRendimento = 0.005; // 0.5% ao mês

    public ContaPoupanca(String titular) {
        super(titular);
    }

    public void aplicarRendimento() {
        double rendimento = this.saldo * taxaRendimento;
        this.saldo += rendimento;
        System.out.println("📈 Rendimento de R$ " + String.format("%.2f", rendimento) + " aplicado à poupança!");
    }
}