package com.interfaces;

import com.DTO.PedidosDTO;
import javafx.collections.ObservableList;

import java.util.List;

public interface PedidoInterface extends EntidadInterface<PedidosDTO> {
    public String modificarEstado(PedidosDTO p);
    public List<PedidosDTO> reporteFecha();
    public ObservableList<PedidosDTO> getPedidos();
    public List<PedidosDTO> reportePromotor();
    public List<PedidosDTO> reporteMes();
}
