package factory;

import model.AbstractHero;
import model.HeroStatistics;
import model.SuperHero;
import model.TeamType;
import util.PropertiesUtils;

public class SuperHeroCreator implements HeroCreator {

  private static final String SUPER_HERO = "superHero";

  PropertiesUtils propertiesUtils = PropertiesUtils.getInstance();

  public AbstractHero createHero(
      String name, HeroStatistics stats, TeamType type) {
    return new SuperHero(name, stats, type);
  }

  public AbstractHero createHeroWithDefaultStats(String name, TeamType type) {
    int strength = propertiesUtils
        .getPropertyValue(String.join(".", CONFIG, SUPER_HERO, DEFAULT_STRENGTH));
    int health = propertiesUtils
        .getPropertyValue(String.join(".", CONFIG, SUPER_HERO, DEFAULT_HEALTH));
    int defense = propertiesUtils
        .getPropertyValue(String.join(".", CONFIG, SUPER_HERO, DEFAULT_DEFENSE));

    return new SuperHero(name, new HeroStatistics(health, strength, defense), type);
  }
}
