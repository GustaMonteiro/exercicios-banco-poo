public class Main {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria();
        conta1.titular = "Paulo Henrique";
        conta1.numero = 40028922;
        conta1.saldo = 1_000_000.00;

        System.out.println("Paulo vai comprar uma BMW...");
        conta1.sacar(325_000);
        conta1.mostrarDados();

        System.out.println("Paulo vai comprar um terreno top...");
        conta1.sacar(280_000);
        conta1.mostrarDados();

        System.out.println("Paulo quer tirar meio milhãozinho, mas o gerente errou na hora de digitar...");
        conta1.sacar(-500_000);
        conta1.mostrarDados();

        System.out.println("Agora o gerente acertou, mas...");
        conta1.sacar(500_000);
        conta1.mostrarDados();

        ContaBancaria conta2 = new ContaBancaria();
        conta2.titular = "Gustavo Monteiro";
        conta2.numero = 1406;
        conta2.saldo = 2.75;

        System.out.println("Gustavo vai depositar o dinheiro do RU...");
        conta2.depositar(27.30);
        conta2.mostrarDados();

        System.out.println("Gustavo vai testar o sistema do RU e tentar depositar um valor negativo...");
        conta2.depositar(-1.30);
        conta2.mostrarDados();
    }
}