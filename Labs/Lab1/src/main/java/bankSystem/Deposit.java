package bankSystem;

public class Deposit {
    private String bankName;
    private long startMoney;
    private long currentMoney;
    private int percent;
    private int monthsDuration;
    private int monthsLeft;


    public Deposit(String bankName, long startMoney, int percent, int monthsDuration) {
        this.bankName = bankName;
        this.currentMoney = this.startMoney = startMoney;
        this.percent = percent;
        this.monthsLeft = this.monthsDuration = monthsDuration;
    }

    public String getBankName() {
        return bankName;
    }

    public long getStartMoney() {
        return startMoney;
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
}
