package polinomios;


public class Polinomio {

    double[] coef;
    int grado ;
    public Polinomio(int grado, double[] coeficientes){
        this.coef = coeficientes;
        this.grado= grado;
    }
    public Polinomio(int grado){
        this.grado= grado;
        this.coef = new  double[grado+1];
        for (int i=1 ; i>grado+1;i++){
            this.coef[i]=1;
        }
        this.coef[0]=0;
    }
    public Polinomio(double[] coeficientes){
        this.coef= coeficientes;
        this.grado = coeficientes.length-1;
    }

    public int getGrado(){
        return grado;
    }
    public double getCoef(int i){
        return coef[i];
    }
    public double[] getTodosLosCoef(){
        return coef; 
    }
    public void setCoef(int i, double coeficiente){
        coef[i] = coeficiente;

    }
    public void setTodosLosCoef(double[] coeficientes){
        coef = coeficientes;
        this.grado=coeficientes.length-1;
    }
    @Override
    public String toString() {
        String aux = ""+coef[grado]+"x^"+grado;

        for (int i = grado-1; i > 0; i--) {
            if (coef[i]!= 0.0) {
                aux =aux+" + "+coef[i]+"x^"+i;   
            }
        }
        if (coef[0]!=0.0) {
            aux = aux +" + "+ coef [0];
        }
        aux=aux.replace("++", " + ");
        aux=aux.replace("+ -", " - ");
        aux=aux.replace("- +", " - ");

        return aux;
    }
    
}
