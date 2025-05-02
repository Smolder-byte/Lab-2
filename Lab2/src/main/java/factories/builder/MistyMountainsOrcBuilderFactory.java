
package factories.builder;

import factories.gear.*;
import model.*;

public class MistyMountainsOrcBuilderFactory implements OrcBuilderFactory {
    @Override
    public Orc.OrcBuilder createOrcBuilder() {
        Orc.OrcBuilder builder = new Orc.OrcBuilder("Мглистые Горы");
        OrcGearFactory gearFactory = new MistyMountainsGearFactory();
        builder.setWeapon(gearFactory.createWeapon());
        builder.setArmor(gearFactory.createArmor());
        builder.setBanner(gearFactory.createBanner());
        return builder;
    }
}