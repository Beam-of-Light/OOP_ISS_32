import bankSystem.depositBase.DepositBase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DepositBaseTest {
    @Test
    void checkGetter() {
        DepositBase depositBase = new DepositBase();
        assertTrue(depositBase.getAvailableDeposits() == null);

        depositBase = new DepositBase(new ArrayList<>());
        assertEquals(depositBase.getAvailableDeposits(), new ArrayList<>());
    }
}
