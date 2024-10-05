package name.ulbricht.javafx;

import java.net.URL;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import name.ulbricht.javafx.impl.Messages;
import name.ulbricht.javafx.ui.MainView;

public final class Main extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {

        final var mainView = MainView.load();
        final var scene = new Scene(mainView.getRoot());

        final var styles = Main.class.getResource("/name/ulbricht/javafx/ui/styles.css");
        scene.getStylesheets().add(styles.toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle(Messages.getString("primaryStage.title"));

        if (Platform.isSupported(ConditionalFeature.UNIFIED_WINDOW)) {
            primaryStage.initStyle(StageStyle.UNIFIED);
            scene.setFill(Color.TRANSPARENT);
        }

        primaryStage.getIcons().addAll(IntStream.of(32, 64) //
                .mapToObj(Integer::toString) //
                .map("/name/ulbricht/javafx/ui/img/app-%s.png"::formatted) //
                .map(Main.class::getResource) //
                .map(URL::toString) //
                .map(Image::new) //
                .toList());

        primaryStage.show();
    }
}