package src;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

import static javafx.application.Application.launch;

public class GUI {
    private Random r;
    private String message1 = "Your coaching team approaches you asking about whether\ninvestments can be made to the " +
            "training ground, since some \ninstruments have been found to not be up to the standards \nthat the club upholds." +
            " Do you want to make these upgrades?";
    private String effect1 = "-$300 & +10 M";
    private String message2 = "Your assistant manager approaches you with a scouting report, its of a ";
    private String message3 = " years \nold who could be a good boost to our team. I'm not sure about his attitude though, so" +
            " he could either \nbe a great asset or someone who brings the mood down amongst the squad. Final call's up to you though" +
            " \nfor this one. What do you say? Should we sign him up?";
    private String effect2 = "-$700 & +15 M or -10 M";
    private String message4 = "Hey boss, wanted to make an ask of something. The lads and I have been working \npretty hard in " +
            "training this last week, and we're all burnt out because of it.\nWe were wondering if it were possible for us to get" +
            " the day off from training. I know \nthis is last minute, and would result in the team having a lit of loss in terms" +
            " of money,\nbut its something we would all benefit from greatly. Final choice is of course, up to you boss";
    private String effect4 = "-$60 & +5 M";
    private String message5 = "Hey boss, wanted to make an ask of something.Just wanted to tell you about a dispute that occured" +
            " recently.\nOne of our players were involved in a speeding violation. It would cause an issue if this situation were" +
            " to come out to the press.\nSo, we can take care of the issue by spending some money. Final choice is of course, up to you boss";
    private String effect51 = "-$900";
    private String effect52 = "-20 M";

    public void start(Stage primaryStage, int situation) throws IOException {
        primaryStage.setTitle("Training");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        if(situation == 1) {
            Text training = new Text(message1);
            training.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
            grid.add(training, 0, 0, 2, 1);
            Text yTrain = new Text(effect1);
            grid.add(yTrain, 0, 2);
            Text nTrain = new Text("No effect");
            grid.add(nTrain, 3, 2);
            Button Yes = new Button("Yes");
            HBox hbBtn = new HBox(10);
            hbBtn.setAlignment(Pos.BOTTOM_LEFT);
            hbBtn.getChildren().add(Yes);
            grid.add(hbBtn, 0, 3);
            Yes.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    System.out.println("Training occured");
                }
            });
            Button No = new Button("No");
            HBox hbBtn1 = new HBox(10);
            hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
            hbBtn1.getChildren().add(No);
            grid.add(hbBtn1, 3, 3);
            No.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    System.out.println("Training did not happen");
                }
            });
        }
        else if (situation == 2) {
            int age = r.nextInt(17, 43);
            Text buyPlayer = new Text(message1);
            buyPlayer.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
            grid.add(buyPlayer, 0, 0, 2, 1);
            Text yTrain = new Text(effect1);
            grid.add(yTrain, 0, 2);
            Text nTrain = new Text("No effect");
            grid.add(nTrain, 3, 2);
            Button Yes = new Button("Yes");
            HBox hbBtn = new HBox(10);
            hbBtn.setAlignment(Pos.BOTTOM_LEFT);
            hbBtn.getChildren().add(Yes);
            grid.add(hbBtn, 0, 3);
            Yes.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    System.out.println("Training occured");
                }
            });
            Button No = new Button("No");
            HBox hbBtn1 = new HBox(10);
            hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
            hbBtn1.getChildren().add(No);
            grid.add(hbBtn1, 3, 3);
            No.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    System.out.println("Training did not happen");
                }
            });
        }
        Scene scene = new Scene(grid, 500, 275);
        primaryStage.setScene(scene);
        scene.getStylesheets().add
                (src.Actions.class.getResource("GameStyle.css").toExternalForm());
        primaryStage.show();
    }

    public static void main(String[] args) {
        System.out.println("Test");
        launch();
    }
}
