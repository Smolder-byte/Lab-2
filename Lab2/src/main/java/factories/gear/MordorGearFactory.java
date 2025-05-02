
package factories.gear;


public class MordorGearFactory implements OrcGearFactory {
    @Override
    public String createWeapon() { return "Тяжелый меч"; }
    @Override
    public String createArmor() { return "Стальная броня"; }
    @Override
    public String createBanner() { return "Знамя с Красным Оком"; }
}
