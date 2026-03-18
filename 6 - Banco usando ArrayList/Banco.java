import java.util.ArrayList;

public class Banco {
    private String nome;
    private ArrayList<ContaBancaria> contas;

    Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<ContaBancaria>();
    }

    public String getNome() {
        return nome;
    }

    void cadastrarConta(String titular, int numero) {
        this.contas.add(new ContaBancaria(titular, numero));
    }

    ContaBancaria procurarConta(int numero) {
        for(ContaBancaria conta : this.contas) {
            if(conta.getNumero() == numero) {
                return conta;
            }
        }

        return null;
    }

    double depositar(int numero, double valor) {
        ContaBancaria conta = this.procurarConta(numero);

        if(conta == null) {
            System.out.println("Não foi possível encontrar a conta informada");
            return -1;
        }

        return conta.depositar(valor);
    }

    double sacar(int numero, double valor) {
        ContaBancaria conta = this.procurarConta(numero);

        if(conta == null) {
            System.out.println("Não foi possível encontrar a conta informada");
            return -1;
        }

        return conta.sacar(valor);
    }

    boolean transferir(int origem, int destino, double valor) {
        if(valor <= 0) {
            System.out.println("Não tem como transferir um valor negativo ou nulo");
            return false;
        }

        ContaBancaria contaOrigem = this.procurarConta(origem);
        if (contaOrigem == null) {
            System.out.println("Não foi possível encontrar a conta de origem");
            return false;
        }

        ContaBancaria contaDestino = this.procurarConta(destino);
        if (contaDestino == null) {
            System.out.println("Não foi possível encontrar a conta de destino");
            return false;
        }

        if(contaOrigem.getSaldo() < valor) {
            System.out.println("Não foi possível finalizar a transferência: conta de origem não tem saldo");
            return false;
        }

        contaOrigem.sacar(valor);
        contaDestino.depositar(valor);

        return true;
    }
}
