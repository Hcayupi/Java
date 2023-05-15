

public class CombinaParentesis {

   public static void main(String[] args) {
       System.out.println(numeroCatalan(5));
    }
    
    private static int numeroCatalan(int num_parentesis) {
        int numeroCatalan = factorizar(2*num_parentesis)/(factorizar(num_parentesis+1)*factorizar(num_parentesis));
        return numeroCatalan;
    }

    private static Integer factorizar(Integer numero){
        Integer factorial = 1;

            for(int i=numero; i>0;i--){
                factorial = factorial * i;
            }
        return factorial;
    }

    
}
