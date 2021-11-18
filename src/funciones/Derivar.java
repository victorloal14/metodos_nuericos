package funciones;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;



public class Derivar {
    String funcion, x;
    DJep djep;
    Node nodoFuncion;
    Node nodoDerivada;

    public Derivar(String funcion,String x ){
        this.funcion = funcion;
        this.x =x;
    }

    public String derivar(){
        try {

            this.djep = new DJep();
            // agrega funciones estandares cos(x), sin(x)
            this.djep.addStandardFunctions();

            // agrega constantes estandares, pi, e, etc
            this.djep.addStandardConstants();

            // por si existe algun numero complejo
            this.djep.addComplex();

            // permite variables no declarables
            this.djep.setAllowUndeclared(true);

            // permite asignaciones
            this.djep.setAllowAssignment(true);

            // regla de multiplicacion o para sustraccion y sumas
            this.djep.setImplicitMul(true);


            // coloca el nodo con una funcion preestablecida
            this.nodoFuncion = this.djep.parse(this.funcion);

            // deriva la funcion con respecto a x
            Node diff = this.djep.differentiate(nodoFuncion, this.x);

            // Simplificamos la funcion con respecto a x
            this.nodoDerivada = this.djep.simplify(diff);

            // Convertimos el valor simplificado en un String
            this.funcion = this.djep.toString(this.nodoDerivada);

            diff = this.djep.simplify(nodoDerivada);

            String funcion2="";
            

            while (funcion2.equals(funcion)){
                diff = this.nodoDerivada;
                funcion=funcion2;

                // Simplificamos la funcion con respecto a x
                this.nodoDerivada = this.djep.simplify(diff);
                
                // Convertimos el valor simplificado en un String
                funcion2 = this.djep.toString(this.nodoDerivada);
            }

        } catch (ParseException e) {
            this.funcion = "NaN";
            System.out.println("Error: " + e.getErrorInfo());
        }
        return funcion;

    } 
    public String simplificar(){
        try {

            this.djep = new DJep();
            // agrega funciones estandares cos(x), sin(x)
            this.djep.addStandardFunctions();

            // agrega constantes estandares, pi, e, etc
            this.djep.addStandardConstants();

            // por si existe algun numero complejo
            this.djep.addComplex();

            // permite variables no declarables
            this.djep.setAllowUndeclared(true);

            // permite asignaciones
            this.djep.setAllowAssignment(true);

            // regla de multiplicacion o para sustraccion y sumas
            this.djep.setImplicitMul(true);


            // coloca el nodo con una funcion preestablecida
            this.nodoFuncion = this.djep.parse(this.funcion);

            // deriva la funcion con respecto a x
            Node diff = this.djep.simplify(nodoFuncion);

            // Simplificamos la funcion con respecto a x
            this.nodoDerivada = this.djep.simplify(diff);
            String funcion2="";
            

            while (!funcion2.equals(funcion)){
                diff = this.nodoDerivada;
                funcion=funcion2;

                // Simplificamos la funcion con respecto a x
                this.nodoDerivada = this.djep.simplify(diff);
                
                // Convertimos el valor simplificado en un String
                funcion2 = this.djep.toString(this.nodoDerivada);
            }
            
        } catch (ParseException e) {
            this.funcion = "NaN";
            System.out.println("Error: " + e.getErrorInfo());
        }
        return funcion;

    } 
    public static void main(String[] args) {
        Derivar d = new Derivar("67x^2-2*4*x^2", "x");
        System.out.println("Derivada  "+d.simplificar()); 
    }

   
}
