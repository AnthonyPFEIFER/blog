package com.exercice.services;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilitaires {
    public static String saisieString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public static int saisieInt() {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        try {
            i = sc.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Erreur de saisie");
        }
        finally {
            return i;
        }
    }
}
