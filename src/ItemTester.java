public class ItemTester {
    public static void main(String[] args){
        // Creating some item objects
        Item item1 = new Item(1, "Item 1", 50, 10, 10.99);
        Item item2 = new Item(2, "Item 2", 20, 5, 15.49);

        // Perform various manipulations on items
        System.out.println("Item 1 Description: " + item1.getItemDescription());
        System.out.println("Item 1 Cost: " + item1.getCost());
        System.out.println("Item 1 Stock: " + item1.getStock());
        System.out.println("Item 1 Min Qty: " + item1.getMinQty());

        try {
            item1.withdrawStock(500);
            System.out.println("Item 1 Stock after withdrawal: " + item1.getStock());
        } catch (InSufficientStock e) {
            System.out.println(e);
        }

        System.out.println("Item 1 is under stock: " + item1.isUnderStock());

        item2.addStock(8);
        System.out.println("Item 2 Stock after addition: " + item2.getStock());
    }
}
