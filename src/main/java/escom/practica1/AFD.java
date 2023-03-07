/*Clase Automata Finito Determinista*/
package escom.practica1;

//Importar paquete de ArrayList
import java.util.ArrayList;
import java.util.Arrays;

//DescripciÓn de la clase AFD
public class AFD {
    
    //Alfabeto del automata
    private ArrayList <String> alphabet;
    
    /*Crear ArrayList de estados que compondran al AFD 
    Estructura: States< [q0][q1][q2]....[qn] > 
    */
    private ArrayList <State> States;
    
    //Referencia al estado inicial
    private State initialState;
    
    //Constructor de la clase AFD
    public AFD(String[] alfabeto)
    {
        //Inicializar ArrayList de estados (Estos se agregaran con otra función)
        States = new ArrayList();
        //Inicializar alfabeto (vacio)
        alphabet = new ArrayList();
    }
    
    //Función para fijar el estado inicial de un AFD
    public void setInitialState(State q0)
    {
        initialState = q0;
    }
    
    //Función para agregar un estado a un AFD (Se agregara vacío)
    public void addState(int id)
    {
        States.add(new State(id));
    }
    
    //Función para obtener el estado i-esimo del ArrayList de estados
    public State getState(int i)
    {
        return States.get(i);
    }
    
    //[DEBUG] Imprimir el AFD
    public void print()
    {
        //Imprimir el automata
        System.out.println("AUTOMATA:");
        //Imprimir estado inicial
        System.out.println("Estado inicial: q("+initialState.getID()+")\n\n\tESTADOS DEL AUTOMATA:\n");
        
        //Imprimir estados
        for(State i:States){
            i.print();
        }
        
    }
    
    //[DEBUG] Imprimir alfabeto
    public void printAlphabet(){
        System.out.println("Alfabeto: \n");
        for(String a:alphabet){
            System.out.println("a");
        }
        System.out.println();
    }
    
    //Chechar una cadena con el automata determinado
    public boolean checkString(String cad)
    {
        //Fijar el estado actual al estado incial del AFD
        State curState = initialState;
        
        //Bandera que verifica que se ha podido checar el simbolo
        boolean checked = false;
        
        System.out.println("INICIO DE PROCESO DE VERIFICACION");
        
        //Leer cada simbolo de la cadena
        for(int i=0;i<cad.length();i++){
            checked = false;
            System.out.println("\tEstado actual: (q"+curState.getID()+")");
            System.out.println("\tEs final?: ("+(curState.getBooleanFinal()?"si":"no")+")");
            System.out.println("\t\tLeyendo simbolo: '"+Character.toString(cad.charAt(i))+"'");
            //Leer las transiciones del estado actual
            for(int j=0;j<curState.getTransitions().size();j++){
                //Leer las cadenas de la transicion j-esima
                for(String k:curState.getTransitions().get(j).getStrings()){
                    //En caso de que cualquier simbolo de aceptacion de la transicion sea igual al simbolo de leido de la cadena, pasara al estado destino de la misma
                    if(k.equals(Character.toString(cad.charAt(i)))){
                        curState = curState.getTransitions().get(j).getStateTarget(); //Fijar el estado actual al estado destino de la transicion
                        checked = true; //Verificar que si logro checar el simbolo
                        break;
                    }
                  
                }
                             
            }
            
             //En caso de que llegue a esta parte y no haya logrado checar la cadena significa que el estado no tiene ningun transicion con el simbolo leido por lo que la cadena es inavalida por que siempre llevara a un estado muerto
             if(!checked){
                 System.out.println("No se econtro transicion para el simbolo, por lo tanto por defecto se ira a un estado muerto");
                 System.out.println("\nCadena invalida\n");
                 System.out.println("FIN DE PROCESO DE VERIFICACION");
                 return false;
             }
                
        }
        
        System.out.println("\tUltimo simbolo leido");
        System.out.println("\tEstado actual: (q"+curState.getID()+")");
        System.out.println("\tEs final?: ("+(curState.getBooleanFinal()?"si":"no")+")");
        
        if(curState.getBooleanFinal())
            System.out.println("\nCadena valida\n");
        else
            System.out.println("\nCadena invalida\n");
        
        System.out.println("FIN DE PROCESO DE VERIFICACION");
        
        //Si el estado actual al final de leer la cadena es un estado final, entonces la cadena sera valida y devolera true; si no, la cadena sera invalida y devolvera false 
         return curState.getBooleanFinal();
    }
    
    //Construir automata a apartir de archivo
    public void readFile(String filename){
        
        alphabet.add("a");
        
    }
    

}
