package FACTORY;

import javafx.scene.effect.Reflection;
import javafx.util.Pair;
import org.reflections.Reflections;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.lang.reflect.*;
interface HotDrink{
    void consume();
}

class Tea implements HotDrink {

    @Override
    public void consume() {
        System.out.println("this tea is delicious");
    }
}

class Coffee implements HotDrink {

    @Override
    public void consume() {
        System.out.println("this coffee is delicious");
    }
}

class PotageTomate implements HotDrink{

    @Override
    public void consume() {
        System.out.println("Dieu que c'est bon !");
    }
}

interface HotDrinkFactory {
    HotDrink prepare(int amount);
}

class TeaFactory implements HotDrinkFactory {

    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Put the tea bag, boil water .... pour " + amount + " ml, enjoy");
        return new Tea();
    }
}

class CoffeeFactory implements HotDrinkFactory {

    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Grind some beans, boil water .... pour " + amount + " ml, enjoy");
        return new Coffee();
    }
}

class PotageTomateFactory implements HotDrinkFactory {

    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Preparation du mythique Potage à la tomate pour une quantité de " + amount + " ml, enjoy ;)0");
        return new PotageTomate();
    }
}


class HotDrinkMachine {


    // List of every hot drinks we can get from the hotDinkMachine
    private List<Pair<String,HotDrinkFactory>> namedFactories
            = new ArrayList<>();

    public HotDrinkMachine() throws Exception {


        // Set<> : Collection of elements that can't be duplicate or null
        // Reflections("package_name").getSubTypesOf -> return every existing sub types in the package
        // for the given class (here it return every existing implementations of the HotDrinkFactory interface)
        Set<Class<? extends HotDrinkFactory>> types = new Reflections("FACTORY")
                .getSubTypesOf(HotDrinkFactory.class);

        // fill in the list with every existing HotDrinkFactory implementations
        for(Class<? extends HotDrinkFactory> type : types){

            // remove the word "Factore" in the names
            namedFactories.add(new Pair<>(type.getSimpleName().replace("Factory",""),
                    type.getDeclaredConstructor().newInstance()
            ));
        }
    }


    public HotDrink makeDrink() throws Exception {
        System.out.println("Available drinks:");
        for(int index = 0; index < namedFactories.size(); ++index){
            Pair<String, HotDrinkFactory> item = namedFactories.get(index);
            System.out.println("" + index + ": " + item.getKey());
        }


        // Keyboard entry input reading
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        // Choose a drink with a amount and call the prepare function
        while(true) {
            String s;
            int i, amount;
            if ((s = reader.readLine()) != null
                    && (i = Integer.parseInt(s)) >= 0
                    && i < namedFactories.size()) {
                System.out.println("Specify amount:");
                s = reader.readLine();
                if (s != null && (amount = Integer.parseInt(s)) > 0) {
                    return namedFactories.get(i).getValue().prepare(amount);
                }
            }
            System.out.println("Incorrect input, try again");
        }
    }
}


public class AbstractFactory {

    public static void main(String[] args) throws Exception {
            HotDrinkMachine machine = new HotDrinkMachine();
            HotDrink drink = machine.makeDrink();
            drink.consume();
    }

}
