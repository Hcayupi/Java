package src;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.logging.Logger;

public class Analisis{


    public static void main(String[] args){
        Logger mensajeConsola = Logger.getLogger("Analisis de texto");

        String respuesta = "";

        String[] arrayN = {"a","h","f","f","a","k","s","f","a","j","e","e","u","b","s","n","e"};
        String[] arrayK = {"j","e","f","a","a"};//a k s f a j e

        respuesta = analisiArray(arrayN, arrayK);
        mensajeConsola.info(respuesta);

        String[] arrayC = {"a","s","s","f","a","k","s","f","a","j","e","e","u","b","s","n","e"};
        String[] arrayD = {"u","j","s","f","a"};//s f a j e e u

        respuesta = analisiArray(arrayC, arrayD);
        mensajeConsola.info(respuesta);

        String[] arrayE = {"a","s","s","f","a","k","s","f","a","j","e","e","u","b","s","n","e"};
        String[] arrayF = {"e","u","s"}; // s f a j e e u

        respuesta = analisiArray(arrayE, arrayF);
        mensajeConsola.info(respuesta);

        String[] arrayX = {"a","s","s","f","a","k","s","f","a","j","e","e","u","b","s","n","e"};
        String[] arrayY = {"s","k","n"}; //k s f a j e e u b s n

        respuesta = analisiArray(arrayX, arrayY);
        mensajeConsola.info(respuesta);

    }

    private static String  analisiArray(String[] arrayN, String[] arrayK){
        
        LinkedHashMap<Integer,String> hashCoincidencias = new LinkedHashMap<Integer,String>(); 
        LinkedHashMap<Integer, String> hashAuxiliarCoincidencias = new LinkedHashMap<Integer, String>();
        LinkedHashMap<String,Integer> hashConteoPorCaracter = new LinkedHashMap<String,Integer>();
        LinkedHashMap<String,Integer> auxConteoPorCaracter = new LinkedHashMap<String,Integer>();
        int contadorCaracter=0;

        for(int i=0; i<arrayN.length; i++){
            contadorCaracter=0;
            for(int j=0; j<arrayK.length; j++){
                    if(arrayN[i].equals(arrayK[j])){
                            hashConteoPorCaracter.put(arrayK[j],++contadorCaracter);
                            hashCoincidencias.put(i,arrayN[i]);
                         
                    }
            }
        }
        hashAuxiliarCoincidencias = hashCoincidencias;
        auxConteoPorCaracter = new LinkedHashMap<>(hashConteoPorCaracter);
        ArrayList<Integer> arrayResultado = new ArrayList<Integer>();

        Integer repeticiones=0;
        Integer numeromaxcaracteres= arrayK.length;
        Boolean terminado=false;

        while(!terminado){

            for(Entry<Integer, String>   e:hashCoincidencias.entrySet()){
            
                repeticiones = auxConteoPorCaracter.get(e.getValue());
                if(numeromaxcaracteres ==0){
                    terminado = true;
                        break;
                }

                if(repeticiones>0){
                    numeromaxcaracteres -=1;
                    repeticiones-=1;
                    arrayResultado.add(e.getKey());
                    auxConteoPorCaracter.put(e.getValue(), repeticiones);
                    
                }else {
                
                    if(numeromaxcaracteres>0){
                        String primerElemento = hashCoincidencias.get(arrayResultado.get(0));
                        String elementoRepetido = e.getValue();

                        if(!primerElemento.equals(elementoRepetido)){
                                continue;                    
                        }
                    
                        hashAuxiliarCoincidencias.remove(arrayResultado.get(0));
                        auxConteoPorCaracter=new LinkedHashMap<>(hashConteoPorCaracter);
                        numeromaxcaracteres=arrayK.length;
                        arrayResultado.clear();
                        break;
                        
                    }
                }
                hashCoincidencias=hashAuxiliarCoincidencias;
            }//For
        }//While

        String cadenaResultante="";
        int desdeindice= arrayResultado.get(0);
        int hastaindice=arrayResultado.get(arrayResultado.size()-1);

        for(int i=desdeindice;i<=hastaindice;i++) {
            cadenaResultante+=arrayN[i]+" | ";
        } 
       
        return cadenaResultante;
    }
}