/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package neocds;

import java.util.Arrays;

/**
 *
 * @author Augusto
 */
public class Inventario {
    private Disco[] discos;
    private int nroDiscos;
    
    /**
     * Constructor de la clase inventario, inicializa el arreglo con doce discos predefinidos
     */
    public Inventario () {
        discos = new Disco[12];
        nroDiscos = 12;
        discos[0] = new Disco("El Patillero",10, 17900, 'A');
        discos[1] = new Disco("Toque de clase", 8, 25000, 'B');
        discos[2] = new Disco("Siembra",7, 27000, 'C');
        discos[3] = new Disco("De ti depende", 8, 18000, 'D');
        discos[4] = new Disco("Clásicos de la provincia", 15, 25000,'E');
        discos[5] = new Disco("Herencia Vallenata", 10, 22000, 'C');
        discos[6] = new Disco("Título de amor", 11, 23500, 'D');
        discos[7] = new Disco("2.000" , 12, 32000, 'A');
        discos[8] = new Disco("Suavemente", 10, 24000, 'B');
        discos[9] = new Disco("Ojalá que llueva café", 8, 24500, 'E');
        discos[10] = new Disco("Pa' otro lao'", 10, 43000, 'A');
        discos[11] = new Disco("Otra vez...",9,12000, 'B');
    }
    
    /**
     * @param pos Posición en la que se guardará el disco
     * @param disco  Asigna un objeto a la posición deseada, se encuentra privado ya que solo será de uso interno en este caso
     */
    private void setDisco(int pos, Disco disco) {
        discos[pos] = disco;
    }
    
    /**
     * 
     * @param pos posición deseada
     * @return el objeto Disco en la posición que se le entregue como parámetro
     */
    public Disco getDisco(int pos) {
        return discos[pos];
    }
    
    /**
     * 
     * @param disco 
     * Añade un nuevo disco al final del arreglo
     */
    public void añadirDisco(Disco disco) {
        aumentarArreglo();
        setDisco(getNroDiscos()-1, disco);
    }
    /**
     * 
     * @return la cantidad de discos que se encuentran guardados
     */
    public int getNroDiscos() {
        return nroDiscos;
    }
    /**
     * Método que aumenta de forma automática el tamaño del arreglo utilizado sin perder la información lo que nos
     * permite tener un vector de tamaño dinámico
     */
    public void aumentarArreglo() {
        Disco[] aux = discos;
        nroDiscos++;
        discos = new Disco[nroDiscos];
        System.arraycopy(aux, 0, discos, 0, aux.length);
        
    }
    
    /*
    --------------------------------------------------------------------------------------------------------------------------------------------
    ------------------------------------------------ORDENAMIENTO Y BÚSQUEDA----------------------------------------------------
    --------------------------------------------------------------------------------------------------------------------------------------------
    */
    
    private void cambiar(int p1, int p2) {
        Disco aux = getDisco(p1);
        setDisco(p1, getDisco(p2));
        setDisco(p2, aux);
    }
    
    private void ordenarValores() {
        for (int i = 0; i <= getNroDiscos() - 1; i++) {
            for (int j = i+1; j <= getNroDiscos() - 1; j++) {
                if (getDisco(i).getValor() > getDisco(j).getValor()) {
                    cambiar(i, j);
                }
            }
        }
    }
    
   public void ordenarAlfabeticamente() {
       Arrays.sort(discos);
   }
   
       public void ordenarBurbuja() {
        for (int i = 0; i<=getNroDiscos()-1; i++) {
            for (int j = 0; j <= (getNroDiscos()-i)-2;j++) {
                if (getDisco(j).getNroPistas() > getDisco(j+1).getNroPistas()) {
                    cambiar(j, j+1);
                }
            }
        }
    }
    
    public void ordenarIntercambio() {
        for (int i = 0; i <= getNroDiscos() - 1; i++) {
            for (int j = i+1; j <= getNroDiscos() - 1; j++) {
                if (getDisco(i).getNroPistas() > getDisco(j).getNroPistas()) {
                    cambiar(i, j);
                }
            }
        }
    }
    
    public void ordenarQuickSort(int primero, int ultimo){
        int i, j, centro;
        int pivote;
        centro = (primero+ultimo)/2;
        pivote = getDisco(centro).getNroPistas();
        i = primero;
        j = ultimo;
        do {
            while((i <= j) && (getDisco(i).getNroPistas() < pivote)){
            i = i + 1;
            }
            while((i <= j) && (getDisco(j).getNroPistas() > pivote)){
            j = j - 1;
            }
            if(i <= j){
                cambiar(i, j);
                i = i + 1;
                j = j - 1;
            }
        }while(i <= j);

        if(primero < j){
            ordenarQuickSort(primero, j);
        }
        if(i < ultimo){
            ordenarQuickSort(i, ultimo);
        }
    }
     
    public void ordenarShell(){
        int i, n, cont;
        n = (getNroDiscos()-1)/2;
        while(n != 0){
                cont = 1;
            while(cont != 0){
                cont = 0;
                for(i=n; i<=getNroDiscos()-1; i++){
                    if(getDisco(i-n).getNroPistas() > getDisco(i).getNroPistas()){
                        cambiar(i, i-n);
                        cont = cont + 1;
                    }
                }
            }
            n = n/2;
        }
    }

        public int busquedaLineal(float valor) {
        int i = 0;
        int pos = -1;
        
        while (pos == -1 && i< getNroDiscos()) {
            if(getDisco(i).getValor() == valor) {
                pos = i;
            }
        }
        return pos;
    }
    
     public int busquedaBinaria(float valor){
        int posicion, izq, der, centro; 
        ordenarValores(); 
        izq = 0; 
        der = getNroDiscos()-1; 
        posicion = -1;
        while ((izq <= der) && (posicion == -1)){
            centro = (izq + der) / 2;
            if (getDisco(centro).getValor() == valor){
                posicion = centro;
            }else{
                if (valor < (getDisco(centro).getValor())){
                    der = centro-1;
                }else{
                    izq = centro+1;
                }
            }
        }
        return posicion;
     }       
}
