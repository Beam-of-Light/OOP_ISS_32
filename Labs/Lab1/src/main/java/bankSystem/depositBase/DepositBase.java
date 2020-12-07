package bankSystem.depositBase;

import bankSystem.deposit.Deposit;
import bankSystem.deposit.DepositMonthsComparator;
import bankSystem.deposit.DepositPercentComparator;

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

    public List<Deposit> getAvailableDeposits() {
        return availableDeposits;
    }

    public boolean addDeposit(Deposit deposit) {
        if (availableDeposits == null) {
            availableDeposits = new LinkedList<Deposit>();
        }
        return availableDeposits.add(deposit);
    }

    public boolean removeDeposit(Deposit deposit) {
        return availableDeposits.remove(deposit);
    }

    public void sortByPercent() {
        availableDeposits.sort(new DepositPercentComparator());
    }

    public void sortByMonths() {
        availableDeposits.sort(new DepositMonthsComparator());
    }

    public DepositBase findByRechargeable(boolean shouldBeRechargeable) {
        List<Deposit> result = new LinkedList<>();
        for (Deposit item : availableDeposits) {
            if (item.isRechargeable() == shouldBeRechargeable) {
                result.add(new Deposit(item));
            }
        }
        return new DepositBase(result);
    }

    public DepositBase findByEarlyWithdrawal(boolean shouldBeEarlyWithdrawal) {
        List<Deposit> result = new LinkedList<>();
        for (Deposit item : availableDeposits) {
            if (item.isEarlyWithdrawal() == shouldBeEarlyWithdrawal) {
                result.add(new Deposit(item));
            }
        }
        return new DepositBase(result);
    }

    @Override
    public String toString() {
        String result = "";
        for (Deposit item : availableDeposits) {
            result = result + item + '\n';
        }
        return result;
    }
}
