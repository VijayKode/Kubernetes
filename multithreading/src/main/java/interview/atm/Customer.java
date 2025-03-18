package interview.atm;


public class Customer {
    public static void main(String[] args) throws InterruptedException {

        Atm atm = new Atm();

        Depositor deps = new Depositor(atm);
        deps.setAmountToDeposit(200.0);

        Withdrawar withdr = new Withdrawar(atm);
        withdr.setMoneyToWithdraw(200);

        Thread dep = new Thread(deps);
        dep.setName("dep");
        Thread with = new Thread(withdr);
        with.setName("with");

        with.start();
        Thread.sleep(100);
        dep.start();

        dep.join();
        with.join();
    }
}
