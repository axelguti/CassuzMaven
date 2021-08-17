package com.interfaces;

import com.DTO.CajaDTO;

import java.util.List;

public interface CajaInterface extends EntidadInterface<CajaDTO>{
    public List<CajaDTO> listacaja();
    public List<CajaDTO> litacajaMontoTotal();
}
