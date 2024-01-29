public class Year {

   public int amount;
   public int month;
   public static int yearOfb;
   public boolean isExpense;

   public Year(int month, int amount, Boolean isExpense, int yearOfb) {
      this.month = month;
      this.amount = amount;
      this.isExpense = isExpense;
      Year.yearOfb = yearOfb;
   }
}
