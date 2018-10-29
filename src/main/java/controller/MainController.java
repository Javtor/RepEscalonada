package controller;

import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import model.Area;

public class MainController implements Initializable {

//	public static final String[] areas = new String[] { "CAR", "CM", "DAR", "IPM", "MA", "OPD", "OPF", "OPM", "OPP",
//			"OT", "PI", "PMC", "PP", "PPQA", "QPM", "RD", "REQM", "RSKM", "SAM", "TS", "VAL", "VER" };

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
	
	private void createHash() {
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
		
		

	}

	@FXML
    void process(ActionEvent event) {

    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		createHash();

		ObservableList<Area> list = FXCollections.observableArrayList(areas);
		comboArea.setItems(list);
		comboArea.getSelectionModel().select(0);

	}

}
