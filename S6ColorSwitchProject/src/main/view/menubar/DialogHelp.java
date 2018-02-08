package main.view.menubar;

import javafx.event.EventHandler;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogEvent;
import javafx.scene.layout.Pane;
import javafx.stage.WindowEvent;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class DialogHelp extends Dialog<Scene>{
	public DialogHelp(){
		this.setGraphic(new Label("Projet realise par PITROU Adrien, CALVO-FERNANDEZ Adelie et BARRECH Mehdi"));
		this.setWidth(200);
		this.setHeight(200);
		this.setTitle("Ma boite");
		this.show();
		/*this.setOnHiding(new EventHandler<DialogEvent>() {
            @Override
            public void handle(final DialogEvent event) {
				DialogHelp d = (DialogHelp)event.getSource();
				d.close();
			}
        });
		this.setOnCloseRequest(new EventHandler<DialogEvent>() {
            @Override
            public void handle(final DialogEvent event) {
				DialogHelp d = (DialogHelp)event.getSource();
				d.close();
			}
        });*/
	}
}
