import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BancoApp {
    private static List<Conta> contas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n=================================");
            System.out.println("      SISTEMA BANCÁRIO DIGITAL   ");
            System.out.println("=================================");
            System.out.println("1. Criar Conta Corrente");
            System.out.println("2. Criar Conta Poupança");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Transferir");
            System.out.println("6. Exibir Extrato");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1 -> criarConta(true);
                case 2 -> criarConta(false);
                case 3 -> realizarDeposito();
                case 4 -> realizarSaque();
                case 5 -> realizarTransferencia();
                case 6 -> exibirExtrato();
                case 0 -> System.out.println("\nObrigado por usar nosso sistema bancário!");
                default -> System.out.println("\nOpção inválida.");
            }
        } while (opcao != 0);
    }

    private static void criarConta(boolean ehCorrente) {
        System.out.print("Digite o nome do titular: ");
        String titular = scanner.nextLine();

        Conta conta = ehCorrente ? new ContaCorrente(titular) : new ContaPoupanca(titular);
        contas.add(conta);

        System.out.println("✅ Conta criada com sucesso! Número da Conta: " + conta.getNumero());
    }

    private static Conta buscarConta(int numero) {
        for (Conta c : contas) {
            if (c.getNumero() == numero) return c;
        }
        return null;
    }

    private static void realizarDeposito() {
        System.out.print("Número da conta: ");
        int numero = scanner.nextInt();
        Conta conta = buscarConta(numero);

        if (conta != null) {
            System.out.print("Valor do depósito: R$ ");
            double valor = scanner.nextDouble();
            conta.depositar(valor);
        } else {
            System.out.println("❌ Conta não encontrada.");
        }
    }

    private static void realizarSaque() {
        System.out.print("Número da conta: ");
        int numero = scanner.nextInt();
        Conta conta = buscarConta(numero);

        if (conta != null) {
            System.out.print("Valor do saque: R$ ");
            double valor = scanner.nextDouble();
            conta.sacar(valor);
        } else {
            System.out.println("❌ Conta não encontrada.");
        }
    }

    private static void realizarTransferencia() {
        System.out.print("Número da conta de ORIGEM: ");
        int numOrigem = scanner.nextInt();
        Conta origem = buscarConta(numOrigem);

        System.out.print("Número da conta de DESTINO: ");
        int numDestino = scanner.nextInt();
        Conta destino = buscarConta(numDestino);

        if (origem != null && destino != null) {
            System.out.print("Valor da transferência: R$ ");
            double valor = scanner.nextDouble();
            origem.transferir(valor, destino);
        } else {
            System.out.println("❌ Uma ou ambas as contas não foram encontradas.");
        }
    }

    private static void exibirExtrato() {
        System.out.print("Número da conta: ");
        int numero = scanner.nextInt();
        Conta conta = buscarConta(numero);

        if (conta != null) {
            conta.exibirExtrato();
        } else {
            System.out.println("❌ Conta não encontrada.");
        }
    }
}