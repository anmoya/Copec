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
        Contenedor contenedor1 = new Contenedor(100000,100000,100000,100000);
        Precios precio1 = new Precios(698, 710, 745, 497, true);
        Dispensador dispensador1 = new Dispensador(teclado, precio1, contenedor1, true);
        
        
        
        
        //contenedor1.nivelesCombustibles();
        //precio1.listaPrecios();
        dispensador1.menuCarga();
        precio1.subirPrecios();
        dispensador1.menuCarga();
    }
}
