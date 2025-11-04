
class BankAccount {
    private int balance = 1000;

    // Synchronized method to ensure safe withdrawals
    synchronized void withdraw(String threadName, int amount) {
        System.out.println(threadName + " wants to withdraw ₹" + amount);
        if (balance >= amount) {
            try {
                Thread.sleep(500); // simulate processing delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println(threadName + " completed withdrawal. Remaining balance: ₹" + balance);
        } else {
            System.out.println(threadName + " failed to withdraw ₹" + amount + " due to insufficient balance.");
        }
    }
}

class WithdrawThread extends Thread {
    BankAccount account;
    String threadName;

    WithdrawThread(BankAccount acc, String name) {
        account = acc;
        threadName = name;
    }

    public void run() {
        account.withdraw(threadName, 700);
    }
}

public class BankSync {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        WithdrawThread t1 = new WithdrawThread(account, "Person-1");
        WithdrawThread t2 = new WithdrawThread(account, "Person-2");

        t1.start();
        t2.start();
    }
}
