public class App {
    public static void main(String[] args) throws Exception {
        String cadenaPrueba="ana"; 

        Palindrome palindrome = new Palindrome(cadenaPrueba);

        System.out.println(generarEspacio());
 
        if(!palindrome.getCumpleLonguitud())

            System.err.println("\t  No cumple con una longuitud mínima de cadena ");

        else if(palindrome.esUnPalindrome(cadenaPrueba)){

            System.out.println("\t  Es un palindrome ");

        }else if(palindrome.esUnPalindrome(palindrome.analisisString())){

            System.out.println("\t  Es un palindrome ");
            System.out.println("\t  Caracteres extraídos: " + palindrome.getCaracteresDistintos());
            
        }else{
            System.out.println("\t No es posible concluir que sea un palindrome");
            }
        System.out.println(generarEspacio());
    }

    private static  String generarEspacio(){
        return 
        "\n\n"
        +" -------------------------------------------------------------------"+
        "\n\n";
    }   

}

