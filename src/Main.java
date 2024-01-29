import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> months = new ArrayList<>();

        months.add("Январь");
        months.add("Февраль");
        months.add("Март");

        boolean reportMonthTrue = false;
        boolean reportYearTrue = false;

        Scanner scanner = new Scanner(System.in);

        while (true) {

            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {

                MonthlyReport.loadFile(1, "resources/m.202101.csv");
                MonthlyReport.loadFile(2, "resources/m.202102.csv");
                MonthlyReport.loadFile(3, "resources/m.202103.csv");

                System.out.println("Месячные отчеты считаны");

                reportMonthTrue = true;

            } else if (command == 2) {

                YearlyReport.loadFileY("2021", "resources/y.2021.csv");

                System.out.println("Годовой отчет считан");

                reportYearTrue = true;

            } else if (command == 3) {

                if (reportMonthTrue && reportYearTrue) {

                    Checker.checkReport();

                } else {

                    System.out.println("Нужно сначала считать оба отчета, прежде чем их сверить");

                }

            } else if (command == 4) {

                if (reportMonthTrue) {

                    for (int i = 0; i < 3; i++) {

                        System.out.println("Отчет за " + months.get(i));
                        MonthlyReport.topProduct(i + 1);
                        MonthlyReport.maxExpense(i + 1);
                    }

                } else {

                    System.out.println("Вы не считали месячные отчеты");

                }


            } else if (command == 5) {

                if (reportYearTrue) {

                    System.out.println("Отчет за " + Year.yearOfb + "год:");

                    for (int i = 0; i < months.size(); i++) {

                        System.out.println("Приыбль за " + months.get(i) + " составила: " + YearlyReport.profitYear(i + 1));

                    }

                    YearlyReport.averageOfExpAndNoExp();

                } else {

                    System.out.println("Вы не считали годовой отчет");

                }


            } else if (command == 0) {

                System.out.println("Програма завершена");

                return;

            }

        }
    }

    private static void printMenu() {
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");

    }
}


