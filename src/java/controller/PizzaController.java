
package controller;

import dao.PizzaManager;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import model.Pizza;



@Named(value = "pizzaController")
@RequestScoped
public class PizzaController {

  
    public PizzaController() {
    }
    
    @Inject
    PizzaManager pm;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    private String name;
    private double price;
    private String description;
    private List<Pizza> allPizzas;
    @PostConstruct
    public void fillArray(){
        this.allPizzas=pm.getAllPizzas();
    }
    public void submit(){
        Pizza p=new Pizza(name,price,description);
        pm.add(p);
        allPizzas=pm.getAllPizzas();
    }

    public List<Pizza> getAllPizzas() {
        return allPizzas;
    }

    public void setAllPizzas(List<Pizza> allPizzas) {
        this.allPizzas = allPizzas;
    }
    
}
