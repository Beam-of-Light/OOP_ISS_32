package bankSystem.deposit;

import java.util.Objects;

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

    public Deposit(Deposit deposit) {
        this.bankName = deposit.bankName;
        this.percent = deposit.percent;
        this.monthsDuration = deposit.monthsDuration;
        this.earlyWithdrawal = deposit.earlyWithdrawal;
        this.rechargeable = deposit.rechargeable;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deposit)) return false;
        Deposit deposit = (Deposit) o;
        return getPercent() == deposit.getPercent() &&
                getMonthsDuration() == deposit.getMonthsDuration() &&
                isEarlyWithdrawal() == deposit.isEarlyWithdrawal() &&
                isRechargeable() == deposit.isRechargeable() &&
                Objects.equals(getBankName(), deposit.getBankName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBankName(), getPercent(), getMonthsDuration(), isEarlyWithdrawal(), isRechargeable());
    }
}
