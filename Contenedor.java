import java.util.Scanner;
/**
 * Write a description of class Contenedor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Contenedor
{
    private float b97oc; //bencina 97 octanos
    private float b95oc; //bencina 97 octanos
    private float b93oc; //bencina 97 octanos
    private float diesel; //diesel

    public Contenedor(){
        b97oc=0;
        b95oc=0;
        b93oc=0;
        diesel=0;
    }

    public Contenedor(float b97oc, float b95oc, float b93oc, float diesel){
        setB97(b97oc);
        setB95(b95oc);
        setB93(b93oc);
        setDiesel(diesel);
    }

    //setters
    public void setB97(float b97oc){
        if (b97oc<0){
            System.out.println("Debe ser un valor mayor a 0");
        } else {
            this.b97oc=b97oc;
        }
    }

    public void setB95(float b95oc){
        if (b95oc<0){
            System.out.println("Debe ser un valor mayor a 0");
        } else {
            this.b95oc=b95oc;
        }
    }

    public void setB93(float b93oc){
        if (b93oc<0){
            System.out.println("Debe ser un valor mayor a 0");
        } else {
            this.b93oc=b93oc;
        }
    }

    public void setDiesel(float diesel){
        if (diesel<0){
            System.out.println("Debe ser un valor mayor a 0");
        } else {
            this.diesel=diesel;
        }
    }

    //getters
    public float getB97(){
        return b97oc;
    }

    public float getB95(){
        return b95oc;
    }

    public float getB93(){
        return b93oc;
    }

    public float getDiesel(){
        return diesel;
    }

    //imprimir
    public void nivelesCombustibles(){
        System.out.println("Tipo   - Litros");
        System.out.println("93 oct - "+b93oc);
        System.out.println("95 oct - "+b95oc);
        System.out.println("97 oct - "+b97oc);
        System.out.println("Diesel - "+diesel);
    }
}
