package br.com.piback.ecommerce.Domain;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */
public class ShoppingCart {
    public Long productId;
    public String listId;
    public String name;
    public double price;
    public int quantity;
    public String size;
    public String url;
}
