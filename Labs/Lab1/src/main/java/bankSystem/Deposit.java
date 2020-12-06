package bankSystem;

public class Deposit {
    private final String bankName;
    private long currentMoney;
    private final int percent;
    private final int monthsDuration;
    private int monthsLeft;
    private final boolean earlyWithdrawal;
    private final boolean rechargeable;


    public Deposit(String bankName, long startMoney, int percent, int monthsDuration,
                   boolean earlyWithdrawal, boolean rechargeable) {
        this.bankName = bankName;
        this.earlyWithdrawal = earlyWithdrawal;
        this.rechargeable = rechargeable;

        if (startMoney < 0) {
            this.currentMoney = 0L;
        } else {
            this.currentMoney = startMoney;
        }

        if (percent < 0) {
            this.percent = 0;
        } else {
            this.percent = percent;
        }

        if (monthsDuration < 0) {
            this.monthsLeft = this.monthsDuration = 0;
        } else {
            this.monthsLeft = this.monthsDuration = monthsDuration;
        }
    }

    public boolean putMoney(long money) {
        if (rechargeable) {
            currentMoney += money;
        }
        return rechargeable;
    }

    public long getMoney() {
        if (monthsLeft == 0 || earlyWithdrawal) {
            long money = currentMoney;
            currentMoney = 0;
            monthsLeft = 0;
            return money;
        } else {
            return 0;
        }
    }

    public void nextMonth() {
        if (monthsLeft > 0) {
            currentMoney += (currentMoney * percent) / 100;
            --monthsLeft;
        }
    }

    public String getBankName() {
        return bankName;
    }

    public long getCurrentMoney() {
        return currentMoney;
    }

    public int getPercent() {
        return percent;
    }

    public int getMonthsDuration() {
        return monthsDuration;
    }

    public int getMonthsLeft() {
        return monthsLeft;
    }

    public boolean isRechargeable() {
        return rechargeable;
    }

    public boolean isEarlyWithdrawal() {
        return earlyWithdrawal;
    }
}
