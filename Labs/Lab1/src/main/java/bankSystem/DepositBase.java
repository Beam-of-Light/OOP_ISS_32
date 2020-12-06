package bankSystem;

import bankSystem.deposit.Deposit;

import java.util.LinkedList;
import java.util.List;

public class DepositBase {
    private List<Deposit> availableDeposits;


    public DepositBase() {
        availableDeposits = null;
    }

    public DepositBase(List<Deposit> availableDeposits) {
        this.availableDeposits = availableDeposits;
    }

    public void addDeposit(Deposit deposit) {
        if (availableDeposits == null) {
            availableDeposits = new LinkedList<Deposit>();
        }
        availableDeposits.add(deposit);
    }

    public boolean removeDeposit(Deposit deposit) {
        return availableDeposits.remove(deposit);
    }
}
