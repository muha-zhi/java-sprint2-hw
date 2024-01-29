public class Month {
    public  int quantity, sumOfOne, mon;
    public String itemName;
    public boolean isExpense;




    public Month(int quantity, int sumOfOne, String itemName, boolean isExpense, int mon){
        this.quantity = quantity;
        this.isExpense = isExpense;
        this.itemName = itemName;
        this.sumOfOne = sumOfOne;
        this.mon = mon;
    }

}
