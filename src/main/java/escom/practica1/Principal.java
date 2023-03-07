
package escom.practica1;

public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Alfabeto
        String[] alphabet = new String[]{"a","b"};
        
        //Crear AFD
        AFD auto1 = new AFD(alphabet);
        
       //Añadir las transiciones del AFD de numeros reales
      for(int i=0;i<3;i++)
          auto1.addState(i);
      
      //Fijar el estado inicial del (el cual sera q0)
      auto1.setInitialState(auto1.getState(0));
      
       //Fijar estados finales del AFD (el cual sera q1)
      auto1.getState(1).setAsFinal();
      
      //Añadir transiciones a lo estados del AFD
      auto1.getState(0).addTransition(new Transition(auto1.getState(1),new String[]{"a"}));
      auto1.getState(0).addTransition(new Transition(auto1.getState(2),new String[]{"b"}));
      auto1.getState(1).addTransition(new Transition(auto1.getState(1),alphabet));
      auto1.getState(2).addTransition(new Transition(auto1.getState(2),alphabet));
      
      //Imprimir alfabeto
      auto1.printAlphabet();
      
      auto1.checkString("babababababa");

    }
    
}
