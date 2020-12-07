package bankSystem.depositBase;

import bankSystem.deposit.Deposit;

import java.util.Scanner;

public class DemoDepositBase {
    private static DepositBase depositBase;
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        depositBase = new DepositBase();
        depositBase.addDeposit(new Deposit("name1", 10, 24, false, false));
        depositBase.addDeposit(new Deposit("name2", 7, 12, false, true));
        depositBase.addDeposit(new Deposit("name3", 4, 30, true, true));
        depositBase.addDeposit(new Deposit("name4", 12, 20, true, false));
        depositBase.addDeposit(new Deposit("name5", 14, 18, true, true));
        depositBase.addDeposit(new Deposit("name6", 9, 36, false, false));
        run();
    }

    public static void run() {
        int command;
        while (true) {
            printAllCommands();
            command = input.nextInt();
            doCommand(command);
            if (command == 8) {
                return;
            }
        }
    }

    private static void doCommand(int command) {
        DepositBase tempBase;
        switch (command) {
            case 1:
                System.out.println(depositBase.toString() + '\n');
                break;
            case 2:
                depositBase.addDeposit(handleCreateDeposit());
                break;
            case 3:
                depositBase.removeDeposit(handleCreateDeposit());
                break;
            case 4:
                depositBase.sortByPercent();
                break;
            case 5:
                depositBase.sortByMonths();
                break;
            case 6:
                System.out.println("\nEnter rechargeable: ");
                tempBase = depositBase.findByRechargeable(input.nextBoolean());
                System.out.println(tempBase.toString() + '\n');
                break;
            case 7:
                System.out.println("\nEnter early withdrawal: ");
                tempBase = depositBase.findByEarlyWithdrawal(input.nextBoolean());
                System.out.println(tempBase.toString() + '\n');
                break;
            default:
        }
    }

    private static Deposit handleCreateDeposit() {
        input.nextLine();
        System.out.print("\nEnter bank name: ");
        String name = input.nextLine();
        System.out.print("\nEnter percent: ");
        int percent = input.nextInt();
        System.out.print("\nEnter months duration: ");
        int monthsDuration = input.nextInt();
        System.out.print("\nEnter early withdrawal: ");
        boolean earlyWithdrawal = input.nextBoolean();
        System.out.print("\nEnter rechargeable: ");
        boolean rechargeable = input.nextBoolean();

        return new Deposit(name, percent, monthsDuration, earlyWithdrawal, rechargeable);
    }

    public static void printAllCommands(){
        System.out.println("""
                What would you like me to do?:
                1. Show current DepositBase
                2. Add Deposit
                3. Remove Deposit
                4. Sort by percent
                5. Sort by months duration
                6. Find by rechargeable
                7. Find by early withdrawal
                8. Exit""");
    }
}
