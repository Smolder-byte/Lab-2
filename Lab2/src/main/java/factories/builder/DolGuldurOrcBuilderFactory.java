
package factories.builder;

import factories.gear.*;
import model.*;

public class DolGuldurOrcBuilderFactory implements OrcBuilderFactory {
    @Override
    public Orc.OrcBuilder createOrcBuilder() {
        Orc.OrcBuilder builder = new Orc.OrcBuilder("Дол Гулдур");
        OrcGearFactory gearFactory = new DolGuldurGearFactory();
        builder.setWeapon(gearFactory.createWeapon())
               .setArmor(gearFactory.createArmor())
               .setBanner(gearFactory.createBanner());
        return builder;
    }
}