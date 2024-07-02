
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcionElegida = 0;

        ConsultarConversion consulta = new ConsultarConversion();
        Calcular calculos = new Calcular(consulta);

        URI direccion = URI.create
                ("https://v6.exchangerate-api.com/v6/451cb3c2fae4db5568b6e985/pair/"
                        + calculos.getMonedaOrigen() + "/" + calculos.getMonedaDestino() + "/" + calculos.getValor());




        List<String> respuestas = new ArrayList<>();
        System.out.println();

        String menu = """
                \n--------------------------------------------
                             Conversor de Monedas
                
                [1] DOLAR(USD) A PESO MEXICANO (MXN)
                [2] PESO MEXICANO (MXN) A DOLAR(USD)
                [3] DOLAR (USD) A PESO ARGENTINO(ARS)
                [4] PESO ARGENTINO(ARS) A DOLAR (USD)
                [5] DOLAR (USD) A PESO COLOMBIANO(COP)
                [6] PESO COLOMBIANO (COP) A DOLAR (USD)
                
                
                [7] SALIR.
                -----------------------------------------------
                """;
        System.out.println(menu);
        System.out.println("Elija una opcion entre 1 y 7 : ");

        opcionElegida = Integer.parseInt(teclado.nextLine());

        while (opcionElegida != 7) {



                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);

                switch (opcionElegida) {
                    case 1:
                        calculos.almacenarValores("USD", "MXN");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 2:
                        calculos.almacenarValores("MXN", "USD");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 3:
                        calculos.almacenarValores("USD", "ARS");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 4:
                        calculos.almacenarValores("ARS", "USD");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 5:
                        calculos.almacenarValores("USD", "COP");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 6:
                        calculos.almacenarValores("COP", "USD");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 0:
                        System.out.println("FINALIZADO, BYE!");
                        break;
                    default:
                        System.out.println("OPCION NO VALIDA, VUELVA A INTENTARLO");
                }



        }



    }
}