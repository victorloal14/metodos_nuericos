package interpolacion;


import java.util.Scanner;
import polinomios.Operar_polinomio;
import polinomios.Pares;
import polinomios.Polinomio;


public class Lagrange {
    Pares[] xy;
    String[] li;
    Operar_polinomio operar = new Operar_polinomio();
    Polinomio pol1; 
    Polinomio aux;
    Polinomio pol = new Polinomio(0); 

    public Lagrange(Pares[] x_y){
        this.xy=x_y;
    }
    public Polinomio lagrange(){
        for(int i=0; i < xy.length;i++ ){
            double auxnum = 1;
            for (int j=0 ;j<xy.length ; j++) { 
                if(i!=j){
                    double[] x = {-xy[j].getX(),1};
                    aux = new Polinomio(1,x);
                    if(pol1 != null){
                        pol1 = operar.multiplicarPorFactor(pol1, aux);
                    }else{
                        pol1 = aux;
                    }
                    auxnum=auxnum*(xy[i].getX()-xy[j].getX());
                } 
            }
            
            double[] x = {xy[i].getY()/auxnum};
            aux = new Polinomio(0,x);
            pol1 =operar.multiplicarPorFactor(aux, pol1);
            pol =operar.suma(pol, pol1);  
            pol1 = null;
        }
        return pol;
    }
         public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x,y;
        System.out.println("Metodo de interpolacion de lagrange");
        System.out.println("ingrese el numero de puntos a calcular:");
        int n= sc.nextInt();
        Pares[] xy = new Pares[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("X"+(i+1)+":  ");
            x=sc.nextDouble();
            System.out.print("y"+(i+1)+":  ");
            y=sc.nextDouble();
            xy[i] = new Pares(x,y);
        }
        Lagrange lagrange= new Lagrange(xy) ;  
        System.out.print("polinomio =    ");
        System.out.println(lagrange.lagrange());
    }
}
