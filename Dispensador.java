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
    private int carga;

    public Dispensador(){
        teclado = new Scanner(System.in);
        contenedor = new Contenedor();
        precio = new Precios();
        habilitado=true;
        carga=0;
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

    //**************************
    //    METODO ERROR
    //**************************

    public void errorCantidadBencina(){
        System.out.println("Hemos detectado que no hay bencina suficiente.");
        System.out.println("Favor dirijase a otra estacion de servicio o cargue otro tipo de bencina");
        menuCarga();
    }

    //**************************
    //    METODO CARGA
    //**************************

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

    //*****************************
    //    METODO MENU DE CARGA
    //*****************************

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
                    System.out.println("== (6) APAGAR MAQUINA    ==");
                    opcion = Integer.parseInt(teclado.nextLine());
                } catch (Exception e) {
                    System.out.println("Ha ingresado un valor no valido. Debe ingresar un numero entre 1 y 6");
                    opcion=7;
                }
            } while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4 && opcion != 5 && opcion != 6);

            //int carga; //va a tomar el valor de la carga
            switch (opcion) {
                case 1:
                do {
                    try {
                        System.out.println("Cuanto dinero desea cargar?");
                        carga = Integer.parseInt(teclado.nextLine());
                    } catch (Exception e) {
                        System.out.println("Ha ingresado un valor no valido. Favor, reingrese su valor.");
                        carga=-1;
                    }
                } while (carga<0);
                if (carga/precio.getPrecio93() > contenedor.getB93()){
                    System.out.println("Hemos detectado que no hay bencina suficiente.");
                    System.out.println("Favor dirijase a otra estacion de servicio o cargue otro tipo de bencina");
                    menuCarga();
                } else {
                    float total=carga/precio.getPrecio93();
                    contenedor.setB93(contenedor.getB93()-total);
                    System.out.println("===================================================");
                    System.out.println("Ha cargado: "+total+" litros de combustible 93 octanos.");
                    System.out.println("Gracias por venir a Copecc");
                    System.out.println("===================================================");
                    System.out.println("");
                    menuCarga();
                }
                break;
                case 2:
                metodoCarga();
                if (carga/precio.getPrecio95() > contenedor.getB95()){
                    errorCantidadBencina();
                } else {
                    float total=carga/precio.getPrecio95();
                    contenedor.setB95(contenedor.getB95()-total);
                    System.out.println("===================================================");
                    System.out.println("Ha cargado: "+total+" litros de combustible 95 octanos.");
                    System.out.println("Gracias por venir a Copecc");
                    System.out.println("===================================================");
                    System.out.println("");
                    menuCarga();
                }
                break;
                case 3:
                metodoCarga();
                if (carga/precio.getPrecio97() > contenedor.getB97()){
                    errorCantidadBencina();
                } else {
                    float total=carga/precio.getPrecio97();
                    contenedor.setB97(contenedor.getB97()-total);
                    System.out.println("===================================================");
                    System.out.printf("Ha cargado: "+total+" litros de combustible 97 octanos.");
                    System.out.println("Gracias por venir a Copecc");
                    System.out.println("===================================================");
                    System.out.println("");
                    menuCarga();
                }
                break;
                case 4:
                metodoCarga();
                if (carga/precio.getPrecioDiesel() > contenedor.getDiesel()){
                    errorCantidadBencina();
                } else {
                    float total=(carga/precio.getPrecioDiesel());
                    contenedor.setDiesel(contenedor.getDiesel()-total);
                    System.out.println("===================================================");
                    System.out.println("Ha cargado: "+total+" litros de combustible Diesel.");
                    System.out.println("Gracias por venir a Copecc");
                    System.out.println("===================================================");
                    System.out.println("");
                    menuCarga();
                }
                break;
                case 5:
                System.out.println("Ingrese usuario: ");
                String user=teclado.nextLine();
                System.out.println("Ingrese contraseña");
                String pass=teclado.nextLine();
                panelAdministracion(user, pass);
                break;
                case 6:
                opcionApagar();
                break;
                default:
                System.out.println("Revisa el codigo");
                break;
            }
        }
    }
    
    //*************************
    //  METODO ADMINISTRACION
    //*************************
    
    public void panelAdministracion(String usuario, String clave){
        if (usuario.trim().equals("hflores") && clave.equals("holahola1")){
            int opcion=0;
            do {
                try {
                    System.out.println("(1) Acceso Contenedores Combustible");
                    System.out.println("(2) Modificar  Precios  Combustible");
                    System.out.println("(3) Dia Jueves");
                    System.out.println("(4) Salir");
                    opcion=Integer.parseInt(teclado.nextLine());
                } catch (Exception e) {
                    System.out.println("Ha ingresado un valor no valido. Debe ingresar un numero entre 1 y 3");
                    opcion=7;
                }
            } while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4);

            switch (opcion) {
                case 1:
                contenedor.nivelesCombustibles();
                panelAdministracion(usuario, clave);
                break;
                case 2:
                precio.modificarPrecios();
                panelAdministracion(usuario, clave);
                break;
                case 3:
                menuJueves();
                panelAdministracion(usuario, clave);
                break;
                case 4:
                menuCarga();
                break;
                default:
            }

        } else {
            System.out.println("Usuario o contraseña invalida.");
            menuCarga();
        }

    }
    
    //*******************
    //  MENU JUEVES
    //*******************
    
    public void menuJueves(){
        String valor="";
        do {
            System.out.println("Escriba: sube / baja");
            valor = teclado.nextLine();
        } while (!(valor.trim().toUpperCase().equals("SUBE")||valor.trim().toUpperCase().equals("BAJA")));
        precio.hoyEsJueves();
        precio.preciosJueves(valor);
        System.out.println("Los precios se han modificado");
        precio.listaPrecios();
    }
    
    //*******************
    //   MENU APAGAR
    //*******************

    public void opcionApagar(){
        System.out.println("Desea Apagar? S = Apaga // Otra tecla NO APAGA");
        String respuesta = teclado.nextLine();
        if (respuesta.trim().toUpperCase().equals("S")){
            System.out.println("Usuario");
            String user = teclado.nextLine();
            System.out.println("Contraseña");
            String pass = teclado.nextLine();
            if (user.trim().toUpperCase().equals("HFLORES") && pass.equals("holahola1")){
                System.out.println("====================");
                System.out.println("=      APAGADO     =");
                System.out.println("====================");
            } else {
                System.out.println("No tiene permisos suficientes");
                menuCarga();
            }
        } else {
            menuCarga();
        }
    }

}
