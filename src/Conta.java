public abstract class Conta {
    private static int SEQUENCIAL = 1;

    private int numero;
    private String titular;
    protected double saldo;

    public Conta(String titular) {
        this.numero = SEQUENCIAL++;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("✅ Depósito de R$ " + String.format("%.2f", valor) + " realizado com sucesso!");
        } else {
            System.out.println("❌ Valor de depósito inválido.");
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("✅ Saque de R$ " + String.format("%.2f", valor) + " realizado com sucesso!");
            return true;
        } else {
            System.out.println("❌ Saque não realizado. Saldo insuficiente ou valor inválido.");
            return false;
        }
    }

    public void transferir(double valor, Conta contaDestino) {
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
            System.out.println("✅ Transferência para " + contaDestino.getTitular() + " concluída!");
        }
    }

    public void exibirExtrato() {
        System.out.println("\n--- Extrato da Conta ---");
        System.out.println("Número: " + this.numero);
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo Atual: R$ " + String.format("%.2f", this.saldo));
    }
}