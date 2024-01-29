import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class YearlyReport {
    public static ArrayList<Year> years = new ArrayList<>();

    public static void loadFileY(String yearOfb1, String path) {

        List<String> content = readFileContents(path);

        for (int i = 1; i < content.size(); i++) {

            String line = content.get(i);
            String[] parts = line.split(",");

            int month = Integer.parseInt(parts[0]);
            int amount = Integer.parseInt(parts[1]);

            boolean isExpense = Boolean.parseBoolean(parts[2]);

            int yearOfb = Integer.parseInt(yearOfb1);

            Year year = new Year(month, amount, isExpense, yearOfb);

            years.add(year);
        }


    }

    public static int profitYear(int month) {

        HashMap<Integer, Integer> expenses = new HashMap<>();
        HashMap<Integer, Integer> noExpenses = new HashMap<>();

        int exp;
        int noExp;
        int profit;

        for (Year year : years) {

            if (year.isExpense) {

                expenses.put(year.month, year.amount);

            } else {

                noExpenses.put(year.month, year.amount);

            }
        }

        exp = expenses.getOrDefault(month, 0);
        noExp = noExpenses.getOrDefault(month, 0);

        profit = noExp - exp;

        return profit;
    }

    public static void averageOfExpAndNoExp() {

        HashMap<Integer, Integer> expenses = new HashMap<>();
        HashMap<Integer, Integer> noExpenses = new HashMap<>();

        int sumOfExp = 0;
        int sumOfNoExp = 0;

        for (Year year : years) {

            if (year.isExpense) {
                expenses.put(year.month, year.amount);
            } else {
                noExpenses.put(year.month, year.amount);
            }

        }
        for (Integer val : expenses.keySet()) {

            sumOfExp += expenses.get(val);

        }
        for (Integer val : noExpenses.keySet()) {

            sumOfNoExp += noExpenses.get(val);

        }
        if (sumOfExp != 0 && sumOfNoExp != 0 && expenses.size() != 0 && noExpenses.size() != 0) {

            System.out.println("Средний расход за все месяцы в году: " + sumOfExp / expenses.size());
            System.out.println("Средний доход за все месяцы в году: " + sumOfNoExp / noExpenses.size());

        } else {

            System.out.println("Средний расход за все месяцы в году: " + 0);
            System.out.println("Средний доход за все месяцы в году: " + 0);

        }
    }

    private static List<String> readFileContents(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }
}
