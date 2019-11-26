package br.com.spmdesk.boundary;
 
import br.com.spmdesk.entity.Componente;
import br.com.spmdesk.entity.Usuario;
import br.com.spmdesk.interfaces.ChamarTela;
import br.com.spmdesk.utils.Background;
import br.com.spmdesk.utils.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GestaoEstoque implements EventHandler<ActionEvent>, ChamarTela {
	private Stage stage;
	Usuario usuario = User.getUsuario();

	 private TableView<Componente> table = new TableView<Componente>();
	
	public GestaoEstoque(Stage stage) {
		chamarTela(stage);
		this.stage = stage;
	}

	Button btnVoltar = new Button("Voltar");
	Button btnCadastro = new Button("Novo Componente");

	@Override
	public void chamarTela(Stage stage) {
		BorderPane border = new BorderPane();
		Scene scene = new Scene(border);
		GridPane gridpane = new GridPane();
		GridPane gridpaneRigth = new GridPane();
		FlowPane bottom = new FlowPane();

		border.setMinSize(800, 500);
		bottom.getChildren().add(btnVoltar);
		
		 TableColumn nomeComp = new TableColumn("Componente");
		 TableColumn desc = new TableColumn("Descrição");
		 TableColumn preco = new TableColumn("Preço");
		 TableColumn qtd = new TableColumn("Quantidade");
		 
		 nomeComp.setMinWidth(100);
		 desc.setMinWidth(140);
		 preco.setMinWidth(100);
		 qtd.setMinWidth(100);
		 table.getColumns().addAll(nomeComp, desc, preco,qtd);
		 System.out.println();
		 table.setMinSize(500,180);
		 gridpane.add(table, 0, 0);
		 gridpane.add(btnCadastro, 0, 1);
//		gridpane.add(new Label("UsuÃ¡rios Estoque:"), 0, 0);
//		gridpane.add(new Label("Nome do componente"), 0, 1);
//		gridpane.add(new Label("Setor responsavel"), 1, 1);
//		gridpane.add(new Label("Quantidade minima permitida"), 2, 1);
//		gridpane.add(new Label("Quantidade atual"), 3, 1);

		gridpaneRigth.setHgap(5);
		gridpaneRigth.setVgap(5);

		gridpane.setHgap(20);
		gridpane.setVgap(10);

		gridpane.setAlignment(Pos.CENTER);

		border.setTop(Background.getBackground(800, 100));
		border.setCenter(gridpane);
		border.setRight(gridpaneRigth);
		border.setBottom(bottom);

		stage.addEventFilter(ActionEvent.ANY, this);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Gestï¿½o de Estoque");
		stage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget().equals(btnVoltar)) {
			if (event.getTarget().equals(btnVoltar)) {
				if ("inspetor".equals(usuario.getTipo())) {
					new MainScreenInspetor(stage);
				} else {
					new MainScreenAdmin(stage);
				}
			} else if (event.getTarget().equals(btnCadastro)) {
				new CadastroScreen(stage);
			}

		}

	}
}
