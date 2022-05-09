package com.exercice.controllers;

import com.exercice.services.Utilitaires;
import com.exercice.views.MenuView;

public class MenuController {

    PostController postController = new PostController();
    CommentController commentController = new CommentController();
    TagController tagController = new TagController();
    boolean applicationIsOn = true;
    public MenuController() {
    }

    public void runMenu() {
        MenuView.bienvenue();
        do{
            MenuView.menuView();
            switch (Utilitaires.saisieString()) {
                case "1" :
                    postController.postMenu();
                    break;
/*                case "2" :
                    commentController.tagMenu();
                    break;
                case "3" :
                    tagController.tagMenu();
                    break;*/
                case "exit" :
                    applicationIsOn = false;
                    break;
            }
        }while(applicationIsOn);
    }
}
