import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    public static EntidadConversor convertir(String CodigoMonedaBasem, String CodigoMonedaObjetivo, double cantidadEnDolares) throws IOException, InterruptedException {

        String apiURL = "https://v6.exchangerate-api.com/v6/c29f1444f1e8d85f597e0933/pair/";
        String direccionCompleta = apiURL + CodigoMonedaBasem + "/" + CodigoMonedaObjetivo + "/" + cantidadEnDolares;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        HttpClient client =HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccionCompleta)).build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        ConversorExchager conversorExchager = gson.fromJson(response.body(), ConversorExchager.class);
        EntidadConversor entidadConversor = new EntidadConversor(conversorExchager);
        return entidadConversor;
    }
}
