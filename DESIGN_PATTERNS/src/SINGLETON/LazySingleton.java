package SINGLETON;

public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {

        System.out.println("init a lazy singleton");

    }


    // check null
    public static LazySingleton getInstance(){

        if(instance == null)
            instance = new LazySingleton();

        return instance;


    }

    // double-checked locking (outdated)
    public static LazySingleton getInstanceDoucleCheckLocking(){

        if(instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
