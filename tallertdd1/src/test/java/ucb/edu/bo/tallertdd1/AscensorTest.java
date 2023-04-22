package ucb.edu.bo.tallertdd1;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AscensorTest {
    private Ascensor ascensor;
    private Persona persona ;
    private int  pisoPersona;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void before(){
        ascensor = new Ascensor();
        persona = new Persona();//
    }
    @Test
    public void ascensorIniciaEnPiso1(){
        ascensor.iniciarAscensor();
        assertEquals(1,ascensor.getPiso());
    }
    @Test
    public void ascensorIniciaConLaPuertaCerrada(){
        ascensor.iniciarAscensor();
        assertEquals(true,ascensor.getPuertaCerrada());
    }
    @Test
    public void verificarLLamadaDeAscensor(){
        ascensor.llamarAscensor(2); //Lamando el ascensor al piso 2
        assertEquals(2,ascensor.getPiso());
    }
    @Test
    public void verificarQueElPisoSeleccionadoSeaValido() throws Exception{
        exception.expect(Exception.class);
        ascensor.usarAscensor(4,2);
        ascensor.usarAscensor(0,2);
    }
    @Test
    public void verificarQueElPisoSeleccionadoSeaDiferenteAlPisoActualDeLaPersona() throws Exception{
        exception.expect(Exception.class);
        ascensor.usarAscensor(1,1);
        ascensor.usarAscensor(2,2);
        ascensor.usarAscensor(3,3);
    }
    @Test
    public void verificarLLamadaDeAscensorDesdeElMismoPiso() throws Exception{
        ascensor.iniciarAscensor(); //Ascensor en el piso 1
        assertEquals(true,ascensor.ascensorYPersonaEnMismoPiso(1));
        ascensor.usarAscensor(2,1);//Moviendo el ascensor al piso 2
        assertEquals(true,ascensor.ascensorYPersonaEnMismoPiso(2));
    }

    @Test
    public void verificarLlegadaADestino() throws Exception{
        ascensor.moverADestino(3); //Ir al piso tres
        assertEquals(3,ascensor.getPiso());
    }
    @Test
    public void verificarPrimeraLLamadaDesdeUnPisoDiferente()  throws Exception{
        ascensor.iniciarAscensor();//Ascensor en el piso 1
        ascensor.usarAscensor(3,2); //Persona en el piso 2 seleccionando el piso 3
        assertEquals(false,ascensor.ascensorYPersonaEnMismoPiso(2)); //Ascensor llegando desde el piso 2 al piso 3
    }
    @Test
    public void ascensorTerminaRecorridoConLaPuertaCerrada()  throws Exception{
        ascensor.iniciarAscensor();//Ascensor en el piso 1 con la puerta cerrada
        ascensor.usarAscensor(3,1); //Persona en el piso 1 seleccionando el piso 3
        assertEquals(true,ascensor.getPuertaCerrada()); //Ascensor llegando al  el piso 3
        ascensor.usarAscensor(1,2); //Persona en el piso 2 seleccionando el piso 1
        assertEquals(true,ascensor.getPuertaCerrada()); //Ascensor llegando al  el piso 3
    }
    @Test
    public void ascensorTerminaRecorridoConEnElPisoSeleccionado()  throws Exception{
        ascensor.iniciarAscensor();//Ascensor en el piso 1 con la puerta cerrada
        ascensor.usarAscensor(3,1); //Persona en el piso 1 seleccionando el piso 3
        assertEquals(3,ascensor.getPiso()); //Ascensor en el piso 3
        ascensor.usarAscensor(2,3); //Persona y ascensor en el piso 3, persona selecciona el piso 2
        assertEquals(2,ascensor.getPiso()); //Ascensor en el  el piso 2
    }

    @Test
    public void probandoAscensorConPesonaAleatoria()  throws Exception{

        pisoPersona = persona.crearPersona();
        System.out.println("Piso persona "+pisoPersona);
        ascensor.iniciarAscensor();//Ascensor en el piso 1 con la puerta cerrada
        ascensor.usarAscensor(3,pisoPersona); //Persona en el piso 1 seleccionando el piso 1
        assertEquals(3,ascensor.getPiso()); //Ascensor en el piso 3

    }
}
