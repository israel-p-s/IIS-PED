import java.util.Scanner;



public class Main {
    /*
     * Método principal del programa muestra el menú principal
     */
    public static void main(String []args) {
        System.out.println("\nMENÚ PRINCIPAL:\n");
        System.out.println("\t>>ALUMNO: Israel Palma Sebastià");
        System.out.println("\t>>ASIGNATURA: Introducción a la Ingeniería del Software");
        System.out.println("\t>>DESCRIPCIÓN: Aplicación hecha durante el segundo cuatrimestre del curso 2019-2020.");
        System.out.println("\t>>Esta aplicación simula la propagación de un virus a través de un zona dividida por comunidades.");
        System.out.println("\nHAZ CLICK EN INTRO PARA INICIAR LA SIMULACIÓN\n");
        
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        simulacion();
    }
    
    /*
     * Método que maneja la simulación y la imprime
     */
    public static void simulacion() {
        Scanner sc = new Scanner(System.in);
        Simulacion s = new Simulacion();
        for(int i = 0; i < 10; i++) {
            try {
                Thread.sleep(3*100);
            } catch (Exception e) { 
                System.out.println(e);
            }
            System.out.println("\nComenzando la simulación...\n");
        }
        System.out.println("¿Cuantos días va a durar la simulación?");
        int dias = sc.nextInt();
        s.dias = dias;
        System.out.println("¿Cuantas comunidades quieres que tenga la simulación?");
        int comunidades = sc.nextInt();
        for(int i = 0; i < comunidades; i++) {
            sc.nextLine();
            System.out.println("Introduzca el nombre de la comunidad:");
            String nombre = sc.nextLine();
            System.out.println("Introduzca el número de infectados iniciales:");
            int infectadosIniciales = sc.nextInt();
            System.out.println("Introduzca el número de habitantes:");
            int habitantes = sc.nextInt();
            System.out.println("Introduzca el número de contactos promedio de infectados:");
            double coeficienteE = sc.nextDouble();
            System.out.println("Introduzca la probabilidad de infectar un individuo:");
            double coeficienteP = sc.nextDouble();
            System.out.println("Introduzca el número de viajeros entre comunidades:");
            int coeficienteV = sc.nextInt();
            int[][] infectados = new int[3][dias]; 
            Comunidad comunidad = new Comunidad(nombre,infectadosIniciales,habitantes,coeficienteE,coeficienteP,coeficienteV,infectados);
            s.addComunidad(comunidad);
        }
        
        s.calcularInfectados();
        s.infectadosTotal();
        
        for(int i = 0; i < 10; i++) {
            try {
                Thread.sleep(3*100);
            } catch (Exception e) { 
                System.out.println(e);
            }
            System.out.println("\nHaciendo cálculos...\n");
        }
        
        for(int i = 0; i < dias; i++) {
            System.out.println("\n\n\tRESULTADOS DEL DIA: " + (i+1) + "\n");
            System.out.format("%6s%16s%25s%24s%15s","NOMBRE","INFECTADOS","INFECTADOS/VIAJEROS","INFECTADOS TOTALES","POBLACIÓN\n");
            for(int j = 0; j < s.comunidades.size(); j++){
                System.out.format("%6s%16s%25s%24s%15s",s.comunidades.get(j).getNombre(),s.comunidades.get(j).infectados[0][i],s.comunidades.get(j).infectados[1][i],s.comunidades.get(j).infectados[2][i],s.comunidades.get(j).getPoblacion() + "\n");
            }
            System.out.format("%6s%16s%25s%24s%15s","TOTAL",s.infectadosTotal[0][i],s.infectadosTotal[1][i],s.infectadosTotal[2][i],s.poblacionTotal() + "\n");
        }
        sc.nextLine();
        System.out.println("\n\n¿Desea repetir la simulación?\ny + INTRO para repetirlo. Cualquier otra tecla + INTRO para salir");
        String respuesta = sc.nextLine();
        if(respuesta.equals("y")) {
            simulacion();
        } else {
            System.exit(0);
        }
    }

}
