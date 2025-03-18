package interview.threads;

public class Customer {
    public static void main(String[] args) throws InterruptedException {

        BankAccount  bankAccount = new BankAccount(1100.23);

        Depositor deps = new Depositor(bankAccount);
        deps.setAmountToDeposit(100.0);

        Withdrawar withdr = new Withdrawar(bankAccount);
        withdr.setMoneyToWithdraw(1200);

        Thread dep = new Thread(deps);
        dep.setName("dep");
        Thread with = new Thread(withdr);
        with.setName("with");

        with.start();
        dep.start();

        dep.join();
        with.join();
    }
}
