package duke.choice;

import java.util.Arrays;
import java.util.Collections;

public class Clothing implements Comparable <Clothing>         
{    
    public String description;
    private String size = "M";
    private double price;
    public static final double min_price = 10.0;
    public static final double tax_rate = 0.2;
    public Clothing(String description, double price, String size)         
    {
        this.setDescription(description);
        this.price = price;
        this.size = size;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getSize() 
    {
        return size;
    }

    public void setSize(String size) 
    {
        this.size = size;
    }

    public double getPrice() 
    {
        setPrice(this.price);
        return price + price * tax_rate;
    }

    public void setPrice(double price) 
    {
        this.price = (price > min_price) ? price : min_price;
    }
    
    public static void sortItems (Clothing[] items)
    { 
        Collections.sort(Arrays.asList(items));
        for (Clothing item : items) 
        {
            System.out.println(item);
        }
    }
        
    @Override    
    public String toString()
    {  
        return getDescription() + " costing " + getPrice() + " with size " + getSize();
    }
    
    @Override     
    public int compareTo(Clothing o) 
    {
        return getDescription().compareTo(o.getDescription());
    }   
}
    
