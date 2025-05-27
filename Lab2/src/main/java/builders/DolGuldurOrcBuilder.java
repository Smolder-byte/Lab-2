package builders;

import factories.OrcGearFactory;


public class DolGuldurOrcBuilder extends OrcBuilder {
    public DolGuldurOrcBuilder(OrcGearFactory gearFactory){
        super(gearFactory);
    }

    @Override
    public OrcBuilder setAttributes() {
        this.strength = 1 + (int)(Math.random() * 100);   
        this.agility = 1 + (int)(Math.random() * 100);    
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
        return "Дол Гулдур";
    }
}