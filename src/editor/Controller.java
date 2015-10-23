package editor;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class Controller {
    public TextArea text;
    public MenuItem miOT12;
    public MenuItem miOT10;
    public MenuItem miFSortir;
    public MenuItem miECopiar;
    public MenuItem miETallar;
    public MenuItem miEPaste;
    public MenuItem miEUndo;
    public Button btCopy;
    public MenuItem miAAbout;
    public AnchorPane mainPane;

    /**
     * S'executa al iniciar l'aplicació.
     */
    public void initialize(){
        btCopy.setGraphic(new ImageView("copy.png"));
    }

    /**
     * Menú Opcions -> Font. Canvi de la font del text.
     * @param actionEvent Event onAction de tots els MenuItem
     */
    public void setFont(ActionEvent actionEvent) {
        text.setFont(new Font(((MenuItem) actionEvent.getSource()).getText(), text.getFont().getSize()));
    }

    /**
     * Menú Opcions -> Tamany. Canvi del tamany de la font del text.
     * @param actionEvent Event onAction de tots els MenuItem
     */
    public void setFontSize(ActionEvent actionEvent) {
        double fontSize = Double.parseDouble(((MenuItem) actionEvent.getSource()).getText());
        text.setFont(new Font(fontSize));
    }

    /**
     * Menú Fitxer -> Sortir. Surt de l'aplicació
     * @param actionEvent Event onAction de tots els MenuItem
     */
    public void sortir(ActionEvent actionEvent) {
        Platform.exit();
    }

    /**
     * Menú Editar -> Copiar. Còpia el text seleccionat.
     * @param actionEvent Event onAction de tots els MenuItem
     */
    public void eCopiar(ActionEvent actionEvent) {
        text.copy();
    }

    /**
     * Menú Editar -> Tallar. Talla el text seleccionat.
     * @param actionEvent Event onAction de tots els MenuItem
     */
    public void eTallar(ActionEvent actionEvent) {
        text.cut();
    }

    /**
     * Menú Editar -> Enganxar. Enganxa el text del clipboard.
     * @param actionEvent Event onAction de tots els MenuItem
     */
    public void ePaste(ActionEvent actionEvent) {
        text.paste();
    }

    /**
     * Menú Editar -> Desfer. Desfà la última acció.
     * @param actionEvent Event onAction de tots els MenuItem
     */
    public void eUndo(ActionEvent actionEvent) {
        text.undo();
    }

    /**
     * Menú Ajuda -> About. Mostra un diàleg modal amb info de la app.
     *
     * @param actionEvent Event onAction del MenuItem
     */
    public void eAbout(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cutreditor");
        alert.setHeaderText("Un editor de text cutre!");
        alert.setContentText("Fet durant el curs 2015-2016.");

        alert.showAndWait();
    }

    /**
     * Deshabilita els items Copiar i Tallar si no hi ha text seleccionat.
     *
     * @param event Event onShowing del menú Editar.
     */
    public void deshabilitarCC(Event event) {
        if (text.getSelectedText().equals("")) {
            miECopiar.setDisable(true);
            miETallar.setDisable(true);
        } else {
            miECopiar.setDisable(false);
            miETallar.setDisable(false);
        }
    }
}
