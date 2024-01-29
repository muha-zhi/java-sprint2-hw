import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MonthlyReport {
    static ArrayList<Month> months = new ArrayList<>();

    public static void loadFile(Integer mon1, String path) {

        List<String> content = readFileContents(path);

        for (int i = 1; i < content.size(); i++) {

            String line = content.get(i);

            String[] parts = line.split(",");

            String itemName = parts[0];

            boolean isExpense = Boolean.parseBoolean(parts[1]);

            int quantity = Integer.parseInt(parts[2]);
            int sumOfOne = Integer.parseInt(parts[3]);

            int mon = mon1;

            Month month = new Month(quantity, sumOfOne, itemName, isExpense, mon);

            months.add(month);
        }

    }

    public static void topProduct(int month1) {

        HashMap<String, Integer> topProducts = new HashMap<>();
        String topProductName = "";

        int topProduct = 0;

        for (Month month : months) {
            if (!month.isExpense && month.mon == month1) {
                topProducts.put(month.itemName, month.quantity * month.sumOfOne);
            }
        }

        for (String val : topProducts.keySet()) {
            if (topProduct < topProducts.get(val)) {

                topProduct = topProducts.get(val);
                topProductName = val;

            }
        }

        System.out.println("Самый прибыльный товар: " + topProductName + ". На сумму " + topProduct);


    }

    public static void maxExpense(int month1) {

        int maxVal = 0;
        String maxValName = "";

        for (Month month : months) {
            if (month.isExpense && month.mon == month1 && month.quantity * month.sumOfOne > maxVal) {
                maxVal = month.quantity * month.sumOfOne;
                maxValName = month.itemName;
            }
        }
        System.out.println("Смамя большая трата : " + maxValName + ". На сумму: " + maxVal);
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
