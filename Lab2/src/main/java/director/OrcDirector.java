
package director;

import factories.builder.*;
import model.*;

public class OrcDirector {
    public Orc createOrc(String tribe, String role) {
        OrcBuilderFactory factory = getBuilderFactory(tribe);
        return createOrcByRole(role, factory);
    }

    private OrcBuilderFactory getBuilderFactory(String tribe) {
        switch (tribe) {
            case "Мордор":
                return new MordorOrcBuilderFactory();
            case "Дол Гулдур":
                return new DolGuldurOrcBuilderFactory();
            case "Мглистые Горы":
                return new MistyMountainsOrcBuilderFactory();
            default:
                throw new IllegalArgumentException("Неизвестное племя: " + tribe);
        }
    }

    private Orc createOrcByRole(String role, OrcBuilderFactory factory) {
        if ("Командир".equals(role)) {
            return createLeaderOrc(factory);
        } else if ("Разведчик".equals(role)) {
            return createScoutOrc(factory);
        } else {
            return createBasicOrc(factory);
        }
    }

    private Orc createBasicOrc(OrcBuilderFactory factory) {
        return factory.createOrcBuilder().build();
    }

    private Orc createLeaderOrc(OrcBuilderFactory factory) {
        Orc.OrcBuilder builder = factory.createOrcBuilder();
        builder.setBanner(builder.banner + " и горн");
        return builder.build();
    }

    private Orc createScoutOrc(OrcBuilderFactory factory) {
        Orc.OrcBuilder builder = factory.createOrcBuilder();
        builder.setWeapon("Лук");
        return builder.build();
    }
}