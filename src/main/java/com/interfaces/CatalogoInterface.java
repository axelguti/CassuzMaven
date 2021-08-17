package com.interfaces;


import com.DTO.CatalogoDTO;

import java.util.List;

public interface CatalogoInterface extends EntidadInterface<CatalogoDTO> {
    public List<CatalogoDTO> listarCatalogos();
}
