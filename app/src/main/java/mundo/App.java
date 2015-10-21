package mundo;

import java.util.ArrayList;

/**
 * Created by Laura Aragon on 21/09/2015.
 */
public class App {

    private ArrayList<Movie> movies;

    public App() {
        movies = new ArrayList<Movie>();
        Movie cenicienta = new Movie(1, "Cenicienta");
        movies.add(cenicienta);
        Movie bellaDurmiente = new Movie(2, "La Bella Durmiente");
        movies.add(bellaDurmiente);
        Movie pinocho = new Movie(3, "Pinocho");
        movies.add(pinocho);
        Movie libroSelva = new Movie(4, "El Libro De La Selva");
        movies.add(libroSelva);
        Movie dumbo = new Movie(5, "Dumbo");
        movies.add(dumbo);
        Movie dalmatas = new Movie(6, "101 Dalmatas");
        movies.add(dalmatas);
        Movie damaYVagabundo = new Movie(7, "La Dama y El Vagabundo");
        movies.add(damaYVagabundo);
        Movie peterPan = new Movie(8, "Peter Pan");
        movies.add(peterPan);
        Movie alicia = new Movie(9, "Alicia En El País De Las Maravillas");
        movies.add(alicia);
        Movie espadaEnLaRoca = new Movie(10, "La Espada En La Roca");
        movies.add(espadaEnLaRoca);
        Movie piratasDelCaribe = new Movie(11, "Piratas Del Caribe");
        movies.add(piratasDelCaribe);
        Movie tresCerditos = new Movie(12, "El Lobo Y Los Tres Cerditos");
        movies.add(tresCerditos);
        Movie winniePooh = new Movie(13, "Winnie Pooh");
        movies.add(winniePooh);
        Movie mickeyMouse = new Movie(14, "Mickey Mouse");
        movies.add(mickeyMouse);
        Movie bambi = new Movie(15, "Bambi");
        movies.add(bambi);
        Movie bichos = new Movie(16, "Bichos");
        movies.add(bichos);
        Movie nemo = new Movie(17, "Buscando A Nemo");
        movies.add(nemo);
        Movie cars = new Movie(18, "Cars");
        movies.add(cars);
        Movie reyLeon = new Movie(19, "El Rey Leon");
        movies.add(reyLeon);
        Movie narnia = new Movie(20, "Las Cronicas De Narnia");
        movies.add(narnia);
        Movie aristogatos = new Movie(21, "Aristogatos");
        movies.add(aristogatos);
        Movie ratatouille = new Movie(22, "Ratatouille");
        movies.add(ratatouille);
        Movie tarzan = new Movie(23, "Tarzan");
        movies.add(tarzan);
        Movie mulan = new Movie(24, "Mulan");
        movies.add(mulan);
        Movie vacasVaqueras = new Movie(25, "Vacas Vaqueras");
        movies.add(vacasVaqueras);
        Movie zorroYSabueso = new Movie(26, "El Zorro Y El Sabueso");
        movies.add(zorroYSabueso);
        Movie kungFuPanda = new Movie(27, "Kung Fu Panda");
        movies.add(kungFuPanda);
        Movie chickenLittle = new Movie(28, "Chicken Little");
        movies.add(chickenLittle);
    }

    public Movie getMovie(int i)
    {
        return movies.get(i);
    }

}
