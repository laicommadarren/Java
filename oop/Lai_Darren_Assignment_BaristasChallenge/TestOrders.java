public class TestOrders {
    public static void main(String[] args) {
        
        Item item1 = new Item("drip coffee", 2.25);
        Item item2 = new Item("capuccino", 3.5);
        Item item3 = new Item("iced coffee", 2.5);
        Item item4 = new Item("mocha", 3.25);
        
        // 2 orders for unspecified guests
        Order order1 = new Order();
        Order order2 = new Order();

        // 3 orders with name specified
        Order order3 = new Order("Jason");
        Order order4 = new Order("Stacy");
        Order order5 = new Order("Kevin");

        // add 2 items to each order
        order1.addItem(item1);
        order1.addItem(item2);

        order2.addItem(item1);
        order2.addItem(item4);

        order3.addItem(item2);
        order3.addItem(item3);

        order4.addItem(item4);
        order4.addItem(item3);

        order5.addItem(item2);
        order5.addItem(item4);

        // test getStatusMessage
        order1.setReady(true);
        System.out.println(order1.getReady());

        order2.setReady(true);
        System.out.println(order2.getReady());

        // test total
        System.out.println(order1.getOrderTotal());
        System.out.println(order2.getOrderTotal());

        // test display
        order1.display();
        order2.display();
    }
}
