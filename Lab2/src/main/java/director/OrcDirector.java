
package director;

import factories.builder.*;
import model.*;

public class OrcDirector {
    public Orc createBasicOrk(OrcBuilderFactory builderFactory) {
        return builderFactory.createOrcBuilder().build();
    }

    public Orc createLeaderOrk(OrcBuilderFactory builderFactory) {
        Orc.OrcBuilder builder = builderFactory.createOrcBuilder();
        builder.setBanner(builder.banner + " и горн");
        return builder.build();
    }

    public Orc createScoutOrk(OrcBuilderFactory builderFactory) {
        Orc.OrcBuilder builder = builderFactory.createOrcBuilder();
        builder.setWeapon("Лук");
        return builder.build();
    }
}