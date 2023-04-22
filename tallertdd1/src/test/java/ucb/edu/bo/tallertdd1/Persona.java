package ucb.edu.bo.tallertdd1;

public class Persona {
    private final int MIN = 1;
    private final int MAX = 3;
    public int crearPersona(){
        int piso_persona = (int)Math.floor(Math.random()*(MAX-MIN+1)+MIN);
        return piso_persona;
    }
}
