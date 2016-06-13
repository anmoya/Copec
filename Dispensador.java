import java.util.Scanner;
/**
 * Write a description of class Dispensador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dispensador
{
    private Scanner teclado;
    private Contenedor contenedor;
    private boolean habilitado;
    private Precios precio;

    public Dispensador(){
        teclado = new Scanner(System.in);
        contenedor = new Contenedor();
        precio = new Precios();
        habilitado=true;
    }

    public Dispensador(Scanner teclado, Precios precio, Contenedor contenedor, boolean habilitado){
        this.teclado=teclado;
        this.precio=precio;
        this.contenedor=contenedor;
        setHabilitado(habilitado);
    }

    public void setHabilitado(boolean habilitado){
        this.habilitado=habilitado;
    }

    public boolean isHabilitado(){
        return habilitado;
    }

    public void errorCantidadBencina(){
        System.out.println("No tenemos suficiente bencina. Se ha enviado una notificacion para que carguen");
    }

    /**
     * Method menuCarga
     * 
     * Genera un menu de carga que puede manipular el usuario de la maquina.
     *
     */
    public void menuCarga(){
        if (!isHabilitado()) {
            System.out.println("Esta maquina presenta problemas. Por favor pase a la siguiente.");
        } else {  
            int opcion=0;
            do {
                try {
                System.out.println("Seleccione una opcion");
                System.out.println("(1) Carga 93 - $" + precio.getPrecio93());
                System.out.println("(2) Carga 95 - $" + precio.getPrecio95());
                System.out.println("(3) Carga 97 - $" + precio.getPrecio97());
                System.out.println("(4) C Diesel - $" + precio.getPrecioDiesel());
                opcion = Integer.parseInt(teclado.nextLine());
            } catch (Exception e) {
                System.out.println("Escribió una letra, debe ingresar un numero entre 1 y 4");
                menuCarga();
            }
            } while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4);
            
            int carga; //va a tomar el valor de la carga
            switch (opcion) {
                case 1:
                System.out.println("Cuanto dinero desea cargar?");
                carga = Integer.parseInt(teclado.nextLine());
                if (carga/precio.getPrecio93() > contenedor.getB93()){
                    errorCantidadBencina();
                } else {
                    float total=carga/precio.getPrecio93();
                    System.out.println("El total de la carga de combustible es: "+total+" litros.");
                }
                break;
                case 2:
                System.out.println("Cuanto desea cargar?");
                carga = Integer.parseInt(teclado.nextLine());
                if (carga > contenedor.getB95()){
                    errorCantidadBencina();
                } else {
                    float total=carga/precio.getPrecio95();
                    System.out.println("El total de la carga de combustible es: "+total+" litros.");
                }
                break;
                case 3:
                System.out.println("Cuanto desea cargar?");
                carga = Integer.parseInt(teclado.nextLine());
                if (carga > contenedor.getB97()){
                    errorCantidadBencina();
                } else {
                    float total=carga/precio.getPrecio97();
                    System.out.println("El total de la carga de combustible es: "+total+" litros.");
                }
                break;
                case 4:
                System.out.println("Cuanto desea cargar?");
                carga = Integer.parseInt(teclado.nextLine());
                if (carga > contenedor.getDiesel()){
                    errorCantidadBencina();
                } else {
                    float total=(carga/precio.getPrecioDiesel());
                    System.out.println("El total de la carga de combustible es: "+total+" litros.");
                }
                break;
                default:
                System.out.println("Revisa el codigo");
                break;
            }
        }
    }
}
