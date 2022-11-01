import java.util.Scanner;
public class DepositCalculate {
    double calculateComplexPercent(double a, double y, int d ) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);

            return roundUp(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundUp(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundUp(double value, int places) {
        double ScaLe = Math.pow(10, places);

            return Math.round(value*ScaLe)/ScaLe;
    }

    void calculateDeposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        double amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        int period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();
        double doubleVar = 0;
        if (action == 1) {
            doubleVar = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            doubleVar = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + doubleVar);
    }

    public static void main(String[] args) {
        new DepositCalculate().calculateDeposit();
    }
}
