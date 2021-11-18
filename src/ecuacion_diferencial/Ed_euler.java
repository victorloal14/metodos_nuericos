package ecuacion_diferencial;


import java.util.Scanner;

import funciones.Funcion;
import polinomios.Pares;

public class Ed_euler {
    String funcion;
    
    double h,x_final;
    Pares x_y[];

    public Ed_euler(String funcion,Pares x_y,double aumento_x,double x_final){
        this.funcion = funcion;
        this.h = aumento_x;
        this.x_final=x_final;
        this.x_y = new Pares[(int) ((x_final-x_y.getX())/aumento_x)+1];
        this.x_y[0]=x_y;
    } 
    public  Pares[] calcular (){
        Funcion f = new Funcion(funcion,"x","y");
        System.out.println(x_y.length);
        for (int i = 1; i < x_y.length; i++) {
            this.x_y[i]= new Pares();
            double j =x_y[0].getX()+(i*h);
            x_y[i].setX(j);
            x_y[i].setY(x_y[i-1].getY()+h*f.eval_xy(x_y[i-1].getX(),x_y[i-1].getY()));
        
        }

        return x_y;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x,y;
        System.out.println("ingrese el valor de x0");
        x=sc.nextDouble();
        System.out.println("ingrese el valor de y0");
        y =sc.nextDouble();
        System.out.println("ingrese el valor que aumento x en cada interacion:");
        double z =sc.nextDouble();
        System.out.println("ingrese el valor que final de x ");
        double q =sc.nextDouble();
        System.out.print("ingrese la funcion dy/dx=");
        String o =sc.next();


        Pares x_y = new Pares(x, y);
        Pares[] x_y2; 
        Ed_euler ed = new Ed_euler(o, x_y,z, q);
        x_y2 = ed.calcular();
        for(int i =0 ;i<x_y2.length; i++ ){
            System.out.println(x_y2[i]);
        }
    }
    
}
