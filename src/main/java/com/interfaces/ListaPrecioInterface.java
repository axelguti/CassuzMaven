package com.interfaces;


import com.DTO.ListaPreciosDTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface ListaPrecioInterface extends EntidadInterface<ListaPreciosDTO> {
    public String Importar(File file) throws IOException;
}
