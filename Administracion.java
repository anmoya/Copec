import java.util.Scanner;
/**
 * Write a description of class Administracion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Administracion
{
    private Scanner teclado;
    
    public Administracion(){
        teclado = new Scanner(System.in);
    }
    
    public Administracion(Scanner teclado){
        this.teclado=teclado;
    }
    
    public void panelAdministracion(String usuario, String clave){
        if (usuario.trim().equals("hflores") && clave.trim().equals("POORULES!")){
            System.out.println("(1) Acceso Contenedores Combustible");
            System.out.println("(2) Acceso Contenedores Combustible");
            System.out.println("(3) Salir");
            int opcion=Integer.parseInt(teclado.nextLine());
            
            switch (opcion) {
                case 1:
                
                break;
                default:
            }
                
                
            
        } else {
           System.out.println("Usuario o contraseña invalida.");
        }
            
    }
}
