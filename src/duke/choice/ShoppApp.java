package duke.choice;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class ShoppApp
{ 
    public static void main(String[] args) 
    {   
        System.out.println("Welcome to Duke Choice Shop!");
               
/*      c1.setName("Pinky");
        c1.setMeasurent(3);
        c1.setSize(c1.getMeasurement());       
*/      
        Customer c1 = new Customer("Pinky", 3);   
        System.out.println("This customer name is " + c1.getName() + "\n" + "The " + c1.getName() + "'s suitable size is " + c1.getSize() + ".");      
/*               
        Clothing item1 = new Clothing("Blue Jacket", 20.9, "M");
        Clothing item2 = new Clothing("Orange T-Shirt", 10.5, "S");
        Clothing item3 = new Clothing("Green Scarf", 5, "S");
        Clothing item4 = new Clothing("Blue T-Shirt", 10.5, "S");
        Clothing [] items = {item1, item2, item3, item4}; 
*/        
        System.out.println("The ShoppApp minimum price including taxes is " + (Clothing.min_price * (1+Clothing.tax_rate)));   
        Clothing [] items = {new Clothing("Blue Jacket", 20.9,"M"), new Clothing("Orange T-shirt", 10.5, "S"), new Clothing("Green Scarff", 5.0, "S"), new Clothing("Blue T-shirt", 10.5,"S")};       
/*        
        items[0].setDescription("Blue Jacket");
        items[0].setPrice(20.9);
        items[0].setSize("M");
        
        items[1].setDescription("Orange T-shirt");
        items[1].setPrice(10.5);
        items[1].setSize("S");  

        items[2].setDescription("Green Scarf");
        items[2].setPrice(5.0);
        items[2].setSize("S"); 

        items[3].setDescription("Blue T-shirt");
        items[3].setPrice(10.5);
        items[3].setSize("S"); 
*/               
        try
        {  
            ItemList list = new ItemList(items);
            Routing routing = Routing.builder().get("/items", list).build();
            ServerConfiguration config = ServerConfiguration.builder().bindAddress(InetAddress.getLocalHost()).port(8888).build();
            WebServer ws = WebServer.create(config, routing);
            ws.start();
        }
        catch (UnknownHostException ex)
        {
            ex.printStackTrace();
        }

        c1.addItems(items);
        Arrays.sort(c1.getItems());
/*    
        System.out.println("Item 1: " + item1.description + ", " + item1.price + " and " + item1.size + "\nItem 2: " + item2.description + ", " + item2.price + " and " + item2.size);      
    
        int item1Quantity = 1;
        int item2Quantity = 2;     
*/   

        
        System.out.println("\nThe items corresponding with the Customer Size (" + c1.getSize() + ") are listed bellow:\n");
     
        for (Clothing item : c1.getItems())
        {
            if(c1.getSize().equals(item.getSize()))
            {          
                //System.out.println(item.getDescription() + " costing " + item.getPrice() + " with size " + item.getSize());
                System.out.println(item);
/*              total = item.getPrice() + total;             
            }
            if(total>15)
            {
                break;
            }
*/          }
        }           
        
        System.out.println("\nTotal of items matching with the customer size with taxes included is " + c1.getTotalClothingCost()/* total*/);
        System.out.println("The average of items matching with the customer size with taxes included is " + c1.getAverageClothingCost()); 

/*      total = ((item1Quantity * item1.price) + (item2Quantity * item2.price)) * (tax+=1); 
        total = Math.round(total*100.0)/100.0;
        System.out.println("\nThe total is: " + total);
              
        switch (c1.measurement)
        {
            case 1, 2, 3:
                c1.size = "S";
                break;
            case 4, 5, 6:
                c1.size = "M";
                break;
            case 7, 8, 9:
                c1.size = "L";
                break;
            default:
                c1.size = "X";
                break;
        }
*/  }   
}