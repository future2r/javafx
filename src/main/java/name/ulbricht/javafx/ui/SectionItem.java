package name.ulbricht.javafx.ui;

import static java.util.Objects.requireNonNull;

import javafx.beans.NamedArg;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Node;
import javafx.scene.image.Image;

public final class SectionItem {

    private final ReadOnlyStringWrapper text = new ReadOnlyStringWrapper(this, "text");
    private final ReadOnlyObjectWrapper<Image> image = new ReadOnlyObjectWrapper<>(this, "image");
    private final ReadOnlyObjectWrapper<Node> content = new ReadOnlyObjectWrapper<>(this, "content");

    public SectionItem(@NamedArg("text") final String text, @NamedArg("image") final Image image,
            @NamedArg("content") final Node content) {
        this.text.set(requireNonNull(text));
        this.image.set(requireNonNull(image));
        this.content.set(requireNonNull(content));
    }

    public ReadOnlyStringProperty textProperty() {
        return this.text.getReadOnlyProperty();
    }

    public String getText() {
        return textProperty().get();
    }

    public ReadOnlyObjectProperty<Image> imageProperty() {
        return this.image.getReadOnlyProperty();
    }

    public Image getImage() {
        return imageProperty().get();
    }

    public ReadOnlyObjectProperty<Node> contentProperty() {
        return this.content.getReadOnlyProperty();
    }

    public Node getContent() {
        return contentProperty().get();
    }
}
