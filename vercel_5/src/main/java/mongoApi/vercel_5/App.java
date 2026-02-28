package mongoApi.vercel_5;

import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {

        Model model = new Model();
        View view = new View();

        int opcio;

        try {
            do {
                opcio = view.menu();

                switch (opcio) {

                    case 1:
                        Event e = view.llegirEvent();
                        model.inserirEvent(e);
                        System.out.println("Event afegit");
                        break;

                    case 2:
                        List<Document> eliminar = model.getTotsEvents();
                        view.mostrarEvents(eliminar);
                        int posE = view.seleccionarEvent();
                        ObjectId idE = eliminar.get(posE).getObjectId("_id");
                        model.eliminarEvent(idE);
                        System.out.println("Event eliminat");
                        break;
                    case 3:
                        List<Document> modificar = model.getTotsEvents();
                        view.mostrarEvents(modificar);
                        int posM = view.seleccionarEvent();
                        ObjectId idM = modificar.get(posM).getObjectId("_id");
                        String nouTitol = view.nouTitol();
                        model.modificarEvent(idM, nouTitol);
                        System.out.println("Event modificat");
                        break;

                    case 4:
                        view.mostrarEvents(model.getTotsEvents());
                        break;

                    case 5:
                        Date inici = view.llegirData("Data inici");
                        Date fi = view.llegirData("Data fi");
                        view.mostrarEvents(model.getEventsPerData(inici, fi));
                        break;

                    case 6:
                        String text = view.llegirText("Text a cercar:");
                        view.mostrarEvents(model.getEventsPerNom(text));
                        break;
                }

            } while (opcio != 0);

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
