/*Clase transición de un estado (Cada estado podra tener uno o mas transiciones)*/

package escom.practica1;

//Importar paquete de ArrayList, Arrays y list
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Descripcion de la clase Transicion
public class Transition {
    
    //Estado destino
    private State stateTarget;
    
    //Cadena que llevara al estado destino
    private ArrayList <String> stringPass;
    
    //Constructor de la clase transición
    public Transition(State q,String[] s)
    {
        //Fija la referencia al estado destino
        stateTarget = q;
        //Construye una Lista de cadenas temporal
        List <String> tempList = (List <String>) Arrays.asList(s);
        //Construye un ArrayList apartir de la lista temporal creada anteriormente
        stringPass = new ArrayList <String> (tempList);
        //Quitar referencia para eliminar
        tempList = null;
        
    }
    
    //Obtener Array List de cadena de pase
    public ArrayList <String> getStrings(){
        return stringPass;
    }
    
    //Obtener la transicion destino de una transicion
    public State getStateTarget(){
        return stateTarget;
    }
    
    //[DEBUG] Imprimir la transicion
    public void print(){
        //Imprimir estado
        
        //Imprimir las cadenas que ejecutan la transición
        System.out.print("\t\t\t\tSimbolos de cambio de estado: ");
        for(String i:stringPass){
            System.out.print(i+",");
        }
        System.out.println();
        //Imprimir el estado donde es destino
        System.out.println("\t\t\t\tEstado destino: q(" + stateTarget.getID()+")");
        
        
        
    }
    
}
