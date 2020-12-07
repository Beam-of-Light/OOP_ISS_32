import bankSystem.deposit.Deposit;
import bankSystem.deposit.DepositMonthsComparator;
import bankSystem.depositBase.DepositBase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DepositBaseTest {
    @Test
    void checkGetter() {
        DepositBase depositBase = new DepositBase();
        assertTrue(depositBase.getAvailableDeposits() == null);

        depositBase = new DepositBase(new LinkedList<>());
        assertEquals(depositBase.getAvailableDeposits(), new LinkedList<>());
    }

    @Test
    void checkAddRemove() {
        DepositBase depositBase = new DepositBase();
        depositBase.addDeposit(new Deposit("name", 10, 24, true, false));
        Deposit deposit = new Deposit("name", 10, 24, true, false);
        assertEquals(depositBase.getAvailableDeposits().get(0), deposit);
        assertEquals(depositBase.getAvailableDeposits().size(), 1);

        depositBase.removeDeposit(deposit);
        //assertEquals(depositBase, new DepositBase(new LinkedList<>()));
        assertEquals(depositBase.getAvailableDeposits().size(), 0);
    }

    @Test
    void checkSort() {
        DepositBase depositBase = new DepositBase();
        List<Deposit> deposits = new LinkedList<>();

        Deposit deposit1 = new Deposit("name", 10, 24, true, false);
        depositBase.addDeposit(deposit1);
        Deposit deposit2 = new Deposit("name", 5, 25, true, false);
        depositBase.addDeposit(deposit2);
        depositBase.sortByPercent();

        deposits.add(deposit2);
        deposits.add(deposit1);

        assertEquals(depositBase.getAvailableDeposits(), deposits);

        depositBase.sortByMonths();
        deposits.sort(new DepositMonthsComparator());

        assertEquals(depositBase.getAvailableDeposits(), deposits);
    }

    @Test
    void checkFind() {
        List<Deposit> deposits = new LinkedList<>();

        Deposit deposit1 = new Deposit("name", 10, 24, true, false);
        deposits.add(deposit1);
        Deposit deposit2 = new Deposit("name", 5, 25, false, true);
        deposits.add(deposit2);

        DepositBase depositBase = new DepositBase(deposits);
        assertEquals(depositBase.findByRechargeable(false).getAvailableDeposits().get(0), deposit1);
        assertEquals(depositBase.findByRechargeable(true).getAvailableDeposits().get(0), deposit2);
        assertEquals(depositBase.findByEarlyWithdrawal(true).getAvailableDeposits().get(0), deposit1);
        assertEquals(depositBase.findByEarlyWithdrawal(false).getAvailableDeposits().get(0), deposit2);
    }
}
