import java.util.Scanner;
/**
 * Write a description of class Precios here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Precios
{
    private float precio93;
    private float precio95;
    private float precio97;
    private float pDiesel;
    private boolean jueves;
    private Scanner teclado;

    public Precios(){
        precio93=0;
        precio95=0;
        precio97=0;
        pDiesel=0;
        jueves=false;
        teclado = new Scanner(System.in);
    }

    public Precios(float precio93, float precio95, float precio97, float pDiesel, boolean jueves, Scanner teclado){
        setPrecio93(precio93);
        setPrecio95(precio95);
        setPrecio97(precio97);
        setPrecioDiesel(pDiesel);
        setJueves(jueves);
        this.teclado=teclado;
    }

    public void setPrecio93(float precio93){
        if (precio93 > 0) {
            this.precio93=precio93;
        } else {
            System.out.println("Debe ser mayor que 0");
        }
    }

    public void setPrecio95(float precio95){
        if (precio95 > 0) {
            this.precio95=precio95;
        } else {
            System.out.println("Debe ser mayor que 0");
        }
    }

    public void setPrecio97(float precio97){
        if (precio97 > 0) {
            this.precio97=precio97;
        } else {
            System.out.println("Debe ser mayor que 0");
        }
    }

    public void setPrecioDiesel(float pDiesel){
        if (pDiesel > 0) {
            this.pDiesel=pDiesel;
        } else {
            System.out.println("Debe ser mayor que 0");
        }
    }

    public void setJueves(boolean jueves){
        this.jueves=jueves;
    }

    //getters
    public float getPrecio93(){
        return precio93;
    }

    public float getPrecio95(){
        return precio95;
    }

    public float getPrecio97(){
        return precio97;
    }

    public float getPrecioDiesel(){
        return pDiesel;
    }

    public boolean isJueves(){
        return jueves;
    }

    public void listaPrecios(){
        System.out.println("____LISTA DE PRECIOS_____");
        System.out.println("Bencina 97 octanos $" + precio97);
        System.out.println("Bencina 95 octanos $" + precio95);
        System.out.println("Bencina 93 octanos $" + precio93);
        System.out.println("Bencina Diesel     $" + pDiesel);
    }
    
    public void hoyEsJueves(){
        setJueves(true);
        if (jueves) {
            System.out.println("***************");
            System.out.println("*             *");
            System.out.println("*  ES JUEVES  *");
            System.out.println("*             *");
            System.out.println("***************");
        }
    }

    public void modificarPrecios(){

       try {
            //GAS 93
            int pAux=0;
            do {
                System.out.println("Ingrese un precio para Gasolina 93:");
                pAux = Integer.parseInt(teclado.nextLine());
            } while (pAux<0);
            setPrecio93(pAux);
            //GAS 95
            do {
                System.out.println("Ingrese un precio para Gasolina 95:");
                pAux = Integer.parseInt(teclado.nextLine());
            }
            while (pAux<0);
            setPrecio95(pAux);
            //GAS 97
            do {
                System.out.println("Ingrese un precio para Gasolina 97:");
                pAux = Integer.parseInt(teclado.nextLine());
            }while (pAux<0);
            setPrecio97(pAux);
            //DIESEL
            do {
                System.out.println("Ingrese un precio para Diesel:");
                pAux = Integer.parseInt(teclado.nextLine());
            } while (pAux<0);
            setPrecioDiesel(pAux);
        } catch (Exception e) {
            System.out.println("Ha ingresado una letra. Por favor, reingrese los montos.");
            modificarPrecios();
        }
    }

    public void preciosJueves(String valor){
        if (jueves && valor.trim().toUpperCase().equals("SUBE")) {
            precio93=(int)Math.round(precio93+(precio93*0.02));
            precio95=(int)Math.round(precio95+(precio95*0.03));
            precio97=(int)Math.round(precio97+(precio97*0.025));
            pDiesel=(int)Math.round(pDiesel+(pDiesel*0.01));
        }
        if (jueves && valor.trim().toUpperCase().equals("BAJA")) {
            precio93=(int)Math.round(precio93-(precio93*0.02));
            precio95=(int)Math.round(precio95-(precio95*0.03));
            precio97=(int)Math.round(precio97-(precio97*0.025));
            pDiesel=(int)Math.round(pDiesel-(pDiesel*0.01));
        }
    }

        
}
