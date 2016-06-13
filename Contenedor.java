import java.util.Scanner;
/**
 * Write a description of class Contenedor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Contenedor
{
    private double b97oc; //bencina 97 octanos
    private double b95oc; //bencina 97 octanos
    private double b93oc; //bencina 97 octanos
    private double diesel; //diesel

    public Contenedor(){
        b97oc=0;
        b95oc=0;
        b93oc=0;
        diesel=0;
    }

    public Contenedor(double b97oc, double b95oc, double b93oc, double diesel){
        setB97(b97oc);
        setB95(b95oc);
        setB93(b93oc);
        setDiesel(diesel);
    }

    //setters
    public void setB97(double b97oc){
        this.b97oc=b97oc;
    }

    public void setB95(double b95oc){
        this.b95oc=b95oc;
    }

    public void setB93(double b93oc){
        this.b93oc=b93oc;
    }

    public void setDiesel(double diesel){
        this.diesel=diesel;
    }

    //getters
    public double getB97(){
        return b97oc;
    }

    public double getB95(){
        return b95oc;
    }

    public double getB93(){
        return b93oc;
    }

    public double getDiesel(){
        return diesel;
    }

    //imprimir
    public void nivelesCombustibles(){
        System.out.println("Tipo   - Litros");
        System.out.println("97 oct - "+b97oc);
        System.out.println("95 oct - "+b95oc);
        System.out.println("93 oct - "+b93oc);
        System.out.println("Diesel - "+diesel);
    }

    //     public void usarReserva(){
    //         if (b97oc < 101 || b95oc < 101 || b93oc < 101 || diesel < 101){
    //             String respuesta="SI";
    //             do {
    //                 System.out.println("Desea usar reserva?");
    //                 respuesta=teclado.nextLine();
    //             } while (!(respuesta.trim().toUpperCase().equals("SI"))||(!(respuesta.trim().toUpperCase().equals("NO"))));
    //             if (respuesta.trim().toUpperCase().equals("SI")){
    //                 b97oc=b97oc+200;
    //                 b95oc=b95oc+200;
    //                 b93oc=b93oc+200;
    //                 diesel=diesel+200;
    //             } else {
    //                 System.out.println("No ha usado la reserva");
    //             }
    //         }
    // 
    //     } 
}
