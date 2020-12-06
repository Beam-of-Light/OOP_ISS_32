package bankSystem.deposit;

import java.util.Comparator;

public class DepositPercentComparator implements Comparator<Deposit> {
    @Override
    public int compare(Deposit o1, Deposit o2) {
        if (o1.getPercent() > o2.getPercent())
            return 1;
        else if (o1.getPercent() < o2.getPercent())
            return -1;
        return 0;
    }
}
