import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.stream.Stream;

public class GraphicUI extends Application{


    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Repository r = new Repository();
        primaryStage.setTitle("PacMan 2000");
        primaryStage.setHeight(240);
        primaryStage.setWidth(220);
        StackPane layout = new StackPane();


        int myr=0;
        int[][] c;

        VBox vBox = new VBox();
        Arrays.stream(r.mat)

                .forEach(
                        (row)-> {
                            HBox hbox = new HBox();
                            long count = Stream.of(row)
                                    .count();
                            Arrays.stream(row)
                                    .forEach((el) -> {
                                        if(el!=0) {
                                            Rectangle wall = new Rectangle(20, 20, Color.MEDIUMBLUE);
                                            wall.setX(count * 20);
                                            long y = el;
                                            wall.setY(y * 20);
                                            hbox.getChildren().add(wall);
                                        }
                                        else {
                                            Rectangle road = new Rectangle(20, 20, Color.BLACK);
                                            road.setX(count * 20);
                                            long y = el;
                                            road.setY(y * 20);
                                            hbox.getChildren().add(road);
                                        }
                                    });
                            vBox.getChildren().add(hbox);
                        }
                );
        final int[] newY = new int[1];
        final int[] newX = {0};
        Circle dude = new Circle(30,170,10.0f, Color.ORANGE);
        Rectangle phantom1 = new Rectangle(20, 20, Color.RED);
        Rectangle phantom2 = new Rectangle(20, 20, Color.CYAN);

        phantom1.setX(40);
        phantom1.setY(20);

        final int[] p1X = {2};
        final int[] p1Y = {8};

        final int[] newnr = new int[1];
//        phantom2.setX(160);
//        phantom2.setY(20);

        final int[] curX = {1};
        final int[] curY = {1};
        Pane pane = new Pane();
        pane.getChildren().addAll(dude);
        pane.getChildren().addAll(phantom1);
//        pane.getChildren().addAll(phantom2);

        layout.getChildren().add(vBox);
        layout.getChildren().add(pane);
        Scene scene = new Scene(layout,220,220, Color.WHITE);

        scene.setOnKeyPressed(e ->{
            if((e.getCode() == KeyCode.RIGHT) && r.mat[curX[0] +1][curY[0]]==0){
                newX[0] = newX[0] + 20;
                dude.setTranslateX(newX[0]);
                curX[0]++;
                System.out.println("PosHuman " + curX[0]+","+curY[0]);

                if(Repository.sameSpot(p1X[0], p1Y[0],curX[0],curY[0])) {
                    System.out.println("P1");
                }
                newnr[0] =r.botThread();
                if(Repository.valid(p1X[0] +newnr[0], p1Y[0])) {
                    p1X[0]++;
                    phantom1.setTranslateX(+20);
                }
                else if(Repository.valid(p1X[0], p1Y[0] +newnr[0])) {
                    p1Y[0]++;
                    phantom1.setTranslateY(+20);
                }

                System.out.println("PosBot " + p1X[0]+","+p1Y[0]);
            }
            else if((e.getCode() == KeyCode.LEFT)&& r.mat[curX[0] -1][curY[0]]==0){
                newX[0] = newX[0] - 20;
                dude.setTranslateX(newX[0]);
                curX[0]--;
                System.out.println("PosHuman " + curX[0]+","+curY[0]);

                if(Repository.sameSpot(p1X[0], p1Y[0],curX[0],curY[0])) {
                    System.out.println("P1");
                }
                if(Repository.valid(p1X[0] +newnr[0], p1Y[0])) {
                    p1X[0]++;
                    phantom1.setTranslateX(+20);
                }
                else if(Repository.valid(p1X[0], p1Y[0] +newnr[0])) {
                    p1Y[0]++;
                    phantom1.setTranslateY(+20);
                }
                System.out.println("PosBot " + p1X[0]+","+p1Y[0]);

            }
            else if((e.getCode() == KeyCode.UP)&& r.mat[curX[0]][curY[0] +1]==0){
                newY[0] = newY[0] - 20;
                dude.setTranslateY(newY[0]);
                curY[0]++;
                System.out.println("PosHuman " + curX[0]+","+curY[0]);


                if(Repository.sameSpot(p1X[0], p1Y[0],curX[0],curY[0])) {
                    System.out.println("P1");
                }
                if(Repository.valid(p1X[0] +newnr[0], p1Y[0])) {
                    p1X[0]++;
                    phantom1.setTranslateX(+20);
                }
                else if(Repository.valid(p1X[0], p1Y[0] +newnr[0])) {
                    p1Y[0]++;
                    phantom1.setTranslateY(+20);
                }
                System.out.println("PosBot " + p1X[0]+","+p1Y[0]);

            }
            else if((e.getCode() == KeyCode.DOWN)&& r.mat[curX[0]][curY[0] -1]==0){
                newY[0] = newY[0] + 20;
                dude.setTranslateY(newY[0]);
                curY[0]--;
                System.out.println("PosHuman " + curX[0]+","+curY[0]);


                if(Repository.sameSpot(p1X[0], p1Y[0],curX[0],curY[0])) {
                    System.out.println("P1");
                }

                if(Repository.valid(p1X[0] +newnr[0], p1Y[0])) {
                    p1X[0]++;
                    phantom1.setTranslateX(+20);
                }
                else if(Repository.valid(p1X[0], p1Y[0] +newnr[0])) {
                    p1Y[0]++;
                    phantom1.setTranslateY(+20);
                }
                System.out.println("PosBot " + p1X[0]+","+p1Y[0]);

            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
