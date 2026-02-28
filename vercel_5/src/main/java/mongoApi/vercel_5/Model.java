package mongoApi.vercel_5;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Model {

    // Base URL apuntant al router /api/events
    private static final String BASE_URL = 
        "https://activitat4-apirest-ru4o-git-main-bilals-projects-6d4fff2b.vercel.app/api/events";
    private HttpClient client;

    public Model() {
        client = HttpClient.newHttpClient();
    }

    // INSERTAR 
    public void inserirEvent(Event e) {
        String json = e.toDocument().toJson();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }

    // GET TOTS
    public List<Document> getTotsEvents() {
        // Cridem la ruta GET /api/events/ que retorna tots els events
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/"))  // ruta GET general
                .GET()
                .build();

        String resposta = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();

        System.out.println(resposta);
        return new ArrayList<>();
    }

    // DELETE
    public void eliminarEvent(ObjectId id) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id.toString()))
                .DELETE()
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> System.out.println(response.body()))
                .join();
    }

    // PUT
    public void modificarEvent(ObjectId id, String nouTitol) {
        String json = "{ \"title\": \"" + nouTitol + "\" }";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id.toString()))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> System.out.println(response.body()))
                .join();
    }

    // GET PER DATA
    public List<Document> getEventsPerData(Date inici, Date fi) {
        String url = BASE_URL + "/dates?inici=" + inici.toInstant() + "&fi=" + fi.toInstant();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        String resposta = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();

        System.out.println(resposta);
        return new ArrayList<>();
    }

    // GET PER NOM
    public List<Document> getEventsPerNom(String text) {
        String url = BASE_URL + "/search/" + text;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        String resposta = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();

        System.out.println(resposta);
        return new ArrayList<>();
    }
}