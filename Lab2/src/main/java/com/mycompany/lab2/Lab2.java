package com.mycompany.lab2;

import director.OrcDirector;
import gui.GUI;
import javax.swing.*;
import model.ArmyTree;

public class Lab2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ArmyTree armyTree = new ArmyTree();
                OrcDirector director = new OrcDirector(armyTree);
                GUI gui = new GUI(director, armyTree);
                gui.setVisible(true);
            }
        });
    }
}