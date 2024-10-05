package name.ulbricht.javafx.ui;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

public final class SectionItemListCell extends ListCell<SectionItem> {

    public static Callback<ListView<SectionItem>, ListCell<SectionItem>> forListView() {
        return listView -> new SectionItemListCell();
    }

    @Override
    protected void updateItem(final SectionItem item, final boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            setText(item.getText());

            final var image = item.getImage();
            if (image != null)
                setGraphic(new ImageView(image));
            else
                setGraphic(null);
        }
    }
}
