import bankSystem.deposit.Deposit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DepositTest {
    @Test
    void checkConstructor() {
        Deposit deposit = new Deposit("name", 10, 24, true, false);

        assertEquals(deposit.getBankName(), "name");
        assertEquals(deposit.getPercent(), 10);
        assertEquals(deposit.getMonthsDuration(), 24);
        assertTrue(deposit.isEarlyWithdrawal());
        assertFalse(deposit.isRechargeable());

        deposit = new Deposit("name", -10, -24, true, false);

        assertEquals(deposit.getBankName(), "name");
        assertEquals(deposit.getPercent(), 0);
        assertEquals(deposit.getMonthsDuration(), 0);
        assertTrue(deposit.isEarlyWithdrawal());
        assertFalse(deposit.isRechargeable());
    }

    @Test
    void checkCopyConstructor() {
        Deposit deposit1 = new Deposit("name", 10, 24, true, false);
        Deposit deposit2 = new Deposit(deposit1);

        assertEquals(deposit1, deposit2);
        assertFalse(deposit1 == deposit2);
    }
}
