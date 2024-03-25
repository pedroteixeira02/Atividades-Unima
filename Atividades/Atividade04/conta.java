public class Conta {
    
    int numero;
    
    String titular;

    private static int totalDeContas;

    double saldo;

    Conta(String titular){
        this.titular = titular;
        adicionarConta();
    }

    Conta(int numero, String titular){
        this(titular);
        this.numero = numero;
    }

    private void adicionarConta(){
        totalDeContas ++;
    }

    public static int getTotalDeContas(){
        return totalDeContas;
    }

    public double getSaldo(){
        return saldo;
    }
}