import java.util.Scanner;

public class Calcular {
    private String monedaOrigen;
    private String monedaDestino;
    private double valor;

    Scanner teclado = new Scanner(System.in);
    ConsultarConversion conversion;


    public Calcular(ConsultarConversion conversion) {
        this.conversion = conversion;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public double getValor() {
        return valor;
    }

    public void almacenarValores(String monedaOrigen, String monedaDestino){
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;

        System.out.println(" VALOR A CONVERTIR: ");

        this.valor = Double.parseDouble(teclado.nextLine());
    }



    public String obtenerMensajeRespuesta() {
        String mensaje = getMonedaOrigen().toUpperCase() + " " + getValor() + " equivalen a: " + getMonedaDestino().toUpperCase() + " " + conversion.buscaConversion(getMonedaOrigen());
        System.out.println(mensaje);
        return mensaje;
    }
}
