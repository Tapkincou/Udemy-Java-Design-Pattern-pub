package PROTOTYPE;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

public class UsingSerialization implements Serializable {

    public int stuff;
    public String whatever;

    public UsingSerialization(int stuff, String whatever) {
        this.stuff = stuff;
        this.whatever = whatever;
    }

    @Override
    public String toString() {
        return "UsingSerialization{" +
                "stuff=" + stuff +
                ", whatever='" + whatever + '\'' +
                '}';
    }
}


class DemoUsingSerialize {

    public static void main(String [] args) {

/**
 * Dans le jargon des développeurs Java,
 * sérializer un objet consiste à le convertir en un tableau d'octets,
 * que l'on peut ensuite écrire dans un fichier,
 * envoyer sur un réseau au travers d'une socket etc...
 * **/


        UsingSerialization foo = new UsingSerialization(42, "life");
        // (Apache) Method which serialize and deserialize an object (which make a copy by the end)
        UsingSerialization foo2 = SerializationUtils.roundtrip(foo);

        foo2.whatever = "xyz";

        System.out.println(foo);
        System.out.println(foo2);

    }

}