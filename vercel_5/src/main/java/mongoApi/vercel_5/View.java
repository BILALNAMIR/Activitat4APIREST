package mongoApi.vercel_5;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class View {

    private Scanner sc = new Scanner(System.in);
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public int menu() {
        System.out.println("\n--- MENU EVENTS ----");
        System.out.println("1.Afegir event");
        System.out.println("2.Eliminar event");
        System.out.println("3.Modificar event");
        System.out.println("4.Llistar tots els events");
        System.out.println("5.Llistar events entre dates");
        System.out.println("6.Cercar event per nom");
        System.out.println("0.Sortir");
        return sc.nextInt();
    }

    public Event llegirEvent() throws Exception {
        sc.nextLine();

        System.out.println("Titol:");
        String titol = sc.nextLine();

        System.out.println("Categoria:");
        String categoria = sc.nextLine();

        System.out.println("Preu:");
        int preu = sc.nextInt();
        sc.nextLine();

        System.out.println("Data (yyyy-MM-dd):");
        Date data = sdf.parse(sc.nextLine());

        System.out.println("Lloc:");
        String lloc = sc.nextLine();

        System.out.println("Disponible (true/false):");
        boolean disponible = sc.nextBoolean();

        return new Event(titol, categoria, preu, data, lloc, disponible);
    }

    public void mostrarEvents(List<Document> events) {
        for (int i = 0; i < events.size(); i++) {
            System.out.println(i + " - " + events.get(i).getString("title"));
        }
    }

    public int seleccionarEvent() {
        System.out.println("Selecciona numero:");
        return sc.nextInt();
    }

    public String nouTitol() {
        sc.nextLine();
        System.out.println("Nou titol:");
        return sc.nextLine();
    }

    public String llegirText(String missatge) {
        sc.nextLine();
        System.out.println(missatge);
        return sc.nextLine();
    }

    public Date llegirData(String missatge) throws Exception {
        sc.nextLine();
        System.out.println(missatge + " (yyyy-MM-dd):");
        return sdf.parse(sc.nextLine());
    }
}
