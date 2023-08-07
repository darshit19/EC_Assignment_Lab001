
import java.util.*;
public class Inventory {
    HashMap<Integer,Item> items;

    public Inventory() {
        items = new HashMap<>();
    }
    //Methods

    Item getItem(int itemno) throws ItemNotFound {
        if(items.containsKey(itemno)){
            return items.get(itemno);
        }else
            throw new ItemNotFound("Item Not Found");

    }
    void addItem(Item item) throws ItemAlreadyExists{
        int code=item.getItemCode();
        if(items.containsKey(code)){
            throw new ItemAlreadyExists("Item Already Exists");
        }else{
            items.put(code,item);
        }
    }
    void updateItem(Item item) throws ItemNotFound{
        int code=item.getItemCode();
        if(items.containsKey(code)){
            items.put(code,item);
        }else{
            throw new ItemNotFound("Item Not Found");
        }
    }
    void addStock(int item_code, int qty) throws ItemNotFound{
        if(!items.containsKey(item_code)){
            throw new ItemNotFound("Item Not Found");
        }else{
            Item tempItem=items.get(item_code);
            tempItem.addStock(qty);
            items.put(item_code,tempItem);
        }
    }
    void withdrawStock(int item_code, int qty)
            throws ItemNotFound, InSufficientStock{
        if(!items.containsKey(item_code)){
            throw new ItemNotFound("Item Not Found");
        }else{
            Item tempItem=items.get(item_code);
            tempItem.withdrawStock(qty);
        }
    }
    void deleteItem(int item_code) throws ItemNotFound{
        if(items.containsKey(item_code)){
            items.remove(item_code);
        }else{
            throw new ItemNotFound("Item not found");
        }
    }
    ArrayList<Item> getAllItems()
    {
        ArrayList<Item> result=new ArrayList<>();
        for (Map.Entry<Integer, Item> set :
                items.entrySet()) {
            result.add(set.getValue());
        }
        return result;
    }
    ArrayList<Item> getItemsUnderStock()
    {
        ArrayList<Item> result=new ArrayList<>();
        for (Map.Entry<Integer, Item> set :
                items.entrySet()) {
           Item temp=set.getValue();
           if(!temp.isUnderStock()){
               result.add(temp);
           }
        }
        return result;
    }
    double totalInventoryCost(){
        double totalCost=0;

        for (Map.Entry<Integer, Item> set :
                items.entrySet()) {
            Item tempItem=set.getValue();

            double tempCost=tempItem.getStock()*tempItem.getCost();
            totalCost+=tempCost;
        }
        return totalCost;
    }


}
