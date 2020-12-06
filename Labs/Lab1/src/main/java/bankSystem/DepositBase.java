package bankSystem;

import java.util.List;

public class DepositBase {
    private List<Deposit> availableDeposits;


    public DepositBase() {
        availableDeposits = null;
    }

    public DepositBase(List<Deposit> availableDeposits) {
        this.availableDeposits = availableDeposits;
    }
}
