package factory;

import model.AbstractHero;
import model.HeroStatistics;
import model.SuperHero;
import model.TeamType;
import model.Villlain;
import util.PropertiesUtils;

public class VillainCreator implements HeroCreator {

  PropertiesUtils propertiesUtils = PropertiesUtils.getInstance();

  public AbstractHero createHero(String name, HeroStatistics stats, TeamType type) {
    return new Villlain(name, stats, type);
  }

  public AbstractHero createHeroWithDefaultStats(String name, TeamType type) {
    int strength = propertiesUtils
        .getPropertyValue("config.villain.defaultStrength");
    int health = propertiesUtils
        .getPropertyValue("config.villain.defaultHealth");
    int defense = propertiesUtils
        .getPropertyValue("config.villain.defaultDefense");

    return new SuperHero(name, new HeroStatistics(health, strength, defense), type);
  }
}
