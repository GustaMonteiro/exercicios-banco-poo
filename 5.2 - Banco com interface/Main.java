import java.util.Scanner;

public class Main {
    private static void cadastrarConta(Banco banco, Scanner scanner) {
        System.out.print("Digite o nome do titular: ");

        scanner.nextLine(); // limpeza de buffer
        String titular = scanner.nextLine();

        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();

        banco.cadastrarConta(titular, numeroConta);
        System.out.println("Conta cadastrada com sucesso!");
    }

    private static void procurarConta(Banco banco, Scanner scanner) {
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();

        ContaBancaria conta = banco.procurarConta(numeroConta);
        if(conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        System.out.println("");
        conta.mostrarDados();
    }

    private static void depositarEmConta(Banco banco, Scanner scanner) {
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();

        ContaBancaria conta = banco.procurarConta(numeroConta);

        if(conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        System.out.print("Digite o valor a ser depositado: R$ ");
        double valor = scanner.nextDouble();

        double novoSaldo = conta.depositar(valor);

        if(novoSaldo != -1) {
            System.out.println("Novo saldo: R$ " + novoSaldo);
        } else {
            System.out.println("Deposito inválido, pois o valor é negativo");
        }
    }

    private static void sacarDeConta(Banco banco, Scanner scanner) {
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();

        ContaBancaria conta = banco.procurarConta(numeroConta);

        if(conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        System.out.print("Digite o valor a ser sacado: R$ ");
        double valor = scanner.nextDouble();

        double novoSaldo = conta.sacar(valor);

        if(novoSaldo != -1) {
            System.out.println("Novo saldo: R$ " + novoSaldo);
        } else {
            System.out.println("Saque inválido, pois o valor é negativo");
        }
    }

    private static void transferirEntreContas(Banco banco, Scanner scanner) {
        System.out.print("Digite o número da conta de origem: ");
        int origem = scanner.nextInt();

        System.out.print("Digite o número da conta de destino: ");
        int destino = scanner.nextInt();

        System.out.print("Digite o valor a ser transferido: R$ ");
        double valor = scanner.nextDouble();

        boolean sucesso = banco.transferir(origem, destino, valor);

        if(sucesso) {
            System.out.println("Transferência concluída com sucesso!");
        } else {
            System.out.println("Transferência não concluida.");
        }
    }

    public static void main(String[] args) {
        Banco banco = new Banco("Mangoobank");

        System.out.println("====================================");
        System.out.println("Bem vindo ao " + banco.getNome());
        System.out.println("====================================\n");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n");
            System.out.println("1 - Cadastrar conta");
            System.out.println("2 - Procurar conta");
            System.out.println("3 - Depositar em conta");
            System.out.println("4 - Sacar de conta");
            System.out.println("5 - Transferir entre contas");
            System.out.println("0 - Sair");

            int op = scanner.nextInt();

            if(op == 1) {
                cadastrarConta(banco, scanner);
            } else if (op == 2) {
                procurarConta(banco, scanner);
            } else if (op == 3) {
                depositarEmConta(banco, scanner);
            } else if (op == 4) {
                sacarDeConta(banco, scanner);
            } else if (op == 5) {
                transferirEntreContas(banco, scanner);
            } else if (op == 0) {
                System.out.println("Finalizando sistema...");
                break;
            } else {
                System.out.println("Opção não existente");
            }
        }

        scanner.close();
    }
}