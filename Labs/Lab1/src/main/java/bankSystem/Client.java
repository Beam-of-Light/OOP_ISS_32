package bankSystem;

import bankSystem.deposit.Deposit;

import java.util.List;

public class Client {
    private String name;
    private List<Deposit> deposits;


    public Client(String name) {
        this(name, null);
    }

    public Client(String name, List<Deposit> deposits) {
        this.name = name;
        this.deposits = deposits;
    }

    public String getName() {
        return name;
    }

    public List<Deposit> getDeposits() {
        return deposits;
    }
}
