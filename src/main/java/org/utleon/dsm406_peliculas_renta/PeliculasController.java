package org.utleon.dsm406_peliculas_renta;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class PeliculasController {
    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnRentar;

    @FXML
    private Button btnDevolver;

    @FXML
    private TableColumn<PeliculasModel, Integer> colId;
    @FXML
    private TableColumn<PeliculasModel, String> colTitulo;
    @FXML
    private TableColumn<PeliculasModel, String> colGenero;
    @FXML
    private TableColumn<PeliculasModel, Integer> colAnio;
    @FXML
    private TableColumn<PeliculasModel, String> colDirector;

    @FXML
    private TableColumn<PeliculasModel, Integer> colId2;
    @FXML
    private TableColumn<PeliculasModel, String> colTitulo2;
    @FXML
    private TableColumn<PeliculasModel, String> colGenero2;
    @FXML
    private TableColumn<PeliculasModel, String> colAnio2;
    @FXML
    private TableColumn<PeliculasModel, String> colDirector2;

    @FXML
    private TableView<PeliculasModel> tablePeliculas;
    @FXML
    private TableView<PeliculasModel> tablePeliculas2;

    @FXML
    private TextField txtAnio;
    @FXML
    private TextField txtDirector;
    @FXML
    private TextField txtGenero;
    @FXML
    private TextField txtTitulo;

    private ObservableList<PeliculasModel> peliculasList;
    private ObservableList<PeliculasModel> peliculasRentadasList;
    private int contador = 0;
    private PeliculasModel selectedPelicula = null;

    @FXML
    public void initialize() {
        peliculasList = FXCollections.observableArrayList();
        peliculasRentadasList = FXCollections.observableArrayList();

        colId.setCellValueFactory(new PropertyValueFactory<>("idPelicula"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colAnio.setCellValueFactory(new PropertyValueFactory<>("anio"));
        colDirector.setCellValueFactory(new PropertyValueFactory<>("director"));
        tablePeliculas.setItems(peliculasList);

        colId2.setCellValueFactory(new PropertyValueFactory<>("idPelicula"));
        colTitulo2.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colGenero2.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colAnio2.setCellValueFactory(new PropertyValueFactory<>("anio"));
        colDirector2.setCellValueFactory(new PropertyValueFactory<>("director"));
        tablePeliculas2.setItems(peliculasRentadasList);

        // Ocultar las columnas de ID en ambas tablas
        colId.setVisible(false);
        colId2.setVisible(false);

        tablePeliculas.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 1) {
                seleccionarPeliculaRegistrada();
            }
        });

        tablePeliculas2.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 1) {
                seleccionarPeliculaRentada();
            }
        });
    }

    @FXML
    public void registrarOActualizarPelicula() {
        if (selectedPelicula == null) {
            registrarPelicula();
        } else {
            modificarPelicula();
        }
    }

    private void registrarPelicula() {
        PeliculasModel nuevaPelicula = new PeliculasModel();
        contador++;
        nuevaPelicula.setIdPelicula(contador);
        nuevaPelicula.setTitulo(txtTitulo.getText());
        nuevaPelicula.setGenero(txtGenero.getText());
        nuevaPelicula.setAnio(Integer.parseInt(txtAnio.getText()));
        nuevaPelicula.setDirector(txtDirector.getText());

        peliculasList.add(nuevaPelicula);
        cargarTabla();
        limpiarCampos();
    }

    private void seleccionarPeliculaRegistrada() {
        selectedPelicula = tablePeliculas.getSelectionModel().getSelectedItem();
        if (selectedPelicula != null) {
            txtTitulo.setText(selectedPelicula.getTitulo());
            txtGenero.setText(selectedPelicula.getGenero());
            txtAnio.setText(String.valueOf(selectedPelicula.getAnio()));
            txtDirector.setText(selectedPelicula.getDirector());
            btnRegistrar.setText("Modificar");

            // Habilitar campos de texto para modificar
            setCamposEditable(true);
            btnRegistrar.setDisable(false);
        }
    }

    private void seleccionarPeliculaRentada() {
        PeliculasModel peliculaRentada = tablePeliculas2.getSelectionModel().getSelectedItem();
        if (peliculaRentada != null) {
            txtTitulo.setText(peliculaRentada.getTitulo());
            txtGenero.setText(peliculaRentada.getGenero());
            txtAnio.setText(String.valueOf(peliculaRentada.getAnio()));
            txtDirector.setText(peliculaRentada.getDirector());

            // Desactivar edición de campos de texto
            setCamposEditable(false);
            btnRegistrar.setText("Registrar");
            btnRegistrar.setDisable(true); // Deshabilita el botón de registrar
        }
    }

    private void modificarPelicula() {
        selectedPelicula.setTitulo(txtTitulo.getText());
        selectedPelicula.setGenero(txtGenero.getText());
        selectedPelicula.setAnio(Integer.parseInt(txtAnio.getText()));
        selectedPelicula.setDirector(txtDirector.getText());

        tablePeliculas.refresh();
        limpiarCampos();
        btnRegistrar.setText("Registrar");
        selectedPelicula = null;
    }

    @FXML
    public void rentarPelicula() {
        PeliculasModel peliculaARentar = tablePeliculas.getSelectionModel().getSelectedItem();
        if (peliculaARentar != null) {
            peliculasRentadasList.add(peliculaARentar);
            peliculasList.remove(peliculaARentar);
            tablePeliculas.refresh();
            tablePeliculas2.refresh();
            limpiarCampos();
            btnRegistrar.setText("Registrar");
            selectedPelicula = null;
        }
    }

    @FXML
    public void devolverPelicula() {
        PeliculasModel peliculaADevolver = tablePeliculas2.getSelectionModel().getSelectedItem();
        if (peliculaADevolver != null) {
            peliculasList.add(peliculaADevolver);
            peliculasRentadasList.remove(peliculaADevolver);
            tablePeliculas.refresh();
            tablePeliculas2.refresh();
            limpiarCampos();

            // Habilita el botón de registrar nuevamente
            btnRegistrar.setDisable(false);
        }
    }

    private void cargarTabla() {
        tablePeliculas.setItems(peliculasList);
        tablePeliculas.refresh();
    }

    private void limpiarCampos() {
        txtTitulo.clear();
        txtGenero.clear();
        txtAnio.clear();
        txtDirector.clear();
    }

    private void setCamposEditable(boolean editable) {
        txtTitulo.setEditable(editable);
        txtGenero.setEditable(editable);
        txtAnio.setEditable(editable);
        txtDirector.setEditable(editable);
    }
}
