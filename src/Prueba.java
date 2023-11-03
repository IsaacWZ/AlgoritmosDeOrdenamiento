import java.util.Timer;

public class Prueba {

    public String tiempo;

    private int milisegundos;
    private int segundos;
    private int minutos;


    public void inicia_tiempo() throws InterruptedException {
        for(minutos = 0; minutos < 60 ; minutos++){
            for(segundos = 0; segundos < 60 ; segundos++){
                for(milisegundos = 0; milisegundos < 1000 ; milisegundos++){
                    tiempo = minutos+":"+segundos+":"+milisegundos;
                    Thread.sleep(1);
                }
            }
        }
    }


}
