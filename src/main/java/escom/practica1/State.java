/*Clase estado de un AFD*/
package escom.practica1;

//Importar paquete de ArrayList
import java.util.ArrayList;

//Descripcion de la clase Estado
public class State {
    
    /*ArrayList de transiciones
    Estructura: Transitions <[d1][d2][d3]...[dn]>
    */
    private ArrayList <Transition> Transitions;
    
    //Booleano que indica que es un estado final (Por defecto no lo sera)
    private boolean isFinal = false;
    
    //ID del estado
    private int ID;
    
    //Constructor de la clase estado
    public State(int i)
    {
        //Inicializar el ArrayList de transiciones (Estos se podran añadir con otra función)
        Transitions = new ArrayList();
        //Fijar ID
        ID = i;
    }
    
    //Añadir una transición
    public void addTransition(Transition d)
    {
        Transitions.add(d);
    }
    
    //Fijar que sea un estado final
    public void setAsFinal()
    {
        //Fijar estado final
        isFinal = true;
    }
    
    //Obtener ID del estado
    public int getID(){
        return ID;
    }
    
    //Obtener el ArrayList de estados
    public ArrayList <Transition> getTransitions()
    {
        return Transitions;
    }
    
    //Obtener el estado isFinal del estado
    public boolean getBooleanFinal(){
        return isFinal;
    }
    
    //[Debug] Imprimir estado
    public void print()
    {
        //Imprimir el estado
        System.out.println("\t\tESTADO: q("+ ID +")" );
        //Imprimir si es un estado final o no
        System.out.println("\t\tEstado final?: "+isFinal);
        //Imprimir transiciones
         System.out.println("\t\tTRANSICIONES: ");
         int id = 0; //Variable para contar
        for(Transition i:Transitions){
            System.out.println("\t\t\tTransicion: d("+id+")");
            i.print();
            id++;
        }
    }  
}