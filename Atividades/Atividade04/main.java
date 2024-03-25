public class Main {
    public static void main(String[]args){
        Conta c02 = new Conta(2323, "João");
        Conta c03 = new Conta(2424, "Kaue");
        Conta c04 = new Conta(2525, "Caio");
        Conta c05 = new Conta(2626, "Bernardo");
        

        c02.saldo = 1000.0;
        c03.saldo = 2000.0;
        c04.saldo = 3000.0;
        c05.saldo = 4000.0;

        System.out.println("Nome titular c02: " + c02.titular + " - Saldo: "+ c02.getSaldo() + " -Numero da conta: " +  c02.numero);
        System.out.println("Nome titular c02: " + c03.titular + " - Saldo: "+ c03.getSaldo() + " -Numero da conta: " + c03.numero);
        System.out.println("Nome titular c02: " + c04.titular + " - Saldo: "+ c04.getSaldo() + " -Numero da conta: " + c04.numero);
        System.out.println("Nome titular c02: " + c04.titular + " - Saldo: "+ c04.getSaldo() + " -Numero da conta: " + c04.numero);
        System.out.println("Nome titular c02: " + c05.titular + " - Saldo: "+ c05.getSaldo() + " -Numero da conta: " + c05.numero);

        System.out.println("Total de contas: " + Conta.getTotalDeContas());
    }