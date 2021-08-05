package com.interfaces;


import com.DTO.PromotorDTO;

public interface PromotorInterface extends EntidadInterface<PromotorDTO>{
    public PromotorDTO buscar(Object id);
}
