package builders;

import factories.OrcGearFactory;

public class MordorOrcBuilder extends OrcBuilder {
     public MordorOrcBuilder(OrcGearFactory gearFactory){
        super(gearFactory);
    }
     
    @Override
    public OrcBuilder setAttributes() {
        this.strength = (int)(1 + Math.random() * 100 * 1.3);
        this.agility = 1 + (int)(Math.random() * 40);
        this.intellect = 1 + (int)(Math.random() * 50);
        this.health = 50 + (int)(Math.random() * 151);
        return this;
    }

    @Override
    public OrcBuilder setEquipment() {
        this.weapon = gearFactory.createWeapon();
        this.armor = gearFactory.createArmor();
        this.banner = gearFactory.createBanner();
        return this;
    }

    @Override
    protected String getTribeName() {
        return "Мордор";
    }
}