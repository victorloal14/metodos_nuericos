package polinomios;

public class Operar_polinomio {
   Polinomio poli;
   Polinomio poli2;
    public void negado(Polinomio poli){
        for (int i = 0; i < poli.grado+1; i++) {
            poli.setCoef(i,-poli.getCoef(i));
        }
    }
    public Polinomio suma(Polinomio polinomio1, Polinomio polinomio2){
        this.poli = polinomio1;
        this.poli2 = polinomio2;
        if (poli.getGrado()<poli2.getGrado()) {
            for (int i = 0; i < poli2.getGrado()+1  ;  i++) {
                int j = i;
                if(j<poli.getGrado()+1){
                    poli2.setCoef(i,poli.getCoef(i)+poli2.getCoef(i));
                }
            }
            poli =poli2;
        }else{
            for (int i = 0; i < poli.getGrado()+1  ;  i++) {
                int j = i;
                if(j<poli2.getGrado()+1){
                    poli.setCoef(i,poli.getCoef(i)+poli2.getCoef(i));
                }  
            }
        }
        
        return poli; 
    }
    public Polinomio resta(Polinomio polinomio1, Polinomio polinomio2){
        this.poli = polinomio1;
        this.poli2 = polinomio2;
        negado(poli2);
        return suma(poli2, poli);
    }
    public Polinomio multiplicarPorFactor (Polinomio polinomio1,Polinomio polinomio2){
        this.poli = polinomio1;
        this.poli2 = polinomio2;
        int grado =poli.getGrado()+poli2.getGrado();
        Polinomio aux = new Polinomio(grado);
        
        if(poli.getGrado()<=poli2.getGrado()){
            
            for (int j = 0; j < poli.getGrado()+1; j++) {
                for (int i = 0; i < poli2.getGrado()+j+1; i++) { 
                    if (i-j>-1){
                        aux.setCoef(i, aux.getCoef(i)+poli2.getCoef(i-j)*poli.getCoef(j));
                    }   
                }
            }

       }else{
            for (int j = 0; j < poli2.getGrado()+1; j++) {
                for (int i = 0; i < poli.getGrado()+j+1; i++) { 
                    if (i-j>-1){
                        aux.setCoef(i, aux.getCoef(i)+poli.getCoef(i-j)*poli2.getCoef(j));
                    }   
                }
            }
       }
       return aux;
    }
   
    public static void main(String[] args) {
        double[] p1 = {-7,2,1} ;
        double[] p2 = {9,-3,5,6} ;
        Polinomio pol = new Polinomio(3,p2);
        Polinomio pol2 = new Polinomio(2,p1 );
        Operar_polinomio operar = new Operar_polinomio();
        System.out.println(operar.suma(pol, pol2));
    }
 
}
    
