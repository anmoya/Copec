import java.util.Scanner;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);

        //copec
        Administracion administracion1 = new Administracion();
        Contenedor copecCombus = new Contenedor(100000,100000,100000,100000);
        Precios copecPrecio = new Precios(698, 710, 745, 497, false/*no es jueeves*/, teclado);
        Dispensador dispensadorCopec = new Dispensador(administracion1, teclado, copecPrecio, copecCombus, true/*habilitado*/);
        
        dispensadorCopec.menuCarga();
        
//         copecPrecio.listaPrecios();
//         copecPrecio.hoyEsJueves();
//         copecPrecio.preciosJueves("sube");
//         copecPrecio.listaPrecios();

        //shell
//         Contenedor shellCombus = new Contenedor(3500,4500,5500,6000);
//         Precios shellPrecio = new Precios(650, 689, 702, 440, true, teclado);
//         Dispensador dispensadorShell = new Dispensador(teclado, shellPrecio, shellCombus, true);

//         copecPrecio.listaPrecios();
//         System.out.println(" ");
//         shellPrecio.listaPrecios();
//         System.out.println(" ");
//         copecCombus.nivelesCombustibles();
//         System.out.println(" ");
//         shellCombus.nivelesCombustibles();
//         System.out.println(" ");
// 
//         shellPrecio.modificarPrecios();
//         System.out.println(" ");
//         dispensadorShell.menuCarga();
//         System.out.println(" ");
//         copecPrecio.isJueves();           
//         copecPrecio.hoyEsJueves();
//         copecPrecio.isJueves();
//         copecPrecio.preciosJueves("SUBE");
//         dispensadorCopec.menuCarga();
// 
//         System.out.println(" ");
//         shellPrecio.listaPrecios();
//         System.out.println(" ");


    }
}
