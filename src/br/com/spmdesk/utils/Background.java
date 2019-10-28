package br.com.spmdesk.utils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class Background {
	
	public static BorderPane getBackground(double largura, double altura) {
		BorderPane header = new BorderPane();
		header.setMinSize(largura, altura);
		header.setStyle("-fx-background-color:#1A1842");
		StackPane sp = new StackPane();
		Image img = new Image("/images/monke.png");
		ImageView imgView = new ImageView(img);
		sp.getChildren().add(imgView);
		header.setLeft(imgView);
		return header;
	}
	
}
