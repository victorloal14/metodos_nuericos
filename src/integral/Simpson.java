package integral;

import java.util.Scanner;

import funciones.Funcion;

public class Simpson {
    double a,b,delta_x;
    int n;
    Funcion funcion;
    String fun;
    public Simpson(String funcion,Double a, Double b, int n){
        if (n%2!=0){
            this.error("'n' no es un numero par");
        }else{
            this.a = a;
            this.b=b;
            this.n=n;
            this.delta_x=(b-a)/n;
            this.fun=funcion;
        }
    }

    public double simpson_1_3(){

        double resultado=0;
        this.funcion =new Funcion(fun,"x");
        resultado =funcion.eval_x(a);
        if (a!=0) {
            
            for (int i=1;i<n;i++){
                if ((i)%2==0){
                    resultado=resultado + 2*funcion.eval_x(a+(i*delta_x));
                }else{
                    resultado=resultado + 4*funcion.eval_x(a+(i*delta_x));
                }
            }
            resultado=resultado + funcion.eval_x(b);
        }
        else{
            a=delta_x;
            for (int i=1;i<n;i++){
                if (i%2==0){
                    resultado=resultado + 2*funcion.eval_x(i*a);
                }else{
                    resultado=resultado + 4*funcion.eval_x(i*a);
                } 
            }
            resultado=resultado + funcion.eval_x(b);
        }
        resultado=(delta_x*resultado)/3;
    
        return resultado;
    }

    public String error(String e){
        return e;
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Metodo de integracion por la regla 1/3 de Simpson para integrales definidas");
    System.out.println("este metodo integra una funcion definidad de (a) a (b)");
    System.out.println("ingrese la funcion a integral");
    String funcion = sc.next();
    System.out.println("ingrese el valor de a");
    double a = sc.nextDouble();
    System.out.println("ingrese el valor de b");
    double b = sc.nextDouble();
    System.out.println("ingrese el valor de n las divisiones del intervalo(tienen que ser par)");
    int n = sc.nextInt();
    System.out.println("Resultado");
    Simpson s = new Simpson(funcion,a,b,n);
    System.out.println(s.simpson_1_3());
    
    }
}
