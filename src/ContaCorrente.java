public class ContaCorrente extends Conta {
    private double taxaSaque = 2.50;

    public ContaCorrente(String titular) {
        super(titular);
    }

    @Override
    public boolean sacar(double valor) {
        double valorComTaxa = valor + taxaSaque;
        System.out.println("ℹ️ Taxa de saque para Conta Corrente: R$ " + String.format("%.2f", taxaSaque));
        return super.sacar(valorComTaxa);
    }
}