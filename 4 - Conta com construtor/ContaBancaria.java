public class ContaBancaria {
    String titular;
    int numero;
    double saldo;

    ContaBancaria(String titular, int numero, double saldo) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldo;
    }

    ContaBancaria(String titular, int numero) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = 0.0;
    }

    double depositar(double valor) {
        if(valor < 0) {
            System.out.println("Não é possível depositar um valor negativo");
            return -1;
        }

        saldo += valor;
        return saldo;
    }

    double sacar(double valor) {
        if(valor < 0) {
            System.out.println("Não é possível sacar um valor negativo");
            return -1;
        }

        if(valor > saldo) {
            System.out.println("Não é possível sacar um valor maior que o saldo");
            return -1;
        }

        saldo -= valor;
        return saldo;
    }

    void mostrarDados() {
        System.out.println("Titular: " + titular);
        System.out.println("Numero: " + numero);
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("");
    }
}
