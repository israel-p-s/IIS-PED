/*
 * Clase Comunidad, contiene toda la información de una comunidad
 */
public class Comunidad {
    private String nombre;
    private int infectadosIniciales;
    private int poblacion;
    private double coeficienteE;
    private double coeficienteP;
    private int coeficienteV;
    public int[][] infectados;  //Esta matriz se inicializa con 3 filas y días columnas. FILA 1: infectados, FILA 2: infectados por viajeros, FILA 3: infectados totales
    
    public Comunidad (String nombre, int infectadosIniciales, int poblacion, double coeficienteE, double coeficienteP, int coeficienteV, int[][] infectados){
        this.nombre = nombre;
        this.infectadosIniciales = infectadosIniciales;
        this.poblacion = poblacion;
        this.coeficienteE = coeficienteE;
        this.coeficienteP = coeficienteP;
        this.coeficienteV = coeficienteV;
        this.infectados = infectados;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String modificarNombre) {
        this.nombre = modificarNombre;
    }
    
    public int getInfectadosIniciales() {
        return infectadosIniciales;
    }
    
    public void setInfectadosIniciales(int modificarInfectadosIniciales) {
        this.infectadosIniciales = modificarInfectadosIniciales;
    }
    
    public int getPoblacion() {
        return poblacion;
    }
    
    public void setPoblacion(int modificarPoblacion) {
        this.poblacion = modificarPoblacion;
    }
    
    public double getCoeficienteE() {
        return coeficienteE;
    }
    
    public void setCoeficienteE(double modificarCoeficienteE) {
        this.coeficienteE = modificarCoeficienteE;
    }
    
    public double getCoeficienteP() {
        return coeficienteP;
    }
    
    public void setCoeficienteP(double modificarCoeficienteP) {
        this.coeficienteP = modificarCoeficienteP;
    }
    
    public int getCoeficienteV() {
        return coeficienteV;
    }
    
    public void setCoeficienteV(int modificarCoeficienteV) {
        this.coeficienteV = modificarCoeficienteV;
    }
}
