package com.exercice.views;

import com.exercice.models.Post;

import java.util.List;

public class PostView {
    public static void postView() {
        System.out.println("------------------------------------------"
                + "\n Vous êtes dans la section Post"
                + "\n ------------------------"
                + "\n Quelle action désirez vous exécuter ?"
                + "\n 1 : Ajouter un post"
                + "\n 2 : Voir la liste des posts existants"
                + "\n 3 : Obtenir des informations sur un post en particulier"
                + "\n 4 : Modifier un post en particulier"
                + "\n 5 : Supprimer un post en particulier"
                + "\n return  : Retourner au menu principal"
                + "\n ------------------------------------------"
        );
    }

    public static void creationPost() {
        System.out.println("Menu creation de post"
                + "\n ------------------------"
                + "\n Ecrivez le titre d'un post :"
        );
    }

    public static void printAllPosts(List<Post> posts) {
        for(Post post : posts) {
            System.out.println(post.toString());
        }
    }

    public static void suppressionPost() {
        System.out.println("Tapez le nom d'un groupe à supprimer");
    }
}
