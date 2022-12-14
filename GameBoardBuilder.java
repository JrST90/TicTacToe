package joshs.tictactoe;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameBoardBuilder 
{
    private final Label gameResult;
    
    private final Button topLeft, topCenter, topRight, middleLeft, middleCenter, 
    middleRight, bottomLeft, bottomCenter, bottomRight, reset, exit;
    
    private final Image xImage, oImage, blankImage ;
    private final ImageView[] xImageArray, oImageArray, blankImageArray;
    
    private final String[][] gameBoard;
    
    private Stage resultStage;
    private Scene resultScene;
    private final Scene gameScene;
    
    private int count = 0;
    private final Stage gameStage;
    private final BorderPane boardLayout;
    private HBox topRow, middleRow, bottomRow;
    private VBox resultBox;
   
    //Constructor for game board;
    public GameBoardBuilder()
    {
        this.gameBoard  = new String[3][3];
        this.blankImageArray = new ImageView[9];
        this.xImageArray = new ImageView[9];
        this.oImageArray = new ImageView[9];
        
        this.gameResult = new Label();
        this.gameStage = new Stage();
        this.boardLayout = new BorderPane();
        this.gameScene = new Scene(boardLayout);
        
        this.xImage = new Image("file:C:\\Users\\User\\FilePath\\images\\xMove.jpg");
        this.oImage = new Image("file:C:\\Users\\User\\FilePath\\images\\circleMove.jpg");
        this.blankImage = new Image("file:C:\\Users\\User\\FilePath\\images\\blankSpace.jpg");
        
        this.topLeft = new Button();   
        this.topCenter = new Button();
        this.topRight = new Button();
        this.middleLeft = new Button();
        this.middleCenter = new Button();
        this.middleRight = new Button();
        this.bottomLeft = new Button();
        this.bottomCenter = new Button();
        this.bottomRight = new Button();
        this.reset = new Button();
        this.exit = new Button();
    }
    
    //Set methods for constructor.
    public void setBoardBlank()
    {
         for(int i = 0; i < gameBoard.length; i++)
        {
            for(int j = 0; j < gameBoard.length; j++)
            {
                gameBoard[i][j] = " ";
            }
        }
         
        for(int i = 0; i < blankImageArray.length; i++)
        {
            blankImageArray[i] = new ImageView(blankImage);
            blankImageArray[i].setFitWidth(50);
            blankImageArray[i].setFitHeight(50);
        }
    }
    
    public void setXimageArray()
    {
        for(int i = 0; i <xImageArray.length; i++)
        {
            xImageArray[i] = new ImageView(xImage);
            xImageArray[i].setFitWidth(50);
            xImageArray[i].setFitHeight(50);
        }
    }
    
    public void setOimageArray()
    {
        for(int i = 0; i < oImageArray.length; i++)
        {
            oImageArray[i] = new ImageView(oImage);
            oImageArray[i].setFitWidth(50);
            oImageArray[i].setFitHeight(50);
        }
    }
    
    public void setButtonHandlers()
    {
        topLeft.setOnAction(new TopLeftButtonHandler());
        topCenter.setOnAction(new TopCenterButtonHandler());
        topRight.setOnAction(new TopRightButtonHandler());
        middleLeft.setOnAction(new MiddleLeftButtonHandler());
        middleCenter.setOnAction(new MiddleCenterButtonHandler());
        middleRight.setOnAction(new MiddleRightButtonHandler());
        bottomLeft.setOnAction(new BottomLeftButtonHandler());
        bottomCenter.setOnAction(new BottomCenterButtonHandler());
        bottomRight.setOnAction(new BottomRightButtonHandler());
        reset.setOnAction(new ResetButtonHandler());
        exit.setOnAction(new ExitButtonHandler());
        topLeft.setFocusTraversable(false);
        topCenter.setFocusTraversable(false);
        topRight.setFocusTraversable(false);
        middleLeft.setFocusTraversable(false);
        middleCenter.setFocusTraversable(false);
        middleRight.setFocusTraversable(false);
        bottomLeft.setFocusTraversable(false);
        bottomCenter.setFocusTraversable(false);
        bottomRight.setFocusTraversable(false);
    }
    
    public void setButtonEmptyGraphics()
    {
        topLeft.setGraphic(blankImageArray[0]);
        topCenter.setGraphic(blankImageArray[1]);
        topRight.setGraphic(blankImageArray[2]);
        middleLeft.setGraphic(blankImageArray[3]);
        middleCenter.setGraphic(blankImageArray[4]);
        middleRight.setGraphic(blankImageArray[5]);
        bottomLeft.setGraphic(blankImageArray[6]);
        bottomCenter.setGraphic(blankImageArray[7]);
        bottomRight.setGraphic(blankImageArray[8]);
    }
    
    public void setHbox()
    {
        topRow = new HBox(5, topLeft, topCenter, topRight);
        middleRow = new HBox(5, middleLeft, middleCenter, middleRight);
        bottomRow = new HBox(5, bottomLeft, bottomCenter, bottomRight);
    }
    
    public void setBoardLayout()
    {
        boardLayout.setTop(topRow);
        boardLayout.setCenter(middleRow);
        boardLayout.setBottom(bottomRow);
    }
    
    public void showBoard()
    {
        gameStage.setScene(gameScene);
        gameStage.setTitle("Tic Tac Toe");
        gameStage.show(); 
    }
    
    private void disableOnResult()
    {
        topLeft.setDisable(true); 
        topCenter.setDisable(true); 
        topRight.setDisable(true); 
        middleLeft.setDisable(true); 
        middleCenter.setDisable(true); 
        middleRight.setDisable(true); 
        bottomLeft.setDisable(true); 
        bottomCenter.setDisable(true); 
        bottomRight.setDisable(true);
    }
    
    private void activeOnReset()
    {
        topLeft.setDisable(false); 
        topCenter.setDisable(false); 
        topRight.setDisable(false); 
        middleLeft.setDisable(false); 
        middleCenter.setDisable(false); 
        middleRight.setDisable(false); 
        bottomLeft.setDisable(false); 
        bottomCenter.setDisable(false); 
        bottomRight.setDisable(false);
    }
    
    private void setInnerArrayEmpty()
    {
        for(int i = 0; i < gameBoard.length; i++)
            {
                for(int j = 0; j < gameBoard.length; j++)
                {
                    gameBoard[i][j] = " ";
                }
            }
    }
    
    private void setResultVbox()
    {
        reset.setText("New Game");
        exit.setText("Exit");
        resultBox = new VBox(5, gameResult, reset, exit);
        resultBox.setPadding(new Insets(5));
        resultBox.setAlignment(Pos.CENTER);
        resultStage = new Stage();
        resultScene = new Scene(resultBox);
    }
    
    //Event handlers for buttons.
    private class TopLeftButtonHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {     
            if(count % 2 == 0)
            {
               topLeft.setGraphic(xImageArray[0]);
               gameBoard[0][0] = "x";
               topLeft.setOnMouseClicked(e -> handleMouseClick());
               count++;
               topLeft.setDisable(true);
            }
            else
            {
               topLeft.setGraphic(oImageArray[0]);
               gameBoard[0][0] = "o";
               topLeft.setOnMouseClicked(e -> handleMouseClick());
               count++;
               topLeft.setDisable(true);
            }
        }
    }
    private class TopCenterButtonHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            if(count % 2 == 0)
            {
               topCenter.setGraphic(xImageArray[1]);
               gameBoard[0][1] = "x";
               topCenter.setOnMouseClicked(e -> handleMouseClick());
               count++;
               topCenter.setDisable(true);
            }
            else
            {
               topCenter.setGraphic(oImageArray[1]);
               gameBoard[0][1] = "o";
               topCenter.setOnMouseClicked(e -> handleMouseClick());
               count++;
               topCenter.setDisable(true);
            }
        }
    }
    private class TopRightButtonHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            if(count % 2 == 0)
            {
               topRight.setGraphic(xImageArray[2]);
               gameBoard[0][2] = "x";
               topRight.setOnMouseClicked(e -> handleMouseClick());
               count++;
               topRight.setDisable(true);
            }
            else
            {
               topRight.setGraphic(oImageArray[2]);
               gameBoard[0][2] = "o";
               topRight.setOnMouseClicked(e -> handleMouseClick());
               count++;
               topRight.setDisable(true);
            }
        }
    }
    private class MiddleLeftButtonHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            if(count % 2 == 0)
            {
               middleLeft.setGraphic(xImageArray[3]);
               gameBoard[1][0] = "x";
               middleLeft.setOnMouseClicked(e -> handleMouseClick());
               count++;
               middleLeft.setDisable(true);
            }
            else
            {
               middleLeft.setGraphic(oImageArray[3]);
               gameBoard[1][0] = "o";
               middleLeft.setOnMouseClicked(e -> handleMouseClick());
               count++;
               middleLeft.setDisable(true);
            }
        }
    }
    private class MiddleCenterButtonHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            if(count % 2 == 0)
            {
               middleCenter.setGraphic(xImageArray[4]);
               gameBoard[1][1] = "x";
               middleCenter.setOnMouseClicked(e -> handleMouseClick());
               count++;
               middleCenter.setDisable(true);
            }
            else
            {
               middleCenter.setGraphic(oImageArray[4]);
               gameBoard[1][1] = "o";
               middleCenter.setOnMouseClicked(e -> handleMouseClick());
               count++;
               middleCenter.setDisable(true);
            }
        }
    }
    private class MiddleRightButtonHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            if(count % 2 == 0)
            {
               middleRight.setGraphic(xImageArray[5]);
               gameBoard[1][2] = "x";
               middleRight.setOnMouseClicked(e -> handleMouseClick());
               count++;
               middleRight.setDisable(true);
            }
            else
            {
               middleRight.setGraphic(oImageArray[5]);
               gameBoard[1][2] = "o";
               middleRight.setOnMouseClicked(e -> handleMouseClick());
               count++;
               middleRight.setDisable(true);
            }
        }
    }
    private class BottomLeftButtonHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            if(count % 2 == 0)
            {
               bottomLeft.setGraphic(xImageArray[6]);
               gameBoard[2][0] = "x";
               bottomLeft.setOnMouseClicked(e -> handleMouseClick());
               count++;
               bottomLeft.setDisable(true);
            }
            else
            {
               bottomLeft.setGraphic(oImageArray[6]);
               gameBoard[2][0] = "o";
               bottomLeft.setOnMouseClicked(e -> handleMouseClick());
               count++;
               bottomLeft.setDisable(true);
            }
        }
    }
    private class BottomCenterButtonHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            if(count % 2 == 0)
            {
               bottomCenter.setGraphic(xImageArray[7]);
               gameBoard[2][1] = "x";
               bottomCenter.setOnMouseClicked(e -> handleMouseClick());
               count++;
               bottomCenter.setDisable(true);
            }
            else
            {
               bottomCenter.setGraphic(oImageArray[7]);
               gameBoard[2][1] = "o";
               bottomCenter.setOnMouseClicked(e -> handleMouseClick());
               count++;
               bottomCenter.setDisable(true);
            }
        }
    }
    private class BottomRightButtonHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            
            if(count % 2 == 0)
            {
               bottomRight.setGraphic(xImageArray[8]);
               gameBoard[2][2] = "x";
               bottomRight.setOnMouseClicked(e -> handleMouseClick());
               count++;
               bottomRight.setDisable(true);
            }
            else
            {
               
               bottomRight.setGraphic(oImageArray[8]);
               gameBoard[2][2] = "o";
               bottomRight.setOnMouseClicked(e -> handleMouseClick());
               count++;
               bottomRight.setDisable(true);
            }
        }
    }
    
    //Resets game board in event of new game.
    private class ResetButtonHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            resultStage.close();            
            setButtonEmptyGraphics();
            setInnerArrayEmpty();
            activeOnReset();
            setHbox();
            setBoardLayout();
            showBoard(); 
        }
    }
    private class ExitButtonHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            gameStage.close();
            resultStage.close();
        }
    }
    
    //Determines winner, displays result, gives user option to reset board.
    private void handleMouseClick()
    {
        boolean isDone = false;
        
        setResultVbox();
        
        if(Functions.checkXwinner(gameBoard) == false && Functions.checkOwinner(gameBoard) == true)
        {
            disableOnResult();
            isDone = true;
            count = 0;
            gameResult.setText("O wins!");
            resultStage.setScene(resultScene);
            resultStage.show();
        }
        else if(Functions.checkXwinner(gameBoard) == true && Functions.checkOwinner(gameBoard) == false)
        {
            disableOnResult();
            isDone = true;
            count = 0;
            gameResult.setText("X wins!");
            resultStage.setScene(resultScene);
            resultStage.show();   
        }
        else if(Functions.checkXwinner(gameBoard) == false && Functions.checkOwinner(gameBoard) == false && count == 9)
        {
            isDone = true;
            count = 0;
            gameResult.setText("Draw!");
            resultStage.setScene(resultScene);
            resultStage.show();
        }
    }    
}
