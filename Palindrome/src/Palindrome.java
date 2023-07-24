
public class Palindrome {

    private String textoOriginal="";
    private String textoInvertida="";
    private String caracteresDistintos="";
    private Boolean cumpleLonguitud= true;

    public Palindrome(String cadena) {
        if(cadena.length()<3){
            this.cumpleLonguitud = false;
        }
    }

    public Boolean getCumpleLonguitud(){
        return this.cumpleLonguitud;
    }

    public Boolean esUnPalindrome(String cadenaOriginal){

        String cadenaInvertida = "";
        for(int i=cadenaOriginal.length()-1; i>=0; i--){
            cadenaInvertida += cadenaOriginal.charAt(i);
        }
        this.textoOriginal = cadenaOriginal;
        this.textoInvertida = cadenaInvertida;
        
        if(cadenaOriginal.equalsIgnoreCase(cadenaInvertida)){
            return true;
        }
        System.out.println(">> Original: " +  this.textoOriginal);
        System.out.println(">> Invertido: " + this.textoInvertida);
        return false;
    }

    public String analisisString(){
        for(int i=textoOriginal.length()-1; i>=0;i--){
            for(int j=i; j>=0;j--){
                if(textoOriginal.charAt(i) != textoInvertida.charAt(j)&& caracteresDistintos.length()<2){
                        caracteresDistintos += textoInvertida.charAt(j);
                }else  break;
            }
        }
        System.out.println(">> Se extrajo:  " + caracteresDistintos);

        return textoOriginal.replace(caracteresDistintos,"");
    }
    
    public String getCaracteresDistintos(){
            return this.caracteresDistintos;
    }
}
