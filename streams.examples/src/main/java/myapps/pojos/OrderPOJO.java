package myapps.pojos;

import myapps.Util.JSONSerdeCompatible;

import java.util.List;

public class OrderPOJO implements JSONSerdeCompatible {
    private String customer;
    private List<PizzaPOJO> pizzas;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<PizzaPOJO> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<PizzaPOJO> pizzas) {
        this.pizzas = pizzas;
    }


}
