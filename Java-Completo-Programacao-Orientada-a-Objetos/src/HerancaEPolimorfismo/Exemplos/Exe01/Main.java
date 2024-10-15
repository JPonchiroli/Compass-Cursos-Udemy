package HerancaEPolimorfismo.Exemplos.Exe01;

public class Main {
    public static void main(String[] args) {
        Conta cnt = new Conta(1001, "Joao", 1500.0);
        ContaComercial cntCom1 = new ContaComercial(1002, "Pedro", 0.0, 500.0);

        // Upcasting

        Conta cnt1 = cntCom1;
        Conta cnt2 = new ContaComercial(1003, "Jorge", 0.0, 200.0);
        Conta cnt3 = new ContaPoupanca(1003, "Maria", 0.0, 0.01);

        // Downcasting

        ContaComercial cnt4 = (ContaComercial) cnt2;

        if (cnt3 instanceof ContaComercial){
            ContaComercial cnt5 = (ContaComercial) cnt3;
            cnt5.emprestimo(200);
            System.out.println("Emprestimo!");
        }

        if (cnt3 instanceof ContaPoupanca){
            ContaPoupanca cnt5 = (ContaPoupanca) cnt3;
            cnt5.atualizarSaldo();
            System.out.println("Atualizar!");
        }
    }
}
