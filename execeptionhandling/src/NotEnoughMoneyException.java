public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException (String message){
        super(message);
    }
}
class Account{
    private String owner;
    private int balance;
    private String accountNumber;

    public Account(String owner, int balance, String accountNumber) {
        this.owner = owner;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }
    public int getBalance() {
        return balance;
    }

    public void withdrawal(int amount) throws NotEnoughMoneyException { // transfer
        if (balance >= amount) {
            balance = balance - amount;
        } else {
            System.out.println("Not enough funds in the account.");
            throw new NotEnoughMoneyException("Not enough funds in the account.");
        }
    }
}

class m{
    public static void main(String[] args) {
        Account account1 = new Account("Jan Kowalski", 100 , "12345");

        try {
            account1.withdrawal(110);
        } catch (NotEnoughMoneyException e) {
            System.out.println(e);
            e.printStackTrace();
        } catch (Exception e) {
            //this catch will catch the other exceptions

        } finally {	// this code will be executed even if there is an exception
            System.out.println(account1.getBalance());
        }
    }
}

