package controllers;

import java.util.List;
import java.util.Objects;
import models.Incidente;

public class IncidenteController {
    public List<Incidente> sort(List<Incidente> incidentes) {
        Objects.requireNonNull(incidentes, "La lista de incidentes no puede ser nula");
        incidentes.sort(null);
        return incidentes;
    }

    public int busquedaBinaria(List<Incidente> incidentes, Incidente objetivo) {
        Objects.requireNonNull(incidentes, "La lista de incidentes no puede ser nula");
        Objects.requireNonNull(objetivo, "El incidente objetivo no puede ser nulo");

        int izquierda = 0;
        int derecha = incidentes.size() - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            Incidente actual = incidentes.get(medio);
            int comparacion = actual.compareTo(objetivo);

            if (comparacion == 0) {
                return medio;
            } else if (comparacion < 0) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return -1;
    }
}
