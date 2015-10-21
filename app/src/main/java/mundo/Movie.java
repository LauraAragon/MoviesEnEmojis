package mundo;

/**
 * Created by Laura Aragon on 21/09/2015.
 */
public class Movie {

    private int id;
    private String name;

    public Movie(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public boolean check(String prueba) {
        return name.equalsIgnoreCase(prueba.trim());
    }
}
