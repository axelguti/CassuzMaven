package com.controladores;


import com.DAOFactory.DAOFactory;
import com.DTO.*;
import com.Reportes.PromotorGanancia;
import com.Util.Estado;
import com.beans.IconTest;
import com.interfaces.*;

import com.jfoenix.controls.JFXToggleButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Window;


import javax.swing.*;
import java.awt.*;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class ControllerPrincipal extends Component implements Initializable {

    @FXML
    private CategoryAxis bcXMes;
    @FXML
    private NumberAxis bcYMonto;
    @FXML
    private BarChart<String,Double> bcReporteBar;
    @FXML
    private PieChart pcReporteGananciaMes;
    @FXML
    private TableColumn<CajaDTO,String> tcMontoTotalCaja;
    private  ComboBox<String> cmbestadopedido;
    @FXML
    private TableColumn<CajaDTO,String> tcFechaCajaDelDia;
    @FXML
    private TableColumn<CajaDTO,String> tcFechaCajaPorDia;
    @FXML
    private Label lblCajaID;
    @FXML
    private TableView<CajaDTO> tblDatosCajaPorDia;
    @FXML
    private TableColumn<CajaDTO,String> tcPedidoMontoTotalCaja;
    @FXML
    private TableColumn<CajaDTO,String> tcPedidodiaCaja;
    @FXML
    private TableColumn<CajaDTO,String> tcPedidoIDCajaDia;
    @FXML
    private TextField txtMontoCaja;
    @FXML
    private Button btnLimpiarCaja;
    @FXML
    private TableView<CajaDTO> tblDatosCajaDelDia;
    @FXML
    private TableColumn<CajaDTO,String > tcPedidoIDCaja;
    @FXML
    private TableColumn<CajaDTO, String> tcPedidoDescripcionCaja;
    @FXML
    private TableColumn<CajaDTO,String> tcPedidoMontoCaja;
    @FXML
    private TableColumn<CajaDTO,String> tcPedidosHoraCaja;
    @FXML
    private TextArea taDescripcion;

    private ObservableList<String> cmbfiltrarReportes1;
    @FXML
    private ComboBox<String> cmbBuscarEstadoPedido;
    @FXML
    private TextField txtBEstadoPedido;
    @FXML
    private TableColumn<PedidosDTO,String> tcTipoPago;
    @FXML
    private TableColumn<PedidosDTO,String> tcBanco;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidoEstadoID;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidoEstadoDni;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidoEstadoNombres;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidosEstadoCatalogo;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidosEstadoCodigo;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidosEstadoMarca;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidosEstadoColor;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidosEstadoPrecio;
    @FXML
    private TableColumn<PedidosDTO, String> tcFechaEstadoPedido;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidosEstado;
    @FXML
    private TableView<PedidosDTO> tblDatosEstado;
    @FXML
    private TextField txtBCaja;
    @FXML
    private Button btnAgregarCaja;
    @FXML
    private Button btnModificarCaja;
    @FXML
    private Button btnEliminarCaja;
    @FXML
    private ComboBox cmbBuscarCaja;
    @FXML
    private Label lblCaja;
    @FXML
    private TextField txtBancoPromotor;
    @FXML
    private ComboBox<String> cmbTipoPago;
    @FXML
    private JFXToggleButton estado;
    @FXML
    private TableColumn<CatalogoDTO,Button> tcEstadoCatalogo;
    @FXML
    private ComboBox<String> cmbBuscarPedido;
    @FXML
    private ComboBox<String> cmbReporte;
    @FXML
    private Label lblIdpedido;
    @FXML
    private Button btnImportar;
    @FXML
    private TextField txtBProductos;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidoPagina;
    @FXML
    private Button btnMostrarPedidos;
    @FXML
    private TableColumn<PedidosDTO,String> tcPedidosTalla;
    @FXML
    private TextField txtNombrePromotorPedido;
    @FXML
    private TextField txtApellidoPromotorPedido;
    @FXML
    private ComboBox<String> cmbPromotorPedido;
    @FXML
    private TextField txtPMarca;
    @FXML
    private TextField txtBPedidos;
    @FXML
    private DatePicker dpFechaNacimiento;
    @FXML
    private TableColumn<CatalogoDTO,String> tcFechaIngresoCatalogo;
    @FXML
    private DatePicker dpFechaIngreso;
    @FXML
    private TableColumn<PedidosDTO, String> tcFechaPedido;
    @FXML
    private TableView<PedidosDTO> tblDatosPedidos;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidoID;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidoDni;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidoNombres;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidosApellido;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidosCatalogo;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidosCodigo;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidosMarca;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidosColor;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidosPrecio;
    @FXML
    private Button btnModificarProductos;
    @FXML
    private TextField txtPTalla;
    @FXML
    private TextField txtPCodigo;
    @FXML
    private TextField txtPColor;
    @FXML
    private ComboBox<String> cmbCatalogosP;
    @FXML
    private TextField txtPPrecio;
    @FXML
    private TextField txtPPagina;
    @FXML
    private ComboBox<String> cmbBuscarUsuarios;
    @FXML
    private ComboBox<String> cmbRol;
    @FXML
    private TextField txtIdCatalogo;
    @FXML
    private TextField txtUApellido;
    @FXML
    private TextField txtUUsuario;
    @FXML
    private TextField txtUTelefono;
    @FXML
    private PasswordField txtUContraseña;
    @FXML
    private PasswordField txtURepiteContraseña;
    @FXML
    private TextField txtUBuscar;
    @FXML
    private TableColumn<UsuarioDTO, String> tcUNombre;
    @FXML
    private TableColumn<UsuarioDTO, String> tcUApellido;
    @FXML
    private TableColumn<UsuarioDTO, String> tcUTelefono;
    @FXML
    private TableColumn<UsuarioDTO, String> tcUUsuario;
    @FXML
    private TableColumn<UsuarioDTO, String> tcUContraseña;
    @FXML
    private TableColumn<UsuarioDTO, String> tcURol;
    @FXML
    private TableView<UsuarioDTO> tblUDatos;
    @FXML
    private TextField txtCTelefono;
    @FXML
    private TextField txtRepresentante;
    @FXML
    private TableColumn<CatalogoDTO, String> tcCTelefono;
    @FXML
    private TableColumn<CatalogoDTO, String> tcRepresentante;
    @FXML
    private TableColumn<CatalogoDTO, String> tcCatalogo;
    @FXML
    private TableColumn<CatalogoDTO, Integer> tcNumero;
    @FXML
    private TableView<CatalogoDTO> tblDatosCatalogo;
    @FXML
    private TextField txtCBuscar;
    @FXML
    private TextField txtCatalogo;
    @FXML
    private TextField txtUNombre;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtDni;
    @FXML
    private TextField txtRecomendado;
    @FXML
    private TextField txtBuscar;
    @FXML
    private TableColumn<PromotorDTO, String> tcNombres;
    @FXML
    private TableColumn<PromotorDTO, String> tcApellidos;
    @FXML
    private TableColumn<PromotorDTO, String> tcDireccion;
    @FXML
    private TableColumn<PromotorDTO, String> tcTelefono;
    @FXML
    private TableColumn<PromotorDTO, String> tcCorreo;
    @FXML
    private TableColumn<PromotorDTO, String> tcRecomendado;
    @FXML
    private TableColumn<PromotorDTO, LocalDate> tcFecha;
    @FXML
    private TableColumn<PromotorDTO, String> tcDni;
    @FXML
    private TableView<PromotorDTO> tblDatos;

    private ObservableList<PromotorDTO> lista;

    private ObservableList<CatalogoDTO> listaCatalogoDTOS;

    private ObservableList<UsuarioDTO> listaUsuarioDTO;

    private ObservableList<String> listaRol;

    private ObservableList<String> cmbcata;

    private ObservableList<String> cmbPromotor;
    @FXML
    private ObservableList<String> tipopago;
    @FXML
    private ObservableList<String> listaEstado;
    @FXML
    private ObservableList<String> listaBuscarUsuario;
    @FXML
    private ObservableList<String> listaBuscarPedidos;
    @FXML
    private ObservableList<PedidosDTO> listaPedidos;

    private ObservableList<CajaDTO> listaCajaDTO;
    @FXML
    private final CatalogoInterface daoCatalogo = DAOFactory.getCatalogoDAO();
    @FXML
    private final PromotorInterface dao = DAOFactory.getPromotorDAO();
    @FXML
    private final UsuarioInterface usr = DAOFactory.getUsuarioDAO();
    @FXML
    private final RolInterface rol = DAOFactory.getRolDAO();
    @FXML
    private final ListaPrecioInterface listaPre = DAOFactory.getListaPrecioDAO();
    @FXML
    private final PedidoInterface pedido = DAOFactory.getPedidoDAO();
    private ObservableList<String> espedidos;
    @FXML
    private ComboBox<String> estadoPedido;
    private DataInterface cargaDatas=DAOFactory.getCargaDatosDAO();
    private final CajaInterface caja=DAOFactory.getCajaDAO();
    @FXML
    private FileChooser filechooser;

    private TableCell<PedidosDTO, String> cell;



        @Override
    public void initialize(URL url, ResourceBundle rb) {
        MostrarLista();
        MostrarListaCatalogo();
        mostrarUsuario();
        buscarPedidos();
        listaRol();
        listaBuscarUsuario();
        mostrarPedidos();
        Importar();
        listaTipoPago();
        toggleButton();
        mostrarlistaEstado();
        listaEstado();
        mostrarCaja();
        sumaTotalCaja();
        cargardatos();
        sumatotalCajaPorDia();
        createBarChart();
        validarToggleButton();
        litadoReportes();
    }

    private String calcularFormatoFecha(){
        LocalDateTime hora=LocalDateTime.now();
        Month mes=hora.getMonth();
        String fech=String.valueOf(mes);
        String fech2=fech.substring(0,3);

        return String.format("%d %s %d", LocalDateTime.now().getDayOfMonth(), fech2, LocalDateTime.now().getYear());
    }

    private void sumaTotalCaja(){
        List<CajaDTO> listar=caja.listar();

        String fecha=calcularFormatoFecha();
        Predicate<CajaDTO> pred=a->a.getFecha().equalsIgnoreCase(fecha);
        double sumacaja;
        sumacaja=listar.stream().filter(pred).mapToDouble(CajaDTO::getMonto).sum();
        lblCaja.setText(String.valueOf(sumacaja));
    }

    private void sumatotalCajaPorDia(){
        List<CajaDTO> listar=caja.litacajaMontoTotal();
        listaCajaDTO=FXCollections.observableArrayList();
        tcFechaCajaPorDia.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        tcMontoTotalCaja.setCellValueFactory(new PropertyValueFactory<>("monto"));
        listar.forEach(a->listaCajaDTO.addAll(a));
        tblDatosCajaPorDia.setItems(listaCajaDTO);
    }

    private void mostrarlistaEstado(){
        List<PedidosDTO> listar = pedido.listar();
        listaPedidos = FXCollections.observableArrayList();
        espedidos=FXCollections.observableArrayList("Proceso","En Almacen","Entregado");
        tcPedidoEstadoID.setCellValueFactory(new PropertyValueFactory<>("idPedido"));
        tcPedidoEstadoDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        tcPedidoEstadoNombres.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcPedidosEstadoCatalogo.setCellValueFactory(new PropertyValueFactory<>("nomCatalogo"));
        tcPedidosEstadoCodigo.setCellValueFactory(new PropertyValueFactory<>("codProducto"));
        tcPedidosEstadoMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        tcPedidosEstadoColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        tcPedidosTalla.setCellValueFactory(new PropertyValueFactory<>("talla"));
        tcPedidosEstadoPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tcFechaEstadoPedido.setCellValueFactory(new PropertyValueFactory<>("fechaPedido"));
        tcTipoPago.setCellValueFactory(new PropertyValueFactory<>("tipopago"));
        tcBanco.setCellValueFactory(new PropertyValueFactory<>("banco"));
        tcPedidosEstado.setCellFactory((col)->{
            TableCell<PedidosDTO, String> cell = new TableCell<PedidosDTO, String>(){
                ComboBox<String> cmb=new ComboBox<String>(espedidos);
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    // Texto de visualización del botón

                    // Establecer el color del botón
                    cmb.setStyle("-fx-background-color: #00bcff;-fx-text-fill: #ffffff");
                    // Evento de clic de botón


                    if (empty) {
                        // Si esta columna está vacía, no se agregará ningún elemento por defecto
                        setText(null);
                        setGraphic(null);
                    } else {
                        cmb.setOnAction((col) -> {
                            // Obtener la posición en la lista y luego obtener los datos de información correspondientes a la lista
                            PedidosDTO p = listar.get(getIndex());
                            p.setEs(cmb.getValue());
                            p.setIdPedido(p.getIdPedido());
                            pedido.modificarEstado(p);
                        });
                        for (PedidosDTO p:listar){
                            switch (p.getEs()){
                                case "Proceso":{
                                    cmb.getSelectionModel().select("Proceso");
                                }break;
                                case "En Almacen":{
                                    cmb.getSelectionModel().select("En Almacen");
                                }break;
                                case "Entregado":{
                                    cmb.getSelectionModel().select("Entregado");
                                }
                            }
                        }
                        // Botón de carga
                        this.setGraphic(cmb);
                    }
                }
            };
            return cell;
        });
        tblDatosEstado.getItems().addAll(listaPedidos);
        cargardatos();
    }


    private void validarToggleButton(){
        ObservableList<CatalogoDTO> datos=FXCollections.observableArrayList();
        List<CatalogoDTO> listar=daoCatalogo.listar();
        for(CatalogoDTO c:listar){
            estado=new JFXToggleButton();
            datos.addAll(new CatalogoDTO(c.getId(),c.getNombre(),c.getRepresentante(),
                    c.getTelefono(),estado));
            if(c.getEstado().equalsIgnoreCase(String.valueOf(Estado.HABILITADO))){
                estado.setSelected(true);
            }else{
                estado.setSelected(false);
            }
        }
        tblDatosCatalogo.setItems(datos);

    }
    private void cargardatos(){
        ObservableList<PedidosDTO> datos=FXCollections.observableArrayList();

        List<PedidosDTO> listar=pedido.listar();
        for(PedidosDTO p:listar){
            estadoPedido=new ComboBox<>(espedidos);
            datos.addAll(new PedidosDTO(p.getDni(),p.getNombre(),p.getApellido(),p.getIdPedido(),p.getFechaPedido(),p.getNomCatalogo(),
                    p.getPagina(),p.getMarca(),p.getColor(),p.getPrecio(),p.getTalla(),p.getCodProducto(),p.getTipopago(),p.getBanco()));
            System.out.println(p.getEs());
        }


        tblDatosEstado.setItems(datos);
    }

    //Lista de roles
    private void listaRol() {
        List<RolDTO> listar = rol.listar();
        listaRol = FXCollections.observableArrayList();
        listar.forEach(a -> listaRol.addAll(a.getNomrol()));
        cmbRol.setItems(listaRol);
    }

    private void listaEstado(){
        listaEstado=FXCollections.observableArrayList("DNI","Catalogo","Fecha");
        cmbBuscarEstadoPedido.setItems(listaEstado);
    }
    private void listaTipoPago(){
        tipopago=FXCollections.observableArrayList("Transferencia","Efectivo");
        cmbTipoPago.setItems(tipopago);

    }

    //Busca a los usuarios
    private void listaBuscarUsuario() {
        listaBuscarUsuario = FXCollections.observableArrayList("Nombre", "Apellidos", "Usuario");
        cmbBuscarUsuarios.setItems(listaBuscarUsuario);
    }

    //Muestra en la tabla la lista de promotor
    private void MostrarLista() {
        List<PromotorDTO> listar = dao.listar();
        lista = FXCollections.observableArrayList();
        tcDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        tcNombres.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcApellidos.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tcDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tcTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tcCorreo.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        tcRecomendado.setCellValueFactory(new PropertyValueFactory<>("recomendado"));
        tcFecha.setCellValueFactory(new PropertyValueFactory<>("fechaInscripcion"));
        listar.forEach(a -> lista.addAll(a));
        tblDatos.setItems(lista);
    }

    //muestra en la tabla la lista de los catalogos
    private void MostrarListaCatalogo() {
        List<CatalogoDTO> listar = daoCatalogo.listar();
        listaCatalogoDTOS = FXCollections.observableArrayList();
        tcNumero.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcCatalogo.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcRepresentante.setCellValueFactory(new PropertyValueFactory<>("representante"));
        tcCTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tcEstadoCatalogo.setCellValueFactory(new PropertyValueFactory<>("buton"));
        listar.forEach(a -> listaCatalogoDTOS.addAll(a));
        tblDatosCatalogo.setItems(listaCatalogoDTOS);
    }

    //Muestra en la tabla la lista de usuarios
    public void mostrarUsuario() {
        List<UsuarioDTO> listar = usr.listar();
        listaUsuarioDTO = FXCollections.observableArrayList();
        tcUNombre.setCellValueFactory(new PropertyValueFactory<>("nomUsuario"));
        tcUApellido.setCellValueFactory(new PropertyValueFactory<>("apeUsuario"));
        tcUTelefono.setCellValueFactory(new PropertyValueFactory<>("telefUsuario"));
        tcUUsuario.setCellValueFactory(new PropertyValueFactory<>("usuarioUsuario"));
        tcUContraseña.setCellValueFactory(new PropertyValueFactory<>("contraUsuario"));
        tcURol.setCellValueFactory(new PropertyValueFactory<>("rolUsuario"));
        listar.forEach(a -> listaUsuarioDTO.addAll(a));
        tblUDatos.setItems(listaUsuarioDTO);
    }

    @FXML
    //Mostrar Datos de la tabla
    private void Mostrar(ActionEvent event) {
        MostrarLista();
    }

    //Registra al promotor
    @FXML
    private void Registrar(ActionEvent event) {
        PromotorDTO p=IngresarDatos();
        if (txtDni.getText().isEmpty() || txtNombres.getText().isEmpty() ||
                txtApellidos.getText().isEmpty() || txtDireccion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error. Datos Vacios", "Error", 1);
        } else {
            if (txtDni.equals(p.getDni())){
                JOptionPane.showMessageDialog(null, dao.grabar(p), "Registrar", 1);
                vaciarTexto();
            }else{
                JOptionPane.showMessageDialog(null, dao.grabar(p), "Registrar", 1);
                vaciarTexto();
            }
        }
        MostrarLista();
    }

    //limpia las cajas de texto del promotor
    private void vaciarTexto() {
        txtDni.setText("");
        txtTelefono.setText("");
        txtRecomendado.setText("");
        txtDireccion.setText("");
        txtApellidos.setText("");
        txtNombres.setText("");
    }

    //Ingresa datos del promotor
    private PromotorDTO IngresarDatos() {
        LocalDate fechaNacimiento=dpFechaNacimiento.getValue();
        PromotorDTO p = new PromotorDTO(txtDni.getText(),
                txtNombres.getText(),
                txtApellidos.getText(),
                txtDireccion.getText(),
                txtTelefono.getText(),
                fechaNacimiento,
                txtRecomendado.getText(),
                LocalDate.now());
        return p;
    }

    //Elimina datos del promotor
    @FXML
    private void Eliminar(ActionEvent event) {
        String id = txtDni.getText();
        dao.eliminar(id);
        vaciarTexto();
        MostrarLista();
    }

    //Modificar datos del promotor
    @FXML
    private void Modificar(ActionEvent event) {
        PromotorDTO p = IngresarDatos();
        if (txtDni.getText().isEmpty() || txtNombres.getText().isEmpty() ||
                txtApellidos.getText().isEmpty() || txtDireccion.getText().isEmpty() ||
                txtRecomendado.getText().isEmpty() || txtTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error. Datos Vacios", "Error", 1);
        } else {
            int i = JOptionPane.showOptionDialog(null, "Seguro que desea modificar el registro", "Modificar",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if (i == 0) {
                JOptionPane.showMessageDialog(null,dao.modificar(p),"Modificado",1);
            }
        }
        vaciarTexto();
        MostrarLista();
    }


    //Mandar datos de la tabla a las cajas de texto
    @FXML
    private void datos(MouseEvent mouseEvent) {
        PromotorDTO promotorDTO = tblDatos.getSelectionModel().getSelectedItem();
        if (promotorDTO == null) {
            MostrarLista();
        } else {
            txtDni.setText(promotorDTO.getDni());
            txtNombres.setText(promotorDTO.getNombre());
            txtApellidos.setText(promotorDTO.getApellido());
            txtDireccion.setText(promotorDTO.getDireccion());
            txtTelefono.setText(promotorDTO.getTelefono());
            dpFechaNacimiento.getEditor().setText(String.valueOf(promotorDTO.getFechaNacimiento()));
            txtRecomendado.setText(promotorDTO.getRecomendado());
        }
    }

    //Busca al promotor
    @FXML
    void buscar(MouseEvent mouseEvent) {
        FilteredList<PromotorDTO> filtrar = new FilteredList<>(lista, b -> true);
        txtBuscar.textProperty().addListener((ObservableList, oldValue, newValue) -> {
            filtrar.setPredicate(promotorDTO -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                //Filtrar Por DNI del Promotor
                return promotorDTO.getDni().toLowerCase().contains(lowerCaseFilter);
            });
        });
        SortedList<PromotorDTO> sorted = new SortedList<>(filtrar);
        sorted.comparatorProperty().bind(tblDatos.comparatorProperty());
        tblDatos.setItems(sorted);
    }

    @FXML
    private void Limpiar(ActionEvent actionEvent) {
        vaciarTexto();
    }

    //Registra al usuario
    @FXML
    private void RegistrarUsuario(ActionEvent actionEvent) {
        UsuarioDTO u = DatosUsuario();
        if (txtUUsuario.getText().isEmpty() || txtUApellido.getText().isEmpty()
                || txtUNombre.getText().isEmpty() || txtUTelefono.getText().isEmpty() ||
                txtUContraseña.getText().isEmpty() || txtURepiteContraseña.getText().isEmpty()) {

            Error();

        } else {

            if (txtUUsuario.equals(u.getUsuarioUsuario())) {
                usr.grabar(u);
            } else {
                usr.grabar(u);
                JOptionPane.showMessageDialog(null, "Registro guardado", "Registro", 1);
            }
        }
        limpiarUsuario();
        mostrarUsuario();
    }

    //Ingresa datos de usuario
    private UsuarioDTO DatosUsuario() {
        UsuarioDTO u = new UsuarioDTO(txtUUsuario.getText(), txtUContraseña.getText());
        u.setNomUsuario(txtUNombre.getText());
        u.setApeUsuario(txtUApellido.getText());
        u.setTelefUsuario(txtUTelefono.getText());
        u.setRolUsuario(cmbRol.getValue());
        return u;
    }

    //Modifica datos al usuario
    @FXML
    private void ModificarUsuario(ActionEvent actionEvent) {
        UsuarioDTO u = DatosUsuario();
        if (txtUNombre.getText().isEmpty() || txtUApellido.getText().isEmpty() ||
                txtUTelefono.getText().isEmpty() || txtUUsuario.getText().isEmpty() ||
                txtUContraseña.getText().isEmpty()) {
            Error();
        } else {
            int i = JOptionPane.showOptionDialog(null, "Seguro que desea modificar el registro", "Modificar",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if (i == 0) {
                usr.modificar(u);
            }
        }
        limpiarUsuario();
        mostrarUsuario();
    }

    //limpia las cajas de texto del usuario
    private void limpiarUsuario() {
        txtUNombre.setText("");
        txtUApellido.setText("");
        txtUTelefono.setText("");
        txtUUsuario.setText("");
        txtUContraseña.setText("");
        txtURepiteContraseña.setText("");
    }


    //Elimina al usuario
    @FXML
    private void EliminarUsuario(ActionEvent actionEvent) {
        String id = txtUUsuario.getText();
        usr.eliminar(id);
        mostrarUsuario();
        limpiarUsuario();
    }

    //manda los datos de la tabla a la caja de texto del usuario
    @FXML
    private void datosUsuario(MouseEvent mouseEvent) {
        UsuarioDTO usuarioDTO = tblUDatos.getSelectionModel().getSelectedItem();
        if (usuarioDTO == null) {
            MostrarLista();
        } else {
            txtUNombre.setText(usuarioDTO.getNomUsuario());
            txtUApellido.setText(usuarioDTO.getApeUsuario());
            txtUTelefono.setText(usuarioDTO.getTelefUsuario());
            txtUUsuario.setText(usuarioDTO.getUsuarioUsuario());
            txtUContraseña.setText(usuarioDTO.getContraUsuario());
            cmbRol.getSelectionModel().select(usuarioDTO.getRolUsuario());

        }
    }

    //Limpia el catalogo
    @FXML
    private void LimpiarCatalogo(ActionEvent actionEvent) {
        limpiarCatalogo();
    }

    //codigo para Limpiar el catalogo
    private void limpiarCatalogo() {
        txtIdCatalogo.setText("");
        txtCatalogo.setText("");
        txtRepresentante.setText("");
        txtCTelefono.setText("");
    }

    //Ingresa datos del catalogo
    private CatalogoDTO DatosCatalogo() {
        CatalogoDTO c = new CatalogoDTO();
        c.setRepresentante(txtRepresentante.getText());
        c.setTelefono(txtCTelefono.getText());
        return c;
    }
    private void toggleButton(){
        CatalogoDTO catalogo = new CatalogoDTO();
        List<CatalogoDTO> listar = daoCatalogo.listar();

    }

    //Codigo para mandar error
    private void Error() {
        JOptionPane.showMessageDialog(null, "Error. Datos Vacios", "Error", 1);
    }

    //Registra el catalogo
    @FXML
    private void RegistrarCatalogo(ActionEvent actionEvent) {
        CatalogoDTO c = DatosCatalogo();
        LocalDate fechaIngreso=dpFechaIngreso.getValue();
        String formato=fechaIngreso.format(DateTimeFormatter.ofPattern("yyyyMM"));
        c.setNombre(formato+"-"+txtCatalogo.getText());
        c.setEstado(String.valueOf(Estado.HABILITADO));
        if (txtCatalogo.getText().isEmpty() || txtRepresentante.getText().isEmpty() ||
                txtCTelefono.getText().isEmpty()) {
            Error();
        } else {
            if (txtDni.equals(c.getNombre()))
                daoCatalogo.grabar(c);
            else
                daoCatalogo.grabar(c);
        }
        limpiarCatalogo();
        MostrarListaCatalogo();
    }

    //Elimina el catalogo
    @FXML
    private void EliminarCatalogo(ActionEvent actionEvent) {
        int id = Integer.parseInt(txtIdCatalogo.getText());
        daoCatalogo.eliminar(id);
        MostrarListaCatalogo();
        limpiarCatalogo();

    }

    //Modifica el catalogo
    @FXML
    private void ModificarCatalogo(ActionEvent actionEvent) {
        CatalogoDTO c = DatosCatalogo();
        LocalDate fechaIngreso=dpFechaIngreso.getValue();
        String catalogo=txtCatalogo.getText();
        String catalogoA=catalogo.substring(7);
        String formato=fechaIngreso.format(DateTimeFormatter.ofPattern("yyyyMM"));
        c.setNombre(formato+"-"+catalogoA);
        c.setId(Integer.parseInt(txtIdCatalogo.getText()));
        if (txtCatalogo.getText().isEmpty() || txtRepresentante.getText().isEmpty() ||
                txtCTelefono.getText().isEmpty()) {
            Error();
        } else {
            int i = JOptionPane.showOptionDialog(null, "Seguro que desea modificar el registro", "Modificar",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if (i == 0) {
                daoCatalogo.modificar(c);
            }
        }
        limpiarCatalogo();
        MostrarListaCatalogo();

    }




    //Busca catalogo
    @FXML
    private void BuscarCatalogo(MouseEvent mouseEvent) {
        MostrarListaCatalogo();
        FilteredList<CatalogoDTO> filtrar = new FilteredList<>(listaCatalogoDTOS, b -> true);
        txtCBuscar.textProperty().addListener((ObservableList, oldValue, newValue) -> {
            filtrar.setPredicate(catalogoDTO -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                //Filtrar Por Nombre del catalogo del Promotor
                return catalogoDTO.getNombre().toLowerCase().contains(lowerCaseFilter);
            });
        });
        SortedList<CatalogoDTO> sorted = new SortedList<>(filtrar);
        sorted.comparatorProperty().bind(tblDatosCatalogo.comparatorProperty());
        tblDatosCatalogo.setItems(sorted);
    }

    //Muestra el catalogo
    @FXML
    private void MostrarCatalogo(ActionEvent actionEvent) {
        MostrarListaCatalogo();
    }

    //Manda los datos de la tabla a la caja de texto del catalogo
    @FXML
    private void datosCatalogo(MouseEvent mouseEvent) {
        CatalogoDTO catalogoDTO = tblDatosCatalogo.getSelectionModel().getSelectedItem();
        if (catalogoDTO == null) {
            MostrarLista();
        } else {
            txtIdCatalogo.setText(String.valueOf(catalogoDTO.getId()));
            txtCatalogo.setText(catalogoDTO.getNombre());
            txtRepresentante.setText(catalogoDTO.getRepresentante());
            txtCTelefono.setText(catalogoDTO.getTelefono());

        }
    }

    //Muestra los datos en la tabla del usuario
    @FXML
    private void MostrarUsuario(ActionEvent actionEvent) {
        mostrarUsuario();
    }

    //Busca al usuario
    @FXML
    private void BuscarUsuario(MouseEvent mouseEvent) {
        mostrarUsuario();
        FilteredList<UsuarioDTO> filtrar = new FilteredList<>(listaUsuarioDTO, b -> true);
        txtUBuscar.textProperty().addListener((ObservableList, oldValue, newValue) -> {
            filtrar.setPredicate(usuarioDTO -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (cmbBuscarUsuarios.getValue() != null) {
                    switch (cmbBuscarUsuarios.getValue()) {
                        //Filtrar Por Nombre del Usuario
                        case "Nombre": {
                            return usuarioDTO.getNomUsuario().toLowerCase().contains(lowerCaseFilter);
                        }
                        //Filtrar por apellido del Usuario
                        case "Apellidos": {
                            return usuarioDTO.getApeUsuario().toLowerCase().contains(lowerCaseFilter);
                        }
                        //Filtrar por Nombre de Usuario del Usuario
                        case "Usuario": {
                            return usuarioDTO.getUsuarioUsuario().toLowerCase().contains(lowerCaseFilter);
                        }
                    }
                } else {
                    //Muestra la lista de usuarios
                    mostrarUsuario();
                }
                return false;
            });
        });
        SortedList<UsuarioDTO> sorted = new SortedList<>(filtrar);
        sorted.comparatorProperty().bind(tblUDatos.comparatorProperty());
        tblUDatos.setItems(sorted);
    }

    //Limpia las cajas de texto
    @FXML
    private void LimpiarUsuario(ActionEvent actionEvent) {
        limpiarUsuario();
    }

    @FXML
    private void LimpiarListaPrecios(ActionEvent actionEvent) {
    }

    //Elimina precios
    @FXML
    private void EliminarPrecios(ActionEvent actionEvent) {
    }

    //Modifica Precios
    @FXML
    private void ModificarPrecios(ActionEvent actionEvent) {
    }

    //Registra Precios
    @FXML
    private void RegistrarPrecios(ActionEvent actionEvent) {
    }

    //busca productos
    @FXML
    private void buscarProductos(MouseEvent mouseEvent) {
    }

    //Manda los datos de la tabla a las cajas de texto


    //Importar Precios de los catalogos
    @FXML
    private void importarPrecios(ActionEvent actionEvent) {
        String r;
        filechooser=new FileChooser();
        Window stage=btnImportar.getScene().getWindow();
        filechooser.setTitle("Importar Precios");
        filechooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(
                "Excel","*.xlsx","xlx"
        ));
        try {
            File file=filechooser.showOpenDialog(stage);
            filechooser.setInitialDirectory(file.getParentFile());
            System.out.println(file);
            JOptionPane.showMessageDialog(null,listaPre.Importar(file),"Importacion",1);
            System.out.println(listaPre.Importar(file));
        }catch (Exception e){
            e.getMessage();
        }
    }
    private void Importar(){

    }

    //Muestra los catalogos en el combobox
    @FXML
    private void cmbmuestracata(MouseEvent mouseEvent) {
        List<CatalogoDTO> listar = daoCatalogo.listarCatalogos();
        cmbcata = FXCollections.observableArrayList();
        listar.forEach(a -> cmbcata.addAll(a.getNombre()));
        cmbCatalogosP.setItems(cmbcata);
    }


    //Codigo de limpiar Productos
    private void limpiarProductos() {
        txtPPagina.setText("");
        txtPCodigo.setText("");
        txtPMarca.setText("");
        txtPColor.setText("");
        txtPTalla.setText("");
        txtPPrecio.setText("");
    }




    //Limpia las cajas de texto del producto

    @FXML
    private void ListaPrecios(MouseEvent mouseEvent) {
    }

    @FXML
    private void LimpiarPedidosProductos(ActionEvent actionEvent) {
    }

    private void mostrarPedidos() {
        List<PedidosDTO> listar = pedido.listar();
        listaPedidos = FXCollections.observableArrayList();
        tcPedidoID.setCellValueFactory(new PropertyValueFactory<>("idPedido"));
        tcPedidoDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        tcPedidoNombres.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcPedidosApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tcPedidosCatalogo.setCellValueFactory(new PropertyValueFactory<>("nomCatalogo"));
        tcPedidoPagina.setCellValueFactory(new PropertyValueFactory<>("pagina"));
        tcPedidosCodigo.setCellValueFactory(new PropertyValueFactory<>("codProducto"));
        tcPedidosMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        tcPedidosColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        tcPedidosTalla.setCellValueFactory(new PropertyValueFactory<>("talla"));
        tcPedidosPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tcFechaPedido.setCellValueFactory(new PropertyValueFactory<>("fechaPedido"));
        listar.forEach(a -> listaPedidos.addAll(a));
        tblDatosPedidos.setItems(listaPedidos);
    }
    @FXML
    private void RegistrarPedidos(ActionEvent actionEvent) {
        String result="";
        try {
            PedidosDTO pedidos=datosPedido();
            pedidos.setEs("Proceso");
            if(txtPPagina.getText().isEmpty() || txtPCodigo.getText().isEmpty() || txtPColor.getText().isEmpty() ||
                    txtPPrecio.getText().isEmpty() || txtPTalla.getText().isEmpty() ||
                    cmbPromotorPedido.getEditor().getText().isEmpty() || cmbCatalogosP.getEditor().getText().isEmpty()){
                Error();
            }else{
                result=pedido.grabar(pedidos);
                JOptionPane.showMessageDialog(null,result,"Registrar",1);

            }
        }catch (NumberFormatException number){
            JOptionPane.showMessageDialog(null, "Error. La pagina o precio no puede ir letras", "Error", 1);
            txtPPagina.setText("");
        }
        mostrarlistaEstado();
        mostrarPedidos();
        createBarChart();

    }


    private PedidosDTO datosPedido(){

        PedidosDTO pedidos=new PedidosDTO();
        pedidos.setDni(cmbPromotorPedido.getValue());
        pedidos.setNombre(txtNombrePromotorPedido.getText());
        pedidos.setApellido(txtApellidoPromotorPedido.getText());
        pedidos.setNomCatalogo(cmbCatalogosP.getValue());
        pedidos.setPagina(Integer.parseInt(txtPPagina.getText()));
        pedidos.setCodProducto(txtPCodigo.getText());
        pedidos.setMarca(txtPMarca.getText());
        pedidos.setColor(txtPColor.getText());
        pedidos.setTalla(txtPTalla.getText());
        pedidos.setBanco(txtBancoPromotor.getText());
        pedidos.setTipopago(cmbTipoPago.getValue());
        pedidos.setPrecio(Double.parseDouble(txtPPrecio.getText()));
        pedidos.setFechaPedido(LocalDate.now());
        return pedidos;
    }

    @FXML
    private void ModificarPedidos(ActionEvent actionEvent) {
        String result;
        try {
            //Icon icono=new ImageIcon(getClass().getResource("../img/alerta.png"));
            IconTest icon=new IconTest();
            PedidosDTO pedidos=datosPedido();
            pedidos.setIdPedido(Integer.parseInt(lblIdpedido.getText()));
            if(txtPPagina.getText().isEmpty() || txtPCodigo.getText().isEmpty() || txtPColor.getText().isEmpty() ||
                    txtPMarca.getText().isEmpty() ||txtPPrecio.getText().isEmpty() || txtPTalla.getText().isEmpty()){
                Error();
            }else{
                int i = JOptionPane.showOptionDialog(null, "Seguro que desea modificar el registro", "Modificar",
                        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, null, null);
                if (i == 0) {
                    JOptionPane.showMessageDialog(null,pedido.modificar(pedidos),"Modificar",1);
                }
            }
        }catch (NumberFormatException number){
            JOptionPane.showMessageDialog(null, "Error. La pagina no puede ir letras", "Error", 1);
            txtPPagina.setText("");
        }
        mostrarPedidos();
        limpiarpedidos();
        createBarChart();
    }

    @FXML
    private void EliminarPedidos(ActionEvent actionEvent) {
        String id=lblIdpedido.getText();
        int i = JOptionPane.showOptionDialog(null, "Seguro que desea Eliminar el registro", "Eliminar",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, JOptionPane.ICON_PROPERTY);
        if (i == 0) {
            JOptionPane.showMessageDialog(null,pedido.eliminar(id),"Eliminar",1);
        }
        mostrarPedidos();
        limpiarpedidos();
    }

    @FXML
    private void mostrarPedidos(ActionEvent actionEvent) {
        btnMostrarPedidos.setOnAction(pedidos->{
            mostrarPedidos();
        });
    }

    @FXML
    private void ListaPedidos(MouseEvent mouseEvent) {
        PedidosDTO pedidos = tblDatosPedidos.getSelectionModel().getSelectedItem();
        if (pedidos == null) {
            MostrarLista();
        } else {
            lblIdpedido.setText(String.valueOf(pedidos.getIdPedido()));
            cmbPromotorPedido.getSelectionModel().select(pedidos.getDni());
            txtApellidoPromotorPedido.setText(pedidos.getApellido());
            txtNombrePromotorPedido.setText(pedidos.getNombre());
            cmbCatalogosP.getSelectionModel().select(pedidos.getNomCatalogo());
            txtPCodigo.setText(pedidos.getCodProducto());
            txtPPagina.setText(String.valueOf(pedidos.getPagina()));
            txtPMarca.setText(pedidos.getMarca());
            txtPColor.setText(pedidos.getColor());
            txtPPrecio.setText(String.valueOf(pedidos.getPrecio()));
            txtPTalla.setText(pedidos.getTalla());

        }

    }

    @FXML
    private void ListaPedidosEstado(MouseEvent mouseEvent) {
        PedidosDTO pedidos = tblDatosPedidos.getSelectionModel().getSelectedItem();
        if (pedidos == null) {
            MostrarLista();
        } else {
            lblIdpedido.setText(String.valueOf(pedidos.getIdPedido()));
            cmbPromotorPedido.getSelectionModel().select(pedidos.getDni());
            txtApellidoPromotorPedido.setText(pedidos.getApellido());
            txtNombrePromotorPedido.setText(pedidos.getNombre());
            cmbCatalogosP.getSelectionModel().select(pedidos.getNomCatalogo());
            txtPCodigo.setText(pedidos.getCodProducto());
            txtPPagina.setText(String.valueOf(pedidos.getPagina()));
            txtPMarca.setText(pedidos.getMarca());
            txtPColor.setText(pedidos.getColor());
            txtPPrecio.setText(String.valueOf(pedidos.getPrecio()));
            txtPTalla.setText(pedidos.getTalla());

        }

    }

    @FXML
    private void MostrarPrecios(ActionEvent actionEvent) {

    }

    private void limpiarpedidos(){
        txtNombrePromotorPedido.setText("");
        txtApellidoPromotorPedido.setText("");
        txtPPagina.setText("");
        txtPPrecio.setText("");
        txtPMarca.setText("");
        txtPTalla.setText("");
        txtPColor.setText("");
        txtPCodigo.setText("");
        cmbPromotorPedido.getSelectionModel().select("");
        cmbCatalogosP.getSelectionModel().select("");
    }

    @FXML
    private void LimpiarPedidos(ActionEvent actionEvent) {
        limpiarpedidos();
    }

    @FXML
    private void muestraPromotorPedido(MouseEvent mouseEvent) {

        List<PromotorDTO> listar = dao.listar();
        cmbPromotor = FXCollections.observableArrayList();
        listar.forEach(a -> cmbPromotor.addAll(a.getDni()));
        cmbPromotorPedido.setItems(cmbPromotor);


    }

    @FXML
    private void buscaPromotor(ActionEvent actionEvent) {
        String dni;
        PromotorDTO p;
        if(cmbPromotorPedido.getValue()==null || cmbPromotorPedido.getEditor().getText().isEmpty()){
            txtNombrePromotorPedido.setText("");
            txtApellidoPromotorPedido.setText("");

        }else {
            dni=cmbPromotorPedido.getValue();
            p=dao.buscar(dni);
            txtNombrePromotorPedido.setText(p.getNombre());
            txtApellidoPromotorPedido.setText(p.getApellido());
        }

    }

    private void buscarPedidos(){
        listaBuscarPedidos=FXCollections.observableArrayList("DNI","Catalogo");
        cmbBuscarPedido.setItems(listaBuscarPedidos);
    }

    @FXML
    private void buscarPedidos(MouseEvent mouseEvent) {
        mostrarPedidos();
        FilteredList<PedidosDTO> filtrar = new FilteredList<>(listaPedidos, b -> true);
        txtBPedidos.textProperty().addListener((ObservableList, oldValue, newValue) -> {
            filtrar.setPredicate(pedidos -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (cmbBuscarPedido.getValue() != null) {
                    switch (cmbBuscarPedido.getValue()) {
                        //Filtrar Por Nombre del Usuario
                        case "DNI": {
                            return pedidos.getDni().toLowerCase().contains(lowerCaseFilter);
                        }
                        //Filtrar por apellido del Usuario
                        case "Catalogo": {
                            return pedidos.getNomCatalogo().toLowerCase().contains(lowerCaseFilter);
                        }
                    }
                } else {
                    //Muestra la lista de usuarios
                    mostrarUsuario();
                }
                return false;
            });
        });
        SortedList<PedidosDTO> sorted = new SortedList<>(filtrar);
        sorted.comparatorProperty().bind(tblDatosPedidos.comparatorProperty());
        tblDatosPedidos.setItems(sorted);
    }
    @FXML
    private void limitarCaracteres(KeyEvent keyEvent) {
        if(txtDni.getText().length()>=8){
            keyEvent.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }


    @FXML
    private void buscarCaja(MouseEvent mouseEvent) {
    }

    @FXML
    private void AgregarCaja(ActionEvent actionEvent) {
        CajaDTO datos=registrarCaja();
        if(taDescripcion.getText().isEmpty() || txtMontoCaja.getText().isEmpty()){
            Error();
        }else{
            String result=caja.grabar(datos);
            JOptionPane.showMessageDialog(null,result,"Registrar",1);
        }
        sumatotalCajaPorDia();
        mostrarCaja();
        sumaTotalCaja();
    }


    private void mostrarCaja(){
        List<CajaDTO> listar = caja.listacaja();
        listaCajaDTO = FXCollections.observableArrayList();
        tcPedidoIDCaja.setCellValueFactory(new PropertyValueFactory<>("idcaja"));
        tcPedidoDescripcionCaja.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tcPedidoMontoCaja.setCellValueFactory(new PropertyValueFactory<>("monto"));
        tcPedidosHoraCaja.setCellValueFactory(new PropertyValueFactory<>("hora"));
        tcFechaCajaDelDia.setCellValueFactory(new PropertyValueFactory<>("fecha"));

        listaCajaDTO.addAll(listar);
        tblDatosCajaDelDia.setItems(listaCajaDTO);

    }

    private CajaDTO registrarCaja(){
        CajaDTO caja=new CajaDTO();
        LocalDateTime hora=LocalDateTime.now();
        caja.setDescripcion(taDescripcion.getText());
        caja.setMonto(Double.parseDouble(txtMontoCaja.getText()));
        caja.setHora(hora.format(DateTimeFormatter.ofPattern("HH:mm")));
        caja.setFecha(hora.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return caja;
    }

    @FXML
    private void ModificarCaja(ActionEvent actionEvent) {
        CajaDTO datos=registrarCaja();
        datos.setIdcaja(Integer.parseInt(lblCajaID.getText()));
        if(txtMontoCaja.getText().isEmpty()){
            Error();
        }else{
            JOptionPane.showMessageDialog(null,caja.modificar(datos));
        }
        sumatotalCajaPorDia();
        mostrarCaja();
        limpiarcaja();
    }

    @FXML
    private void EliminarCaja(ActionEvent actionEvent) {
        String id=lblCajaID.getText();
        int i = JOptionPane.showOptionDialog(null, "Seguro que desea Eliminar el registro", "Eliminar",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, JOptionPane.ICON_PROPERTY);
        if (i == 0) {
            JOptionPane.showMessageDialog(null,caja.eliminar(id),"Eliminar",1);
        }
        sumatotalCajaPorDia();
        mostrarCaja();
        limpiarcaja();
    }

    private void limpiarcaja(){
        taDescripcion.setText("");
        txtMontoCaja.setText("");
    }
    @FXML
    private void LimpiarCaja(ActionEvent actionEvent) {
        limpiarcaja();
    }

    @FXML
    private void buscarEstadoPedido(MouseEvent mouseEvent) {
        mostrarlistaEstado();
        FilteredList<PedidosDTO> filtrar = new FilteredList<>(listaPedidos, b -> true);
        txtBEstadoPedido.textProperty().addListener((ObservableList, oldValue, newValue) -> {
            filtrar.setPredicate(pedidosEstado -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (cmbBuscarEstadoPedido.getValue() != null) {
                    switch (cmbBuscarEstadoPedido.getValue()) {
                        //Filtrar Por Nombre del Usuario
                        case "DNI": {
                            return pedidosEstado.getDni().toLowerCase().contains(lowerCaseFilter);
                        }
                        //Filtrar por apellido del Usuario
                        case "Catalogo": {
                            return pedidosEstado.getNomCatalogo().toLowerCase().contains(lowerCaseFilter);
                        }
                        case "Fecha":{
                            return  String.valueOf(pedidosEstado.getFechaPedido()).toLowerCase().contains(lowerCaseFilter);
                        }
                    }
                } else {

                    mostrarlistaEstado();
                }
                return false;
            });
        });
        SortedList<PedidosDTO> sorted = new SortedList<>(filtrar);
        sorted.comparatorProperty().bind(tblDatosEstado.comparatorProperty());
        tblDatosEstado.setItems(sorted);
        mostrarlistaEstado();
    }

    @FXML
    private void tipoPagos(ActionEvent actionEvent) {
        listaTipoPago();
        if(cmbTipoPago.getValue().equals("Transferencia")){
            txtBancoPromotor.setDisable(false);

        }else if(cmbTipoPago.getValue().equals("Efectivo")){
            txtBancoPromotor.setDisable(true);
        }
    }

    @FXML
    private void ListaCajadelDia(MouseEvent mouseEvent) {
        CajaDTO mostrar = tblDatosCajaDelDia.getSelectionModel().getSelectedItem();
        if (mostrar == null) {
            MostrarLista();
        } else {
            lblCajaID.setText(String.valueOf(mostrar.getIdcaja()));
            taDescripcion.setText(mostrar.getDescripcion());
            txtMontoCaja.setText(String.valueOf(mostrar.getMonto()));
        }
    }

    public void mostrarPedidosEstado(ActionEvent actionEvent) {
        mostrarlistaEstado();
    }

    private void litadoReportes(){
        cmbfiltrarReportes1=FXCollections.observableArrayList("ventas por promotor","ventas totales por catalogo","Ventas totales del mes");
        cmbReporte.setItems(cmbfiltrarReportes1);
    }
    
    private File file(){
        filechooser=new FileChooser();
        File file = null;
        Window stage=btnImportar.getScene().getWindow();
        filechooser.setTitle("Guardar Reporte");
        filechooser.setInitialFileName("mysave");
        filechooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(
                "Excel","*.xlsx","xlx"
        ));
        try {
            file=filechooser.showSaveDialog(stage);
            filechooser.setInitialDirectory(file.getParentFile());

        }catch (Exception e){
            e.getMessage();
        }
        return file;
    } 
    
    @FXML
    private void btnExportarReportes(ActionEvent actionEvent) {
        File file=file();
        switch(cmbReporte.getValue()){
            case "ventas por promotor":{
                PromotorGanancia.PromotorG(file);
            }break;
            case "ventas totales por catalogo":{
                PromotorGanancia.FechaPedido(file);
            }break;
            case "Ventas totales del mes":{
                PromotorGanancia.ReporteMes(file);
            }
        }
    }
    private void installTooltip(PieChart.Data pie){
        String msg=String.format("%s:%s",pie.getName(),pie.getPieValue());
        Tooltip tt=new Tooltip(msg);
        tt.setStyle("-fx-background-color: gray;-fx-text-fill:whitesmoke;");
        Tooltip.install(pie.getNode(),tt);
    }



    private void createBarChart() {



    }
}