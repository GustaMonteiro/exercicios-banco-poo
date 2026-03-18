public class ContaBancaria {
    String titular;
    int numero;
    double saldo;

    double depositar(double valor) {
        if(valor < 0) {
            System.out.println("Não é possível depositar um valor negativo");
            return -1; // erro no deposito
        }

        saldo += valor;
        return saldo;
    }

    double sacar(double valor) {
        if(valor < 0) {
            System.out.println("Não é possível sacar um valor negativo");
            return -2; // erro no saque por valor negativo
        }

        if(valor > saldo) {
            System.out.println("Não é possível sacar um valor maior que o saldo");
            return -3; // erro no saque por valor maior que o saldo
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
