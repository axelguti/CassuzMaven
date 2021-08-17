package com.interfaces;

import com.DTO.PedidosDTO;

import java.util.List;

public interface PedidoInterface extends EntidadInterface<PedidosDTO> {
    public String modificarEstado(PedidosDTO p);
    public List<PedidosDTO> reportePedido();
    public List<PedidosDTO> reporteCircular();
}
