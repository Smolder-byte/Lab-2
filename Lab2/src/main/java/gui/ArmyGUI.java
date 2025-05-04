package gui;

import director.*;
import factories.builder.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Orc;

public class ArmyGUI extends JFrame {
    private JTree armyTree;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode rootNode;
    private Map<String, List<Orc>> army;
    private OrcDirector director;
    private JPanel infoPanel;

    public ArmyGUI() {
        army = new HashMap<String, List<Orc>>();
        director = new OrcDirector();
        
        setTitle("Армия Саурона");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        rootNode = new DefaultMutableTreeNode("Армия Мордора");
        treeModel = new DefaultTreeModel(rootNode);
        armyTree = new JTree(treeModel);
        add(new JScrollPane(armyTree), BorderLayout.WEST);

        JPanel controlPanel = new JPanel(new GridLayout(3, 2));
        String[] tribes = {"Мордор", "Дол Гулдур", "Мглистые Горы"};
        final JComboBox<String> tribeCombo = new JComboBox<String>(tribes);
        String[] roles = {"Базовый", "Командир", "Разведчик"};
        final JComboBox<String> roleCombo = new JComboBox<String>(roles);
        JButton createButton = new JButton("Создать орка");

        controlPanel.add(new JLabel("Племя:"));
        controlPanel.add(tribeCombo);
        controlPanel.add(new JLabel("Роль:"));
        controlPanel.add(roleCombo);
        controlPanel.add(new JLabel(""));
        controlPanel.add(createButton);

        add(controlPanel, BorderLayout.NORTH);

        infoPanel = new JPanel(new GridLayout(6, 2));
        add(infoPanel, BorderLayout.CENTER);

        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tribe = (String) tribeCombo.getSelectedItem();
                String role = (String) roleCombo.getSelectedItem();
                Orc orc = createOrc(tribe, role);
                addOrcToTree(orc);
            }
        });

        armyTree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) armyTree.getLastSelectedPathComponent();
               if (node != null && node.getUserObject() instanceof Orc) {
                    displayOrcInfo((Orc) node.getUserObject());
               }
            }
        });
    }

    private Orc createOrc(String tribe, String role) {
        OrcBuilderFactory factory = getBuilderFactory(tribe);
        if ("Командир".equals(role)) {
            return director.createLeaderOrc(factory);
        } else if ("Разведчик".equals(role)) {
            return director.createScoutOrc(factory);
        } else {
            return director.createBasicOrc(factory);
        }
    }

    private OrcBuilderFactory getBuilderFactory(String tribe) {
        if ("Мордор".equals(tribe)) {
            return new MordorOrcBuilderFactory();
        } else if ("Дол Гулдур".equals(tribe)) {
            return new DolGuldurOrcBuilderFactory();
        } else if ("Мглистые Горы".equals(tribe)) {
            return new MistyMountainsOrcBuilderFactory();
        }
        throw new IllegalArgumentException("Неизвестное племя");
    }

    private void addOrcToTree(Orc orc) {
        String tribe = orc.getTribe();
        if (!army.containsKey(tribe)) {
            army.put(tribe, new ArrayList<Orc>());
        }
        army.get(tribe).add(orc);
        
        DefaultMutableTreeNode tribeNode = findOrCreateTribeNode(tribe);
            DefaultMutableTreeNode orcNode = new DefaultMutableTreeNode(orc);
    tribeNode.add(orcNode);
    
    treeModel.reload();
    }

    private DefaultMutableTreeNode findOrCreateTribeNode(String tribe) {
        for (int i = 0; i < rootNode.getChildCount(); i++) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) rootNode.getChildAt(i);
            if (tribe.equals(node.toString())) {
                return node;
            }
        }
        
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(tribe);
        rootNode.add(newNode);
        return newNode;
    }

    private void displayOrcInfo(Orc orc) {
        infoPanel.removeAll();
        
        infoPanel.add(new JLabel("Имя: " + orc.getName()));
        
        JProgressBar strengthBar = new JProgressBar(0, 100);
        strengthBar.setValue(orc.getStrength());
        strengthBar.setString("Сила: " + orc.getStrength());
        strengthBar.setStringPainted(true);
        infoPanel.add(strengthBar);
        
        infoPanel.add(new JLabel("Племя: " + orc.getTribe()));
        
        JProgressBar agilityBar = new JProgressBar(0, 100);
        agilityBar.setValue(orc.getAgility());
        agilityBar.setString("Ловскость: " + orc.getAgility());
        agilityBar.setStringPainted(true);
        infoPanel.add(agilityBar);
        
        infoPanel.add(new JLabel("Оружие: " + orc.getWeapon()));
        
        JProgressBar intelligenceBar = new JProgressBar(0, 100);
        intelligenceBar.setValue(orc.getIntelligence());
        intelligenceBar.setString("Интеллект: " + orc.getIntelligence());
        intelligenceBar.setStringPainted(true);
        infoPanel.add(intelligenceBar);
        
        infoPanel.add(new JLabel("Броня: " + orc.getArmor()));
        
        JProgressBar healthBar = new JProgressBar(0, 200);
        healthBar.setValue(orc.getHealth());
        healthBar.setString("Здоровье: " + orc.getHealth());
        healthBar.setStringPainted(true);
        infoPanel.add(healthBar);
        
        infoPanel.add(new JLabel("Знамя: " + orc.getBanner()));
        
        infoPanel.revalidate();
    }
}