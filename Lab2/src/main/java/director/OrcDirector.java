package director;

import model.ArmyTree;
import model.Orc;
import factories.OrcBuilderFactory;
import builders.OrcBuilder;
import factories.gear.Bow;
import factories.gear.Horn;

public class OrcDirector {
    private final OrcBuilderFactory builderFactory = new OrcBuilderFactory();
    private final ArmyTree armyTree;

    public OrcDirector(ArmyTree armyTree) {
        this.armyTree = armyTree;
    }

    public Orc createBasicOrk(String tribe) {
        OrcBuilder builder = getBuilderForTribe(tribe);
        builder.setRandomName().setType("Базовый орк").setAttributes().setEquipment();
        Orc ork = builder.build();
        return finalizeOrk(new Orc(
            ork.getName(), ork.getTribe(), ork.getType(),
            ork.getWeapon(),
            ork.getArmor(),
            null,
            ork.getStrength(),
            ork.getAgility(),
            ork.getIntellect(),
            ork.getHealth()
        ));
    }

    public Orc createLeaderOrk(String tribe) {
        OrcBuilder builder = getBuilderForTribe(tribe);
        builder.setRandomName().setType("Командир").setAttributes().setEquipment();
        Orc ork = builder.build();
        return finalizeOrk(new Orc(
            ork.getName(), ork.getTribe(), ork.getType(),
            new Horn(),
            ork.getArmor(),
            ork.getBanner(),
            ork.getStrength(),
            ork.getAgility(),
            ork.getIntellect(),
            ork.getHealth()
        ));
    }

    public Orc createScoutOrk(String tribe) {
        OrcBuilder builder = getBuilderForTribe(tribe);
        builder.setRandomName().setType("Разведчик").setAttributes().setEquipment();
        Orc ork = builder.build();
        return finalizeOrk(new Orc(
            ork.getName(), ork.getTribe(), ork.getType(),
            new Bow(),
            ork.getArmor(),
            null,
            ork.getStrength(),
            ork.getAgility(),
            ork.getIntellect(),
            ork.getHealth()
        ));
    }

    private OrcBuilder getBuilderForTribe(String tribe) {
        return switch(tribe) {
            case "Дол Гулдур" -> builderFactory.createDolGuldurOrkBuilder();
            case "Мглистые Горы" -> builderFactory.createMistyMountainsOrkBuilder();
            default -> builderFactory.createMordorOrkBuilder();
        };
    }

    private Orc finalizeOrk(Orc ork) {
        armyTree.addOrk(ork);
        return ork;
    }
}