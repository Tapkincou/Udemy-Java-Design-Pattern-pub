package SINGLETON;

import java.io.*;

public class BasicSingleton implements Serializable {

    // Nobody can't create this class
    private BasicSingleton() {

    }


    private static final BasicSingleton INSTANCE = new BasicSingleton();

    public static BasicSingleton getInstance(){
        return INSTANCE;
    }

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    protected  Object readResolve() { return INSTANCE; }
}


class Demo{
    static void saveToFile(BasicSingleton singleton, String filename) throws Exception {

        try(FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut))
        {
            out.writeObject(singleton);
        }

    }

    static BasicSingleton readFromFile(String filename)  throws Exception{

        try(FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn)
        ) {

            return (BasicSingleton) in.readObject();

        }
    }
    public static void main(String[] args) throws Exception {

        BasicSingleton basicSingleton = BasicSingleton.getInstance();
        basicSingleton.setValue(111);



        String filename = "mySingleton.example";
        saveToFile(basicSingleton,filename);

        basicSingleton.setValue(222);

        BasicSingleton secondSingleton = readFromFile(filename);


        System.out.println(basicSingleton.getValue());
        System.out.println(secondSingleton.getValue());


        System.out.println(secondSingleton.getValue() == basicSingleton.getValue());
    }

}