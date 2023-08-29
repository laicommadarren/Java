import java.util.ArrayList;
import java.util.Arrays;

public class TestCafe {
    public static void main(String[] args) {

        /*
         * You will need add 1 line to this file to create an instance
         * of the CafeUtil class.
         * Hint: it will need to correspond with the variable name used below..
         */
        CafeUtil appTest = new CafeUtil();
        /* ============ App Test Cases ============= */
        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal(5));

        System.out.println("----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));

        System.out.println("----- Display Menu Test-----");

        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        appTest.displayMenu(menu);

        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
        appTest.addCustomer(customers);
        System.out.println("\n");
        }

        System.out.println("\n----- Price Chart Test-----");
        appTest.printPriceChart("Coffee", 2.25, 4);

        ArrayList<String> menuList = new ArrayList<String>();
        menuList.add("Coffee");
        menuList.add("Latte");
        menuList.add("Americano");

        ArrayList<Double> priceList = new ArrayList<Double>();
        priceList.add(2.5);
        priceList.add(4.5);
        priceList.add(3.0);

        System.out.println("\n----- Display Menu Ninja Bonus Test-----");
        appTest.displayMenu(menuList, priceList);

        // System.out.println("\n----- Add Customers (Ninja Bonus) Test-----");
        // int j = 0;
        // while (appTest.addCustomers(customers) == true) {
        //     appTest.addCustomer(customers)
        // }
    }
}
