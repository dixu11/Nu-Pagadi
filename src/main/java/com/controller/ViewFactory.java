package com.controller;

import com.game.Game;
import com.model.RecordManager;
import com.view.MainMenu;
import com.view.ScoresView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ViewFactory {

    private List<Stage> activeStages;
    private RecordManager recordManager;

    public ViewFactory() {
        activeStages = new ArrayList<>();
        recordManager = new RecordManager();
    }


    public void initializeStage(WindowType menu) {
        Stage stage = buildStage(menu);
        activeStages.add(stage);
        stage.show();
    }

    private Stage buildStage(WindowType type) {
        switch (type) {
            case MENU:
                MainMenu mainMenu = new MainMenu();
                MainMenuController mainMenuController = new MainMenuController(mainMenu,this);
                return mainMenu;
            case SCORES:
                return new ScoresView(recordManager);
            case GAME:
               return new Game(recordManager, this);
        }
        return null;
    }

    public void closeStage(Stage stageToClose) {
        stageToClose.close();
        activeStages.remove(stageToClose);
    }





}
