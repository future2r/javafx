package name.ulbricht.javafx.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import name.ulbricht.javafx.impl.Messages;

public final class MainView {

    public static MainView load() {
        final var fxmlLoader = new FXMLLoader(MainView.class.getResource("MainView.fxml"), Messages.RESOURCE_BUNDLE);
        try {
            fxmlLoader.<Parent>load();
            return fxmlLoader.<MainView>getController();
        } catch (final IOException ex) {
            throw new InternalError(ex);
        }
    }

    @FXML
    private Parent root;

    @FXML
    private ListView<SectionItem> sectionsListView;

    @FXML
    private Label sectionLabel;
    @FXML
    private StackPane sectionWrapper;

    public Parent getRoot() {
        return this.root;
    }

    @FXML
    private void initialize() {
        this.sectionLabel.textProperty().bind( //
                this.sectionsListView.getSelectionModel().selectedItemProperty() //
                        .map(SectionItem::getText));

        this.sectionsListView.getSelectionModel().selectedItemProperty().subscribe(this::showSection);

        this.sectionsListView.getSelectionModel().selectFirst();
    }

    private void showSection(final SectionItem sectionItem) {
        this.sectionWrapper.getChildren().clear();

        if (sectionItem != null)
            this.sectionWrapper.getChildren().add(sectionItem.getContent());
    }
}
