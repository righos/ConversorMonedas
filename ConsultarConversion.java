import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultarConversion {
    public String buscaConversion(String monedaOrigen, String monedaDestino, double valor) {


        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/ace7135efb2867ac7ffa09ee/pair/" +
                    monedaOrigen + "/" + monedaDestino + "/" + valor);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(String.valueOf(direccion))).build();
            HttpResponse<String> response = null;

            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            return response.body();

        }
    }

