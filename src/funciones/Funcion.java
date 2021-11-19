package funciones;


import org.nfunk.jep.JEP;

public class Funcion {
    String fun;
    JEP jep = new JEP();
    double resultado = 0;
    public Funcion ( String fun,String x,String y) {
        jep.addVariable(x,0);
        jep.addVariable(y,0);
        jep.addStandardConstants();
        jep.addComplex();
        jep.addStandardFunctions();
        this.fun = fun;
        jep.parseExpression(fun);
    }
    public Funcion ( String fun,String x) {;
        jep.addVariable(x,0);
        jep.addStandardConstants();
        jep.addComplex();
        jep.addStandardFunctions();
        jep.parseExpression(fun);
    }
    public double eval_x (double x){
        jep.addVariable("x", x);
        resultado = jep.getValue();
        if(jep.hasError()){
            System.out.println("error");  
        }
        
        return resultado;
    }
    public double eval_xy (double x,double y,String x_,String y_){
        jep.addVariable(x_, x);
        jep.addVariable(y_, y);
        resultado = jep.getValue();
        if(jep.hasError()){
            System.out.println("error");  
        }
        
        return resultado;
    }
    public String simplificar(){
        jep.addConstant("x", 0);

        return fun;
    }
    public String getFuncion(){
        return "";
    }
    public static void main(String[] args) {
        
        Funcion f = new Funcion("(-(((29.8*x)^(1/2))*0.05^2)/(2.0^2) )","x");
     
        System.out.println(f.eval_x(0.1));
        System.out.println(f.getFuncion());    
    }

}

