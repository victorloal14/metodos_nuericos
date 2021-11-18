package errores;

public class Error {
    public double errorPorcentual (double val_Anterior,double val_Actual){
        double error = Math.abs((val_Anterior - val_Actual)/val_Actual);
        return error;

    }
    public boolean n_DigitosIguales (double val_Anterior,double val_Actual,int n_digitos ){
        String val_2=""+val_Actual,val_1=""+val_Anterior;
    
        for(int i =0;i<n_digitos;i++ ){
            
            if (val_1.charAt(i) != val_2.charAt(i)){
                return false;
            }
        }
        return true;

    }
    
    
}
