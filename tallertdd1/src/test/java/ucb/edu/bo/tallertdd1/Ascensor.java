package ucb.edu.bo.tallertdd1;

public class Ascensor {
    public int pisoAscensor = 1;

    private final int MIN = 1;
    private final int MAX = 3;
    public boolean puertaCerrada = false;
    public void usarAscensor(int pisoSeleccionado,int pisoPersona)throws Exception{
        controlarPisoSeleccionadoDentroDeLosLimites(pisoSeleccionado);
        controlarPisoSeleccionadoDiferenteAPisoActual(pisoPersona,pisoSeleccionado);
        if(ascensorYPersonaEnMismoPiso(pisoPersona)){
            puertaCerrada = estadoPuerta(); //Se Abre la puerta
            //Ingresa la persona
            puertaCerrada = estadoPuerta(); //Se Cierra la puerta
            moverADestino(pisoSeleccionado);
        }else{
            llamarAscensor(pisoPersona);
            puertaCerrada = estadoPuerta(); //Se Abre la puerta
            //Ingresa la persona
            puertaCerrada = estadoPuerta(); //Se Cierra la puerta
            moverADestino(pisoSeleccionado);
        }
        puertaCerrada = estadoPuerta(); //Se Abre la puerta
        // Sale la persona
        puertaCerrada = estadoPuerta(); //Se Cierra la puerta
    }

    public void controlarPisoSeleccionadoDentroDeLosLimites(int pisoSeleccionado) throws Exception{
        if(pisoSeleccionado< MIN || pisoSeleccionado > MAX ){
            throw new Exception("Piso inexistente");
        }

    }
    public void controlarPisoSeleccionadoDiferenteAPisoActual(int pisoPersona ,int pisoSeleccionado)throws Exception{
        if(pisoSeleccionado == pisoPersona){
            throw new Exception("EL piso seleccionado es igual al piso actual");
        }
    }
    public void llamarAscensor(int pisoPersona){
        cambiarPiso(pisoPersona);
    }
    public void moverADestino(int pisoSeleccionado){
        cambiarPiso(pisoSeleccionado);
    }
    public boolean estadoPuerta(){

        if(puertaCerrada == true){
            return false;
        }
        return true;
    }

    public int cambiarPiso(int pisoDestino){

        if(pisoDestino == 1){
            pisoAscensor =1;
        }else if(pisoDestino == 2) {
            pisoAscensor =2;
        }else if(pisoDestino == 3){
            pisoAscensor =3;
        }


        return pisoAscensor;
    }
    public int getPiso(){
        return pisoAscensor;
    }


    public void iniciarAscensor(){
        pisoAscensor = 1;
        puertaCerrada = true;

    }

    public boolean ascensorYPersonaEnMismoPiso(int pisoPersona){
        if(pisoPersona==pisoAscensor){
            return true;
        }
        return false;
    }
    public boolean getPuertaCerrada(){
        return puertaCerrada;
    }
}
