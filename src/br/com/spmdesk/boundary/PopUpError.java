package br.com.spmdesk.boundary;

import java.lang.reflect.InvocationTargetException;

import br.com.spmdesk.interfaces.ChamarTela;
import br.com.spmdesk.utils.Background;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PopUpError implements EventHandler<ActionEvent>,ChamarTela{
	
	private String title;
	private String subTitle;
	private Stage stage;
	private String className;
	
	public PopUpError(String title, String subTitle, String className, Stage stage) {
		this.title = title;
		this.subTitle = subTitle;
		this.className = className;
		this.stage = stage;
		chamarTela(stage);
	}

	Button btnOk = new Button("OK");	
	@Override
	public void chamarTela(Stage stage) {
		BorderPane borderPrincipal = new BorderPane();
		Scene scene = new Scene(borderPrincipal);
		GridPane gPane = new GridPane();
		
		
		
		borderPrincipal.setMinSize(800, 500);
		borderPrincipal.setTop(Background.getBackground(800, 100));
		borderPrincipal.setCenter(gPane);
		borderPrincipal.setBottom(btnOk);
		
		gPane.add(new Label(title), 2, 1);
		gPane.add(new Label(subTitle), 2, 2);
		
		gPane.setVgap(15);
		gPane.setHgap(12);
		
		gPane.setAlignment(Pos.CENTER);
		
		StringBuilder css = new StringBuilder();
		css.append("-fx-background-image: url('/images/error.jpg') no-repeat; ");
		css.append("-fx-background-position: center; ");
		css.append("-fx-font-size: 30px; ");
		
		gPane.setStyle(css.toString());
		
		stage.addEventFilter(ActionEvent.ANY, this);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Ops Ocorreu um erro");
		stage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		if(event.getTarget().equals(btnOk)) {
			try {
				Class.forName(className).getConstructor(Stage.class).newInstance(stage);
			} catch (IllegalArgumentException | SecurityException | ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

}
