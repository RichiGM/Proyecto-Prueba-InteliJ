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
import java.util.HashMap;
import java.util.Map;

public class LoginController {

    @FXML
    private ImageView btnCerrar;

    @FXML
    private ImageView btnLogin;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private TextField txtUsuario;

    // Mapa de usuarios y contraseñas
    private Map<String, String> usuarios;

    public void initialize(){
        // Inicializar el mapa con usuarios y contraseñas
        usuarios = new HashMap<>();
        usuarios.put("richi", "1234");
        usuarios.put("coper", "1678");
        usuarios.put("cristian", "1234");
        usuarios.put("erick", "9876");
        usuarios.put("vegeta777", "4657");
        usuarios.put("messi", "4572");
        usuarios.put("gio", "3428");
        usuarios.put("barajas", "5867");
        usuarios.put("arleth", "8799");
        usuarios.put("danna", "0989");
        usuarios.put("alan", "3142");

        // Configuración de eventos para botones
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
        Alert alert;

        if (usuario.isEmpty() || contrasenia.isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR, "Debes colocar tus credenciales");
            alert.showAndWait();
        } else if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(contrasenia)) {
            // Si las credenciales son correctas, cargar el módulo principal
            cargarModuloPrincipal();
        } else {
            // Si las credenciales son incorrectas, mostrar mensaje de error
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

        // Cerrar la ventana de login
        Stage loginStage = (Stage)btnLogin.getScene().getWindow();
        loginStage.close();
    }
}
