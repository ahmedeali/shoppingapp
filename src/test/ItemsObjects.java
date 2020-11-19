package test;

public class ItemsObjects {
	String name;
    double price;
    ItemsObjects(String name, double price){
        this.name = name;
        this.price = price;
    }
   
	
	public String toString(){
        return this.name ;
    }
    double getValue(){
        return this.price;
    }

}
