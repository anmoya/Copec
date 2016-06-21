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
        
        Contenedor copecCombus = new Contenedor(100,100,100,100);
        Precios copecPrecio = new Precios(678, 712, 745, 498, false/*no es jueeves*/, teclado);
        Dispensador dispensadorCopec = new Dispensador(teclado, copecPrecio, copecCombus, true/*habilitado*/);
        
        dispensadorCopec.menuCarga();


    }
}
