
package director;

import factories.builder.*;
import model.*;

public class OrcDirector {
    public Orc createBasicOrc(OrcBuilderFactory builderFactory) {
        return builderFactory.createOrcBuilder().build();
    }

    public Orc createLeaderOrc(OrcBuilderFactory builderFactory) {
        Orc.OrcBuilder builder = builderFactory.createOrcBuilder();
        builder.setBanner(builder.banner + " и горн");
        return builder.build();
    }

    public Orc createScoutOrc(OrcBuilderFactory builderFactory) {
        Orc.OrcBuilder builder = builderFactory.createOrcBuilder();
        builder.setWeapon("Лук");
        return builder.build();
    }
}