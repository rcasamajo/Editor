package editor;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public class Controller {
    public TextArea text;
    public MenuItem miOFTimes;
    public MenuItem miOFArial;
    public MenuItem miOT12;
    public MenuItem miOT10;

    private double fontSize;

    public void initialize(){
        fontSize = text.getFont().getSize();
    }

    public void setFontArial(ActionEvent actionEvent) {
        text.setFont(new Font("SansSerif", fontSize));
    }

    public void setFontTimes(ActionEvent actionEvent) {
        text.setFont(new Font("FreeMono", fontSize));
    }

    public void setFontSize(ActionEvent actionEvent) {
        fontSize = Double.parseDouble(((MenuItem)actionEvent.getSource()).getText());
        text.setFont(new Font(fontSize));
    }
}
