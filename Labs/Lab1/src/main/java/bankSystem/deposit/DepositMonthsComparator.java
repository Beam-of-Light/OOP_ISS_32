package bankSystem.deposit;

import java.util.Comparator;

public class DepositMonthsComparator implements Comparator<Deposit> {
    @Override
    public int compare(Deposit o1, Deposit o2) {
        if (o1.getMonthsDuration() > o2.getMonthsDuration())
            return 1;
        else if (o1.getMonthsDuration() < o2.getMonthsDuration())
            return -1;
        return 0;
    }
}
