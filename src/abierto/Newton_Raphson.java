package abierto;

import java.util.Scanner;

import funciones.Derivar;
import funciones.Funcion;

public class Newton_Raphson {
    String funcion ,x ;
    double punt1,punt2=1,valor=0;
    int iteraciones = -1;

    public Newton_Raphson(String funcion, String x, double punt1,int iteraciones){
        this.funcion =funcion;
        this. x = x;
        this.punt1  = punt1;
        this.iteraciones = iteraciones;

    }
    public void solucion() {
        Funcion f = new Funcion(funcion,x);
        Derivar d = new Derivar(funcion, x);
        Funcion g = new  Funcion(d.derivar(), x);
        if(iteraciones != -1){
            for (int i=0 ; i< iteraciones ; i++){
                valor =punt1-(f.eval_x(punt1)/g.eval_x(punt1));
                punt1 = valor;
            } 
        }else{
            while (punt2 != valor){
                valor =punt1-(f.eval_x(punt1)/g.eval_x(punt1));
                punt2 = punt1;
                punt1 = valor;
    
            }
        }
        System.out.println("Resultado:");
        System.out.println(valor);
    }

    public static void main(String[] args) {
        System.out.println("Metodo de Newton-Raphson");
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba la funcion: ");
        String funcion = sc.next();
        System.out.println("Escriba la variable de la funcion: ");
        String var = sc.next();
        System.out.println("Escriba el x inicial");
        double x_inicial = sc.nextDouble();
        System.out.println("Escriba el numero de veces a iterar (si escribe -1 iterara hasta que el numero no cambie):");
        int num_iterar = sc.nextInt();
        Newton_Raphson nr = new  Newton_Raphson(funcion,var,x_inicial,num_iterar);
        nr.solucion();
    }
   

    
}
