package myapps.Util;

import com.github.javafaker.Faker;
import myapps.pojos.OrderPOJO;
import myapps.pojos.PizzaPOJO;

import java.util.Arrays;

public class Producer {

    public OrderPOJO generateOrder(){
        Faker faker = new Faker();

        String name = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        PizzaPOJO[] pizzas = {generatePizza(), generatePizza(), generatePizza()};

        return new OrderPOJO(name, Arrays.asList(pizzas));
    }

    public PizzaPOJO generatePizza(){
        return new PizzaPOJO("Hawaii", "L", 12.5F);
    }

    public static void main(String[] args){



    }
}
