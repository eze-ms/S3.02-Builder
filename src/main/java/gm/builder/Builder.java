package gm.builder;

import gm.model.Pizza;
import java.util.List;

public interface Builder {
    Builder setTamaño(String tamaño);
    Builder setMasa(String masa);
    Builder agregarIngredientes(List<String> ingredientes);
    Pizza construir();
}
