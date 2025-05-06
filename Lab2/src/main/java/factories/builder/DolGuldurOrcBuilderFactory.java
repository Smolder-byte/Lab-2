
package factories.builder;

import factories.gear.*;
import model.*;

public class DolGuldurOrcBuilderFactory implements OrcBuilderFactory {
    @Override
    public Orc.OrcBuilder createOrcBuilder() {
        Orc.OrcBuilder builder = new Orc.OrcBuilder("Дол Гулдур");
        OrcGearFactory gearFactory = new DolGuldurGearFactory();
        builder.setWeapon(gearFactory.createWeapon());
        builder.setArmor(gearFactory.createArmor());
        builder.setBanner(gearFactory.createBanner());
        return builder;
    }
}