public class Main {

    public static void main(String[] args) {
        Conta c02 = new Conta(2222, "João");
        Conta c03 = new Conta(2323, "Gabriel");
        Conta c04 = new Conta(2424, "Kaue");
        Conta c05 = new Conta(2525, "Caio");

        ControleDeBonificacoes controle = new ControleDeBonificacoes();

        Gerente gerente = new Gerente();
        gerente.setNome("Joao da silva");
        gerente.setSenha(1234);
        gerente.setSalario(5000.0);

        /*Funcionario funcionario1 = new Gerente();
        funcionario1.setSalario(5000.0);
        controle.registra(funcionario1);*/

        Funcionario funcionario2 = new Funcionario();
        funcionario2.setSalario(5000.0);
        controle.registra(funcionario2);


        c02.saldo = 1000.0;
        c03.saldo = 2000.0;
        c04.saldo = 4000.0;
        c05.saldo = 6000.0;

        System.out.println("Nome titular c02: " + c02.titular + "- Saldo: "+ c02.getSaldo() + "-Numero da conta: " + c02.numero);
        System.out.println("Nome titular c03: " + c03.titular + "- Saldo: "+ c03.getSaldo() + "-Numero da conta: " + c03.numero);
        System.out.println("Nome titular c04: " + c04.titular + "- Saldo: "+ c04.getSaldo() + "-Numero da conta: " + c04.numero);
        System.out.println("Nome titular c05: " + c05.titular + "- Saldo: "+ c05.getSaldo() + "-Numero da conta: " + c05.numero);

        System.out.println("Total de contas: " + Conta.getTotalDeContas());

        System.out.println("Novas bonificações: " + controle.getTotalDeBonificacoes());
    }
}
-------------------------------------------------------------------------------
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
        totalDeContas++;
    }

    public static int getTotalDeContas(){
        return totalDeContas;
    }

    public double getSaldo(){
        return saldo;
    }
}
----------------------------------------------------------------------------
public class Funcionario {

    private String nome;
    private String cpf;
    private double salario;

    public double getBonificacao() {
        return this.salario * 0.10;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome= nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }
}
---------------------------------------------------------------------
public class Gerente extends Funcionario {

    private int senha;
    /*private int numeroDeFuncionariosGerenciados;*/

    public boolean autentica(int senha){
        if(this.senha == senha){
            System.out.println("Acesso permitido!");
            return true;
        }
        else{
            System.out.println("Acesso negado!");
            return false;
        }
    }

    public void setSenha(int senha){
        this.senha = senha;
    }

    public int getSenha(){
        return this.senha;
    }

    @Override
    public double getBonificacao(){
        return super.getSalario() * 0.15;
    }
}
------------------------------------------------------------------------
public class ControleDeBonificacoes {
    private double totalDeBonificacoes = 0;

    public ControleDeBonificacoes() {
    }

    public void registra(Funcionario funcionario){
        this.totalDeBonificacoes += funcionario.getBonificacao();
    }

    public double getTotalDeBonificacoes(){
        return totalDeBonificacoes;
    }
}