package factories;

import builders.OrcBuilder;
import builders.MordorOrcBuilder;
import builders.DolGuldurOrcBuilder;
import builders.MistyMountainsOrcBuilder;

public class OrcBuilderFactory {
     private final MordorGearFactory mordorGearFactory = new MordorGearFactory();
    private final DolGuldurGearFactory dolGuldurGearFactory = new DolGuldurGearFactory();
    private final MistyMountainsGearFactory mistyMountainsGearFactory = new MistyMountainsGearFactory();

    public OrcBuilder createMordorOrkBuilder() {
        return new MordorOrcBuilder(mordorGearFactory);
    }

    public OrcBuilder createDolGuldurOrkBuilder() {
        return new DolGuldurOrcBuilder(dolGuldurGearFactory);
    }

    public OrcBuilder createMistyMountainsOrkBuilder() {
        return new MistyMountainsOrcBuilder(mistyMountainsGearFactory);
    }
}