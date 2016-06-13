
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
    
    public Precios(){
        precio93=0;
        precio95=0;
        precio97=0;
        pDiesel=0;
        jueves=false;
    }
    
    public Precios(int precio93, int precio95, int precio97, int pDiesel, boolean jueves){
        setPrecio93(precio93);
        setPrecio95(precio95);
        setPrecio97(precio97);
        setPrecioDiesel(pDiesel);
        setDia(jueves);
    }
    
    public void setPrecio93(int precio93){
        this.precio93=precio93;
    }
    
    public void setPrecio95(int precio95){
        this.precio95=precio95;
    }
    
    public void setPrecio97(int precio97){
        this.precio97=precio97;
    }
    
    public void setPrecioDiesel(int pDiesel){
        this.pDiesel=pDiesel;
    }
    
    public void setDia(boolean jueves){
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
    
    public void subirPrecios(){
        if (jueves) {
            precio93=(float)(precio93+(precio93*0.02));
            precio95=(float)(precio95+(precio95*0.03));
            precio97=(float)(precio97+(precio97*0.025));
            pDiesel=(float)(pDiesel+(pDiesel*0.1));
        }
    }
            
    
        
}
