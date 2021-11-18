import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class PatientListController {

    @FXML
    private Button patiListBack;

    @FXML
    private TableColumn<?, ?> patiListBirthDate;

    @FXML
    private TableColumn<?, ?> patiListName;

    @FXML
    private TableColumn<?, ?> patiListPharmacy;

    @FXML
    private TableColumn<?, ?> patiListRoom;

    @FXML
    void handleBackButton(ActionEvent event) throws IOException
    {
        
    }
}
