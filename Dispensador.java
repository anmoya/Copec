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
    private Precios precio;
    private boolean habilitado;
    private Administracion administracion;
    int carga;

    public Dispensador(){
        administracion = new Administracion();
        teclado = new Scanner(System.in);
        contenedor = new Contenedor();
        precio = new Precios();
        habilitado=true;
        carga=0;
    }

    public Dispensador(Administracion administracion, Scanner teclado, Precios precio, Contenedor contenedor, boolean habilitado){
        this.administracion=administracion;
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
        System.out.println("No tenemos suficiente bencina. Favor dirigirse a otra estación de servicio.");
    }

    public void metodoCarga(){
        do {
            try {
                System.out.println("Cuanto dinero desea cargar?");
                carga = Integer.parseInt(teclado.nextLine());
            } catch (Exception e) {
                System.out.println("Ha ingresado un valor no valido. Favor, reingrese su valor.");
                carga=-1;
            }
        } while (carga<0);
    }

    /**
     * menuCarga
     * Permite que el usuario ingrese una cantidad de dinero (carga), 
     *
     */
    public void menuCarga(){
        if (!isHabilitado()) {
            //si la maquina no está habilitada
            System.out.println("Esta maquina presenta problemas. Por favor pase a la siguiente.");
        } else {
            //si la maquina está habilitada
            int opcion=0;
            do {
                try {
                    System.out.println("___Seleccione una opcion____");
                    System.out.println("============================");
                    System.out.println("== (1) Carga 93 - $" + precio.getPrecio93() + " ==");
                    System.out.println("== (2) Carga 95 - $" + precio.getPrecio95() + " ==");
                    System.out.println("== (3) Carga 97 - $" + precio.getPrecio97() + " ==");
                    System.out.println("== (4) C Diesel - $" + precio.getPrecioDiesel() + " ==");
                    System.out.println("== (5) ACCESO ADM.       ==");
                    opcion = Integer.parseInt(teclado.nextLine());
                } catch (Exception e) {
                    System.out.println("Ha ingresado un valor no valido. Debe ingresar un numero entre 1 y 4");
                    opcion=6;
                }
            } while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4 && opcion != 5);

            //int carga; //va a tomar el valor de la carga
            switch (opcion) {
                case 1:
                metodoCarga();
                if (carga/precio.getPrecio93() > contenedor.getB93()){
                    errorCantidadBencina();
                } else {
                    float total=carga/precio.getPrecio93();
                    System.out.println("Ha cargado: "+total+" litros de combustible 93 octanos.");
                }
                break;
                case 2:
                metodoCarga();
                if (carga > contenedor.getB95()){
                    errorCantidadBencina();
                } else {
                    float total=carga/precio.getPrecio95();
                    System.out.println("Ha cargado: "+total+" litros de combustible 95 octanos.");
                }
                break;
                case 3:
                metodoCarga();
                if (carga > contenedor.getB97()){
                    errorCantidadBencina();
                } else {
                    float total=carga/precio.getPrecio97();
                    System.out.printf("Ha cargado: "+total+" litros de combustible 97 octanos.");
                }
                break;
                case 4:
                metodoCarga();
                if (carga > contenedor.getDiesel()){
                    errorCantidadBencina();
                } else {
                    float total=(carga/precio.getPrecioDiesel());
                    System.out.println("Ha cargado: "+total+" litros de combustible Diesel.");
                }
                break;
                case 5:
                System.out.println("Ingrese usuario: ");
                String user=teclado.nextLine();
                System.out.println("Ingrese contraseña");
                String pass=teclado.nextLine();
                administracion.panelAdministracion(user, pass);
                break;
                default:
                System.out.println("Revisa el codigo");
                break;
            }
        }
    }
}
