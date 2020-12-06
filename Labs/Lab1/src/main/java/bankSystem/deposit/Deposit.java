package bankSystem.deposit;

public class Deposit {
    private final String bankName;
    private final int percent;
    private final int monthsDuration;
    private final boolean earlyWithdrawal;
    private final boolean rechargeable;


    public Deposit(String bankName, int percent, int monthsDuration,
                   boolean earlyWithdrawal, boolean rechargeable) {
        this.bankName = bankName;
        this.earlyWithdrawal = earlyWithdrawal;
        this.rechargeable = rechargeable;

        if (percent < 0) {
            this.percent = 0;
        } else {
            this.percent = percent;
        }

        if (monthsDuration < 0) {
            this.monthsDuration = 0;
        } else {
            this.monthsDuration = monthsDuration;
        }
    }

    public String getBankName() {
        return bankName;
    }

    public int getPercent() {
        return percent;
    }

    public int getMonthsDuration() {
        return monthsDuration;
    }

    public boolean isRechargeable() {
        return rechargeable;
    }

    public boolean isEarlyWithdrawal() {
        return earlyWithdrawal;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "bankName='" + bankName + '\'' +
                ", percent=" + percent +
                ", monthsDuration=" + monthsDuration +
                ", earlyWithdrawal=" + earlyWithdrawal +
                ", rechargeable=" + rechargeable +
                '}';
    }
}
