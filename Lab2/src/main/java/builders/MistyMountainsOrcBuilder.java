package builders;

import factories.OrcGearFactory;

public class MistyMountainsOrcBuilder extends OrcBuilder {
    public MistyMountainsOrcBuilder (OrcGearFactory gearFactory){
        super(gearFactory);
    }
    
    @Override
    public OrcBuilder setAttributes() {
        this.strength = 1 + (int)(Math.random() * 100);          
        this.agility = (int)(1 + Math.random() * 100 * 1.3);     
        this.intellect = 1 + (int)(Math.random() * 20);          
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
        return "Мглистые Горы";
    }
}
