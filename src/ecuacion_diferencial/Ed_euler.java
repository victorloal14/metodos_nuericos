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
    public  Pares[] calcular (String var_x,String var_y){
        Funcion f = new Funcion(funcion,var_x,var_y);
        System.out.println(x_y.length);
        for (int i = 1; i < x_y.length; i++) {
            this.x_y[i]= new Pares();
            double j =x_y[0].getX()+(i*h);
            x_y[i].setX(j);
            x_y[i].setY(x_y[i-1].getY()+h*f.eval_xy(x_y[i-1].getX(),x_y[i-1].getY(),var_x,var_y));
        
        }

        return x_y;
    }
    public Pares[] tanque_cilindrico(double D,double d,double g){
        this.funcion = "(-(((2"+g+"*x)^(1/2))*"+d+"^2)/"+D+"^2 )";
        Funcion f = new Funcion(funcion,"x");
        System.out.println(x_y.length);
        for (int i = 1; i < x_y.length; i++) {
            this.x_y[i]= new Pares();
            double j =x_y[0].getX()+(i*h);
            x_y[i].setX(j);
            System.out.println(f.eval_x(x_y[i-1].getY()));
            System.out.println(x_y[i-1].getY()+h);
            
            x_y[i].setY(x_y[i-1].getY()+h*f.eval_x(x_y[i-1].getY()));
        
        }

        return x_y;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x,y;
        int w = 0;
        while(w != 1 && w!= 2){
            System.out.println("Metodo de Euler");
            System.out.println("----------------------------------------------------------------------");
            System.out.println();
            System.out.println("1) calcular una ecuacion (EDO) de primer grado");
            System.out.println("2) calcular el vaciado de un tanque en un volumen determinado");
            System.out.println();
            System.out.println("----------------------------------------------------------------------");
            w = sc.nextInt();    
        }
        if (w==1){
            System.out.println("ingerese la primera variable");
            String x_var = sc.next();
            System.out.println("ingerese la primera variable");
            String y_var = sc.next();
            System.out.println("ingrese el valor de "+x_var+"0:" );
            x=sc.nextDouble();
            System.out.println("ingrese el valor de "+y_var+"0:");
            y =sc.nextDouble();
            System.out.println("ingrese el valor que aumenta "+x_var+" en cada interacion:");
            double z =sc.nextDouble();
            System.out.println("ingrese el valor que final de "+x_var);
            double q =sc.nextDouble();
            System.out.print("ingrese la funcion d"+y_var+"/d"+x_var +"= ");
            String o =sc.next();
    
            System.out.println("quiere mstrar todas las iteraciones (true o false)");
            System.out.println();
            boolean f = sc.nextBoolean();
            if(f){
                System.out.println("");
                Pares x_y = new Pares(x, y);
                Pares[] x_y2; 
                Ed_euler ed = new Ed_euler(o, x_y,z, q);
                x_y2 = ed.calcular(x_var,y_var);
                System.out.println("N_iteracion|valor de la variable "+x_var+"|valor de la variable "+y_var);
                for(int i =0 ;i<x_y2.length; i++ ){
                    System.out.println(i+" | "+x_y2[i].getX()+" | "+x_y2[i].getY());
                }
                System.out.println("N_iteracion|valor de la variable "+x_var+"|valor de la variable "+y_var);
            }else{
                System.out.println("");
                Pares x_y = new Pares(x, y);
                Pares[] x_y2; 
                Ed_euler ed = new Ed_euler(o, x_y,z, q);
                x_y2 = ed.calcular(x_var,y_var);
                System.out.println("N_iteracion|valor de la variable "+x_var+"|valor de la variable "+y_var);
                System.out.println( x_y2.length+" | "+x_y2[x_y2.length-1].getX()+" | "+x_y2[x_y2.length-1].getY());
            }
        }else{
            System.out.println("ingrese el valor de la grabedad (g)");
            double g = sc.nextDouble();
            System.out.println("ingrese el valor del diametro del tanque (D)");
            double d_= sc.nextDouble();
            System.out.println("ingrese el valor del diametro del orificio de salida (d)");
            double d=sc.nextDouble();
            System.out.println("ingrese el valor de la altura maxima del tanqe (H)");
            y =sc.nextDouble();
            System.out.println("ingrese el valor que final del tiempo");
            double h =sc.nextDouble();
            System.out.println("ingrese el valor que aumenta el tiempo");
            double h_ =sc.nextDouble();
        
            System.out.println("quiere mostrar todas las iteraciones (true o false)");
            System.out.println();
            boolean f = sc.nextBoolean();
            if(f){
                System.out.println("");
                Pares x_y = new Pares(0, y);
                Pares[] x_y2; 
                Ed_euler ed = new Ed_euler("", x_y,h_ , h);
                x_y2 = ed.tanque_cilindrico(d_, d, g);
                System.out.println("N_iteracion|valor del tiempo |valor de la altura");
                for(int i =0 ;i<x_y2.length; i++ ){
                    System.out.println(x_y2[i]);
                }
                System.out.println("N_iteracion|valor del tiempo |valor de la altura");
            }else{
                System.out.println("");
                Pares x_y = new Pares(0, y);
                Pares[] x_y2; 
                Ed_euler ed = new Ed_euler("", x_y,h_ , h);
                x_y2 = ed.tanque_cilindrico(d_, d, g);
                System.out.println("N_iteracion|valor del tiempo |valor de la altura");
                System.out.println(x_y2[x_y2.length]);
            }
    }
        
    }
    
}
