import java.util.ArrayList;

public class Simulacion {
    
    public int dias;        //Días que va a durar la simulación
    public ArrayList<Comunidad> comunidades = new ArrayList<Comunidad>();       //Conjunto de comunidades que componen la simulación
    int[][] infectadosTotal;        //Número de infectados totales
    
    public Simulacion() {
    }
    
    /*
     * Método que añade una comunidad a la simulación
     */
    public void addComunidad(Comunidad nuevaComunidad) {
        comunidades.add(nuevaComunidad);
    }
    
    /*
     * Método que hace los cálculos para llenar la matriz de infectados de cada comunidad
     */
    public void calcularInfectados() {
        double mediaND = 0;
        double poblacionMedia = 0;
        //Introducimos los valores del primer día en todas las comunidades
        for(int i = 0; i < comunidades.size() ; i++) {
            comunidades.get(i).infectados[0][0] = comunidades.get(i).getInfectadosIniciales();
            comunidades.get(i).infectados[1][0] = 0;
            comunidades.get(i).infectados[2][0] = comunidades.get(i).getInfectadosIniciales();
            mediaND += comunidades.get(i).infectados[2][0];
            poblacionMedia += comunidades.get(i).getPoblacion();
        }
        mediaND = mediaND/comunidades.size();
        poblacionMedia = poblacionMedia/comunidades.size();
        
        //Hacemos los cálculos para calcular cada tipo de infectado en cada comunidad
        for(int i = 1; i < dias ; i++) {
            double aux = 0;
            for(int j = 0; j < comunidades.size() ; j++) {
                comunidades.get(j).infectados[0][i] = comunidades.get(j).infectados[0][i-1]*(int)(1+comunidades.get(j).getCoeficienteE()*comunidades.get(j).getCoeficienteP());
                comunidades.get(j).infectados[1][i] = (int)(comunidades.get(j).getCoeficienteE()*comunidades.get(j).getCoeficienteP()*comunidades.get(j).getCoeficienteV()*mediaND/poblacionMedia);
                comunidades.get(j).infectados[2][i] = comunidades.get(j).infectados[0][i] + comunidades.get(j).infectados[1][i];
                if(comunidades.get(j).infectados[2][i] >= comunidades.get(j).getPoblacion()) {
                    comunidades.get(j).infectados[0][i] = comunidades.get(j).getPoblacion();
                    comunidades.get(j).infectados[1][i] = comunidades.get(j).getPoblacion();
                    comunidades.get(j).infectados[2][i] = comunidades.get(j).getPoblacion();
                }
                aux += comunidades.get(j).infectados[2][i];
            }
            mediaND = aux/comunidades.size();
        }
    }
    
    //Método para calcular la población total, suma de todas las comunidades
    public int poblacionTotal() {
        int res = 0;
        for(int i = 0; i < comunidades.size() ; i++) {
            res += comunidades.get(i).getPoblacion();
        }
        return res;
    }
    
    //Método que calcula cada tipo de infectdos en total por día
    public void infectadosTotal() {
        infectadosTotal = new int[3][dias];
        int contagiadosIniciales = 0;
        for(int i = 0; i < comunidades.size() ; i++) {
            comunidades.get(i).infectados[0][0] = comunidades.get(i).getInfectadosIniciales();
            comunidades.get(i).infectados[1][0] = 0;
            comunidades.get(i).infectados[2][0] = comunidades.get(i).getInfectadosIniciales();
            contagiadosIniciales += comunidades.get(i).infectados[2][0];
        }
        
        infectadosTotal[0][0] = contagiadosIniciales;
        infectadosTotal[1][0] = 0;
        infectadosTotal[2][0] = contagiadosIniciales;
           
        for(int i = 1; i < dias ; i++) {
            int a = 0;
            int b = 0;
            int c = 0;
            for(int j = 0; j < comunidades.size() ; j++) {
                a += comunidades.get(j).infectados[0][i];
                b += comunidades.get(j).infectados[1][i];
                c += comunidades.get(j).infectados[2][i];
            }
            infectadosTotal[0][i] = a;
            infectadosTotal[1][i] = b;
            infectadosTotal[2][i] = c;
        }
    }
}
