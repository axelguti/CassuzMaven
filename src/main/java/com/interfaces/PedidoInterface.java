package com.interfaces;

import com.DTO.PedidosDTO;
import javafx.collections.ObservableList;

import java.util.List;

public interface PedidoInterface extends EntidadInterface<PedidosDTO> {
    public String modificarEstado(PedidosDTO p);
    public List<PedidosDTO> reportePedido();
    public List<PedidosDTO> reporteCircular();
    public ObservableList<PedidosDTO> getPedidos();
}
