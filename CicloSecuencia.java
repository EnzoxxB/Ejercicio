import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class CicloSecuencia {

    public static void main(String[] args) {
        long num1 = 2023, num2 = 2024, num3 = 2025, serie = 0;
        ArrayList<Long> valoresVistos = new ArrayList<>();
        Map<String, Integer> valoresMap = new HashMap<>();
        int[] posicionCiclo = {-1, -1}; // Para almacenar el inicio y fin del ciclo
        
        valoresVistos.add(num1);
        valoresVistos.add(num2);
        valoresVistos.add(num3);

        for (int i = 1; i < 200000; i++) {
            String key = num1 + "," + num2 + "," + num3;
            serie = (num1 + num2 + num3) % 10000;
            num1 = num2;
            num2 = num3;
            num3 = serie;

            valoresVistos.add(serie);

            

            if (valoresMap.containsKey(key)) {
                posicionCiclo[0] = valoresMap.get(key);
                posicionCiclo[1] = i;
                break;
            }

            valoresMap.put(key, i);
        }

        if (posicionCiclo[0] != -1) {
            int inicioCiclo = posicionCiclo[0];
            int finCiclo = posicionCiclo[1];
            int longitudCiclo = finCiclo - inicioCiclo;

            System.out.println("Se detectó un ciclo que inicia en " + inicioCiclo + " y termina en " + finCiclo + ".");
            System.out.println("La longitud del ciclo es " + longitudCiclo + ".");

            long posicionDeseada = (2023202320232023L - inicioCiclo) % longitudCiclo + inicioCiclo;
            System.out.println("El valor en la posición 2023202320232023 es: " + valoresVistos.get((int) posicionDeseada));

        } else {
            System.out.println("No se detectó un ciclo en el rango dado.");
        }
    }
}