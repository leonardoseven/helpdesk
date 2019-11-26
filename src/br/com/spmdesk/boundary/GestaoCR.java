package br.com.spmdesk.boundary;
 
import java.util.ArrayList;

import br.com.smpdesk.control.GestaoCRControl;
import br.com.spmdesk.entity.Chamado;
import br.com.spmdesk.entity.Requisicao;
import br.com.spmdesk.entity.Usuario;
import br.com.spmdesk.interfaces.ChamarTela;
import br.com.spmdesk.utils.Background;
import br.com.spmdesk.utils.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GestaoCR implements EventHandler<ActionEvent>, ChamarTela {
    private Stage stage;
   
    private GestaoCRControl gestaoControl = new GestaoCRControl();
    
    ArrayList<Chamado> listaChamado = gestaoControl.getAllChamado();
    ArrayList<Requisicao> listaRequisicao = gestaoControl.getAllRequisicao();
    
     private TableView<Chamado> tableCha= new TableView<Chamado>();
     private final ObservableList<Chamado> data =
    	        FXCollections.observableArrayList(listaChamado);
     private TableView<Requisicao> tableReq = new TableView<Requisicao>();
     private final ObservableList<Requisicao> data2 =
    	        FXCollections.observableArrayList(listaRequisicao);
     
   
     
    

    public GestaoCR(Stage stage) {
        chamarTela(stage);
        this.stage = stage;
    }
Button btnVoltar = new Button("Voltar");

    @Override
    public void chamarTela(Stage stage) {
        BorderPane border = new BorderPane();
        Scene scene = new Scene(border);
        GridPane gridpane = new GridPane();
        GridPane gridpaneRigth = new GridPane();
        GridPane gridpaneLeft = new GridPane();
        FlowPane bottom = new FlowPane();

        border.setMinSize(800, 500);
        bottom.getChildren().add(btnVoltar);

         TableColumn req = new TableColumn("Requisição");
         req.setCellValueFactory(
        	       new PropertyValueFactory<Requisicao, String>("assunto"));
         TableColumn solicitanteReq = new TableColumn("Solicitante");
         solicitanteReq.setCellValueFactory(
      	       new PropertyValueFactory<Requisicao, String>("solicitante"));
         TableColumn descReq = new TableColumn("Descrição");
         descReq.setCellValueFactory(
      	       new PropertyValueFactory<Requisicao, String>("descricao"));
         TableColumn setorReq = new TableColumn("Setor");
         setorReq.setCellValueFactory(
      	       new PropertyValueFactory<Requisicao, String>("setor"));

         req.setMinWidth(100);
         solicitanteReq.setMinWidth(100);
         descReq.setMinWidth(100);
         setorReq.setMinWidth(100);
         tableReq.setItems(data2);
         tableReq.getColumns().addAll(req, solicitanteReq, descReq,setorReq);
         tableReq.setMinSize(380,130);

         TableColumn cham = new TableColumn("Chamado");
         cham.setCellValueFactory(
        	       new PropertyValueFactory<Chamado, String>("assunto"));
         TableColumn solicitanteCha = new TableColumn("Solicitante");
         solicitanteCha.setCellValueFactory(
        	       new PropertyValueFactory<Chamado, String>("solicitante"));
         TableColumn descCha = new TableColumn("Descrição");
         descCha.setCellValueFactory(
        	       new PropertyValueFactory<Chamado, String>("descricao"));
         TableColumn setorCha= new TableColumn("Setor");
         setorCha.setCellValueFactory(
        	       new PropertyValueFactory<Chamado, String>("setor"));
         cham.setMinWidth(100);
         solicitanteCha.setMinWidth(100);
         descCha.setMinWidth(100);
         setorCha.setMinWidth(100);
         tableCha.setItems(data);
         tableCha.getColumns().addAll(cham, solicitanteCha, descCha,setorCha);
         tableCha.setMinSize(380,130);
gridpane.add(tableReq, 0, 0);
         gridpane.add(tableCha, 1, 0);

//        gridpane.add(new Label("Requisitos e chamados ativos:"),0,0);
//        gridpane.add(new Label("Tipo (chamado ou requisiÃ§Ã£o)"),0,1);
//        gridpane.add(new Label("Solicitante"),1,1);
//        gridpane.add(new Label("Descriï¿½ï¿½o "),2,1);
//        gridpane.add(new Label("Setor"),3,1);

        gridpaneRigth.setHgap(5);
        gridpaneRigth.setVgap(5);

        gridpane.setHgap(20);
        gridpane.setVgap(20);

        gridpane.setAlignment(Pos.CENTER);

        border.setTop(Background.getBackground(800, 100));
        gridpaneLeft.setMinSize(10,10);
        gridpaneRigth.setMinSize(10, 10);
        border.setCenter(gridpane);
        border.setRight(gridpaneRigth);
        border.setLeft(gridpaneLeft);
        border.setBottom(bottom);

        stage.addEventFilter(ActionEvent.ANY, this);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Gestão de CR");
        stage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getTarget().equals(btnVoltar)) {
            Usuario usuario = User.getUsuario();
            if("inspetor".equals(usuario.getTipo())) {
                new MainScreenInspetor(stage);
            }
            else {
                new MainScreenAdmin(stage);
            }
        }
    }

}