import java.util.ArrayList;

public class InventoryTester {
    public static void main(String[] args) {
        Item item1 = new Item(1, "Item 1", 50, 10, 10.99);
        Item item2 = new Item(2, "Item 2", 20, 5, 15.49);
        Item item3 = new Item(3, "Item 3", 17, 10, 30.45);
        Item item4 = new Item(4, "Item 4", 200, 5, 55.79);

        Inventory inventory=new Inventory();

        try {
            inventory.addItem(item1);
            inventory.addItem(item2);
            inventory.addItem(item3);
            inventory.addItem(item4);
            inventory.addItem(item1);
        } catch (ItemAlreadyExists e) {
            System.out.println(e);
        }

        System.out.println("Total cost of the items in inventory is : "+inventory.totalInventoryCost()+"Rs.");
        ArrayList<Item> items=inventory.getAllItems();
        System.out.println("Items which are available in store");
        for(int i=0;i<items.size();i++){
            Item temp=items.get(i);
            System.out.println("ID:"+temp.getItemCode());
            System.out.println("ID:"+temp.getItemDescription());
        }

        ArrayList<Item> understock=inventory.getItemsUnderStock();
        System.out.println("Items which are underStock in store");
        for(int i=0;i<items.size();i++){
            Item temp=items.get(i);
            System.out.println("ID:"+temp.getItemCode());
            System.out.println("ID:"+temp.getItemDescription());
        }

        try {
            inventory.addStock(2,32);
            inventory.deleteItem(45);
            Item item5=new Item(4, "Item 4", 30, 5, 55.79);
            inventory.updateItem(item5);
            inventory.deleteItem(5);
            inventory.withdrawStock(1,28);
        } catch (ItemNotFound e) {
            System.out.println(e);
        } catch (InSufficientStock e) {
            System.out.println(e);
        }


    }
}
