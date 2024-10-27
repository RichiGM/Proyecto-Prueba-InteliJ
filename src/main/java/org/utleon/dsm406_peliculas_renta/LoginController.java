package org.utleon.dsm406_peliculas_renta;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ImageView btnCerrar;

    @FXML
    private ImageView btnLogin;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private TextField txtUsuario;

    public void initialize(){
        btnLogin.setOnMouseClicked(event -> {
            try {
                validarLogin();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        btnCerrar.setOnMouseClicked(event -> {
            System.exit(0);
        });

    }

    public void validarLogin() throws Exception {
        String usuario = txtUsuario.getText();
        String contrasenia = txtContrasenia.getText();
        Alert alert = null;
        if (usuario.isEmpty() || contrasenia.isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR, "Debes colocar tus credenciales");
            alert.showAndWait();
        } else if (usuario.equals("richi") && contrasenia.equals("1234")) {
           /* alert = new Alert(Alert.AlertType.CONFIRMATION, "Datos correctos");
            alert.showAndWait();*/
            cargarModuloPrincipal();
        } else {
            alert = new Alert(Alert.AlertType.ERROR, "Datos incorrectos");
            alert.showAndWait();
        }

    }
    public void cargarModuloPrincipal() throws Exception{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(LoginController.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("El zarape");
        stage.show();
        stage = (Stage)btnLogin.getScene().getWindow();
        stage.close();
    }
}
