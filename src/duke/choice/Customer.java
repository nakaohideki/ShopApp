package duke.choice;
public class Customer
{      
    private String name;
    private String size;
    private int measurement;
    public Clothing [] items;  
    private double total = 0.0;
    private double average = 0.0;
    
    public Customer(String name, int measurement) 
    {
        this.name = name;
        setSize(measurement);
    }
        
    public void addItems (Clothing [] someItems)
    {    
        items = someItems;
/*      items[0].setDescription("Blue Jacket");
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
*/  }
    
    public String getSize() 
    {
        return size;
    }
    
    public Clothing[] getItems () 
    {
        return items;
    }   
       
    public double getTotalClothingCost ()
    {   
        for (Clothing item :  getItems())
        {   
            if(this.getSize().equals(item.getSize()))
            {
                //System.out.println("Item " + " is a " + item.getDescription() + " costing " + item.getPrice() + " with size " + item.getSize());
                total = item.getPrice() + total;
            }
        }
        return total;
    }
    
    public double getAverageClothingCost()
    {   
        double totalcost = 0.0;
        int quantity = 0;
        for (Clothing item :  getItems())
        {   
            if(this.getSize().equals(item.getSize()))
            {
                totalcost = item.getPrice() + totalcost;
                quantity++;
            }            
        }
        return totalcost / quantity;
    }      
    
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setSize (String size) 
    {   
        this.size = size;
    }
    
    public void setSize(int measurement) 
    {      
        switch (measurement) 
        {
            case 1, 2, 3 -> setSize("S");
            case 4, 5, 6 -> setSize("M");
            case 7, 8, 9 -> setSize("L");
            default ->  setSize("XL");
        }
    }

    public int getMeasurement() 
    {
        return measurement;
    }

    public void setMeasurement(int measurement) 
    {
        this.measurement = measurement;
    }
    
}