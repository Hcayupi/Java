import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Analisis{


    public static void main(String[] args){
        String[] arrayN = {"a","h","f","f","a","k","s","f","a","j","e","e","u","b","s","n","e"};
        String[] arrayK = {"j","e","f","a","a"};

        System.out.println(analisiArray(arrayN, arrayK));

    }

    private static String  analisiArray(String[] arrayN, String[] arrayK){
        
        LinkedHashMap<Integer,String> hashHallazgos = new LinkedHashMap<Integer,String>();
        LinkedHashMap<Integer, String> hashCheck = new LinkedHashMap<Integer, String>();
        LinkedHashMap<String,Integer> hashKRepeticiones = new LinkedHashMap<String,Integer>();
        LinkedHashMap<String,Integer> auxiliarRepeticiones = new LinkedHashMap<String,Integer>();
        int contadorCoincidencia=0;

        for(int i=0; i<arrayN.length; i++){
           contadorCoincidencia=0;
            for(int j=0; j<arrayK.length; j++){
                    if(arrayN[i].equals(arrayK[j])){
                            hashKRepeticiones.put(arrayK[j],++contadorCoincidencia);
                            hashHallazgos.put(i,arrayN[i]);
                         
                    }
            }
        }
        hashCheck = hashHallazgos;
        auxiliarRepeticiones = new LinkedHashMap<>(hashKRepeticiones);
        ArrayList<Integer> arrayHallazgos = new ArrayList<Integer>();

        Integer repeticiones=0;
        Integer contador = arrayK.length;
        Boolean terminado=false;

        while(terminado == false){
        System.out.println("0.-----------------------Inicio--------------------------------------");

        for(Entry<Integer, String>   e:hashHallazgos.entrySet()){
            System.out.println("1.- Este es el registro de repeticiones: " + auxiliarRepeticiones);
            System.out.println("2.- Se analiza el caracter: "+ e.getValue());
            repeticiones = auxiliarRepeticiones.get(e.getValue());
            if(contador ==0){
                terminado = true;
                    break;
            }

            System.out.println("3.- REPETICIONES:   " + repeticiones + "    CONTADOR:   " + contador);
            if(repeticiones>0){
                contador -=1;
                System.out.println("1 IF- 1.- Contador de caracteres encontrados: "+contador);
                repeticiones-=1;
                arrayHallazgos.add(e.getKey());
                auxiliarRepeticiones.put(e.getValue(), repeticiones);
                System.out.println("1 IF- 2.- Repeticiones después de primer if: " + auxiliarRepeticiones);
            }else {
                System.out.println("2 IF ELSE- 1.- Se produjo un if ELSE");
                if(contador>0){
                    
                    System.out.println("2 IF ELSE- 2.- Es es el HashCheck antes de sufrir una modificación: " + hashCheck);
                    System.out.println("2 IF ELSE- 3.- Este es el actual Array Hallazgo: " + arrayHallazgos);
                    for(Integer o:arrayHallazgos){
                        //Integer auxrepeticiones = auxiliarRepeticiones.get(hashCheck.get(o));
                       
                       // if(auxrepeticiones==0){
                            System.out.println("2 IF ELSE- FOR 1.- Indice a eliminar: "+ o);
                            hashCheck.remove(o);
                       // }
                        break;
                    }
                    System.out.println("2 IF ELSE- 3.- Historial de repeticiones de HashMap: "+hashKRepeticiones);
                    auxiliarRepeticiones=new LinkedHashMap<>(hashKRepeticiones);
                    System.out.println("2 IF ELSE- 4.- Historial de repeticiones reestablecido: "+auxiliarRepeticiones);
                    contador=arrayK.length;
                    arrayHallazgos.clear();
                    System.out.print("2 IF ELSE- 5.- Se remueve de hashCheck: \n\n");
                    System.out.println("2 IF ELSE- 6.- Este es el HashCheck despues de sufrir la modificación: " + hashCheck);
                    break;
                    
                }
            }

             hashHallazgos=hashCheck;
        }

        System.out.println("0----------------------------- FINAL --------------------------------------");
        } 
        
        String cadenaResultante="";
        for(int i=arrayHallazgos.get(0);i<=arrayHallazgos.get(arrayHallazgos.size()-1);i++) {
            cadenaResultante+=arrayN[i]+" | ";
        } 
       
        return cadenaResultante;
    }
}