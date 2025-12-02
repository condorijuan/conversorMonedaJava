import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Principal {
    //conversor
    //Dolar --> pesos argentinos, Real brasileño, Peso colombiano
    //pesos argentinos --> Dolar
    //Real brasileño --> Dolar
    //Peso colombiano --> Dolar


    public static void main(String[] args) {
        System.out.println("Hola, bienvenido al conversor de monedas");
        Scanner opcion = new Scanner(System.in);
        while(true){
            System.out.println("""
                Seleccione una de las opciones:
                1. Dolar a Pesos Argentinos
                2. Dolar a Real Brasileño
                3. Dolar a Peso Colombiano
                4. Pesos Argentinos a Dolar
                5. Real Brasileño a Dolar
                6. Peso Colombiano a Dolar
                7. Salir
                """);

            try {
                int seleccion = opcion.nextInt();
                if(seleccion == 7){
                    System.out.println("Saliendo del programa...");
                    opcion.close();
                    break;
                } if(seleccion < 1 || seleccion > 7){
                    System.out.println("Opción no válida, por favor intente de nuevo.");

                } else {
                    System.out.println("Ingrese la cantidad a convertir: ");
                    double cantidad = opcion.nextDouble();
                    double resultado = realizarConversion(seleccion, cantidad);
                    System.out.printf("El resultado de la conversión es: %.2f%n", resultado);
                }
            } catch (InputMismatchException e){
                System.out.println("Opción no válida, por favor intente de nuevo.");
                opcion.next(); // Limpiar el buffer del scanner;
            } catch (InterruptedException | IOException e) {
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("Cantidad no válida, por favor intente de nuevo.");
                System.out.println(e.getCause());
                opcion.next(); // Limpiar el buffer del scanner;
            }
        }
    }

    private static double realizarConversion(int seleccion, double cantidad) throws IOException, InterruptedException {
        String monedaBase;
        String monedaObjetivo;
        switch (seleccion) {
            case 1 -> {
                monedaBase = "USD";
                monedaObjetivo = "ARS";
            }
            case 2 -> {
                monedaBase ="USD";
                monedaObjetivo= "BRL";
            }
            case 3 -> {
                monedaBase ="USD";
                monedaObjetivo= "COP";
            }
            case 4 -> {
                monedaBase ="ARS";
                monedaObjetivo= "USD";
            }
            case 5 -> {
                monedaBase ="BRL";
                monedaObjetivo= "USD";
            }
            case 6 -> {
                monedaBase ="COP";
                monedaObjetivo= "USD";
            }
            default -> throw new IllegalArgumentException("Selección no válida.");
        };
        return Double.parseDouble(Conversor.convertir(monedaBase, monedaObjetivo, cantidad).getResultado_conversion());
    }
}
