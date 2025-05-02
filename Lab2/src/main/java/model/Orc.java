package model;

import com.github.javafaker.Faker;

public class Orc {
    private String name;
    private String tribe;
    private String weapon;
    private String armor;
    private String banner;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;
    
    private Orc(OrcBuilder builder) {
        this.name = builder.name;
        this.tribe = builder.tribe;
        this.weapon = builder.weapon;
        this.armor = builder.armor;
        this.banner = builder.banner;
        this.strength = builder.strength;
        this.agility = builder.agility;
        this.intelligence = builder.intelligence;
        this.health = builder.health;
    }
    
    public String getName() { return name; }
    public String getTribe() { return tribe; }
    public String getWeapon() { return weapon; }
    public String getArmor() { return armor; }
    public String getBanner() { return banner; }
    public int getStrength() { return strength; }
    public int getAgility() { return agility; }
    public int getIntelligence() { return intelligence; }
    public int getHealth() { return health; }

    public static class OrcBuilder {
        private static Faker faker = new Faker();
        private String name;
        private String tribe;
        private String weapon;
        private String armor;
        public String banner;
        private int strength;
        private int agility;
        private int intelligence;
        private int health;

        public OrcBuilder(String tribe) {
            this.tribe = tribe;
            this.name = faker.lordOfTheRings().character();
            generateBaseAttributes();
        }
        
    private void generateBaseAttributes() {
    int baseStrength = (int)(1 + Math.random() * 100);
    int baseAgility = (int)(1 + Math.random() * 100);
    int baseIntelligence = (int)(1 + Math.random() * 50);
    int baseHealth = (int)(50 + Math.random() * 150);

    switch(tribe) {
        case "Мордор":
            this.strength = (int)(baseStrength * 1.3);  
            this.agility = (int)(baseAgility * 0.7);   
            this.intelligence = baseIntelligence;
            this.health = baseHealth;
            break;
            
        case "Дол Гулдур":
            this.strength = baseStrength;
            this.agility = baseAgility;
            this.intelligence = baseIntelligence;
            this.health = baseHealth;
            break;
            
        case "Мглистые Горы":
            this.strength = baseStrength;
            this.agility = (int)(baseAgility * 1.3);   
            this.intelligence = (int)(baseIntelligence * 0.7);
            this.health = baseHealth;
            break;
    }
    
    this.strength = Math.min(100, Math.max(1, this.strength));
    this.agility = Math.min(100, Math.max(1, this.agility));
    this.intelligence = Math.min(50, Math.max(1, this.intelligence));
    this.health = Math.min(200, Math.max(50, this.health));
    }

        public OrcBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public OrcBuilder setWeapon(String weapon) {
            this.weapon = weapon;
            return this;
        }

        public OrcBuilder setArmor(String armor) {
            this.armor = armor;
            return this;
        }

        public OrcBuilder setBanner(String banner) {
            this.banner = banner;
            return this;
        }

        public Orc build() {
            return new Orc(this);
        }
    }
}