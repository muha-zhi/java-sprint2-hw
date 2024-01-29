import java.util.ArrayList;

public class Checker {
    public YearlyReport yearlyReport;
    public MonthlyReport monthlyReport;

    public Checker(YearlyReport yearlyReport, MonthlyReport monthlyReport){

        this.monthlyReport = monthlyReport;
        this.yearlyReport = yearlyReport;

    }


    public static void checkReport() {
        ArrayList<String> monthsName = new ArrayList<>();
        monthsName.add("Январь");
        monthsName.add("Февраль");
        monthsName.add("Март");

        boolean reportTrue = true;

        for (int i = 1; i < 4; i++){
            int sumOfExpM = 0;
            int sumOfNoExpM = 0;
            int sumOfExpY = 0;
            int sumOfNoExpY = 0;

        for (Month month : MonthlyReport.months) {
            if (month.isExpense && month.mon == i) {
                sumOfExpM += month.quantity * month.sumOfOne;
            } else if (!month.isExpense && month.mon == i) {
                sumOfNoExpM += month.quantity * month.sumOfOne;
            }
        }
        for (Year year : YearlyReport.years) {

            if (year.isExpense && year.month == i) {
                sumOfExpY = year.amount;
            } else if (!year.isExpense && year.month == i) {
                sumOfNoExpY = year.amount;
            }
        }
        if (!(sumOfNoExpM == sumOfNoExpY && sumOfExpY == sumOfExpM)) {
            reportTrue = false;

            System.out.println("Обноаружено несоответсвие в отчетах за " + monthsName.get(i - 1));
            System.out.println("Доходы в месячном отчете: " + sumOfNoExpM + ". В годовом: " + sumOfNoExpY);
            System.out.println("Расходы в месячном отчете: " + sumOfExpM + ". В годовом: " + sumOfExpY);
        }
    }
        if(reportTrue){
            System.out.println("Операция прошла успешно.");
        }


    }
}
