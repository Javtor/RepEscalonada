package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import model.Area;

public class MainController implements Initializable {

	// public static final String[] areas = new String[] { "CAR", "CM", "DAR",
	// "IPM", "MA", "OPD", "OPF", "OPM", "OPP",
	// "OT", "PI", "PMC", "PP", "PPQA", "QPM", "RD", "REQM", "RSKM", "SAM", "TS",
	// "VAL", "VER" };

	private ArrayList<Area> areas;

	@FXML
	private JFXButton btnProcess;

	@FXML
	private JFXComboBox<Area> comboArea;

	@FXML
	private Label txtArea;

	@FXML
	private JFXCheckBox gg1;

	@FXML
	private JFXCheckBox gg2;

	@FXML
	private JFXCheckBox gg3;

	@FXML
	private JFXCheckBox sg1;

	@FXML
	private JFXCheckBox sg2;

	@FXML
	private JFXCheckBox sg3;

	private void createAreas() {

		areas = new ArrayList<Area>();
		areas.add(new Area("CAR","Causal Analysis and Resolution",5,2));
		areas.add(new Area("DAR", "Decision Analysis and Resolution", 3,1));
		areas.add(new Area("MA","Measurement and Analysis",2,2));
		areas.add(new Area("OPF", "Organizational Process Focus",3,3));
		areas.add(new Area("OPP", "Organizational Process Performance",4,1));
		areas.add(new Area("PI", "Product Integration",3,3 ));
		areas.add(new Area("PP", "Project Planing",2,3));
		areas.add(new Area("QPM", "Quantitative Project Management",4,2));
		areas.add(new Area("REQM", "Requirements Management",2,1));
		areas.add(new Area("SAM", "Supplier Agreement Management",2,2));
		areas.add(new Area("VAL", "Validation",3,2));
		areas.add(new Area("VER", "Verification",3,3));
		areas.add(new Area("CM","Configuration Management",2,3));
		areas.add(new Area("IPM", "Integrated Project Management",3,2));
		areas.add(new Area("OPD", "Organizational Process Definition",3,1));
		areas.add(new Area("OPM", "Organizational Performance Management",5,3));
		areas.add(new Area("OT", "Organizational Training",3,2));
		areas.add(new Area("PMC", "Project Monitoring and Control",2,2));
		areas.add(new Area("PPQA", "Process and Product Quality Assurance",2,2));
		areas.add(new Area("RD", "Requirements Development",3,3));
		areas.add(new Area("RSKM", "Risk Management",3,3));
		areas.add(new Area("TS", "Technical Solution",3,3));
		Collections.sort(areas);
	}

	@FXML
	void process(ActionEvent event) {
		int madurez = 1;

		for (int i = 0; i < areas.size(); i++) {
			if(areas.get(i).getMadurez() > 2) {
				madurez = 2;
				break;
			}
			if (areas.get(i).getCapacidad() < 2) {
				break;
			}
		}
		
		for (int i = 0; i < areas.size(); i++) {
			if(areas.get(i).getMadurez() > (madurez+1)) {
				madurez++;
				break;
			}
			if (areas.get(i).getCapacidad() < 3) {
				break;
			}
		}
		Alert warning = new Alert(AlertType.INFORMATION);
		warning.setTitle("Nivel de Madurez");
		warning.setHeaderText(null);
		warning.setContentText("El nivel de madurez de la organización es de "+madurez);
		warning.showAndWait();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		createAreas();

		ObservableList<Area> list = FXCollections.observableArrayList(areas);
		comboArea.setItems(list);
		comboArea.getSelectionModel().select(0);
		updateUI();

	}
	
	@FXML
    void changeArea(ActionEvent event) {
		
		updateUI();
    }
	
	@FXML
    void update(ActionEvent event) {
		Area a = comboArea.getSelectionModel().getSelectedItem();
		a.setG2(gg2.isSelected());
		a.setG3(gg3.isSelected());
		a.setS1(sg1.isSelected());
		a.setS2(sg2.isSelected());
		a.setS3(sg3.isSelected());
		updateUI();
    }

	private void updateUI() {
		Area a = comboArea.getSelectionModel().getSelectedItem();
		txtArea.setText(a.getNombre()+" - Madurez: "+a.getMadurez());
		gg1.setSelected(a.getCapacidad()>=1);
		gg2.setSelected(a.isG2());
		gg3.setSelected(a.isG3());
		sg1.setSelected(a.isS1());
		sg2.setSelected(a.isS2());
		sg3.setSelected(a.isS3());
		
		int sg =a.getSg();
		sg2.setDisable(sg == 1);
		sg3.setDisable(sg >= 1);
	}

}
