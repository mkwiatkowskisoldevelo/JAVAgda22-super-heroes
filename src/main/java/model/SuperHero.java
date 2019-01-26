package model;

public class SuperHero extends AbstractHero {

  public SuperHero(String name, HeroStatistics stats, TeamType type) {
    super(name, stats, type);
  }

  public int getPower() {
    return (stats.getDefense() + stats.getStrength())
        * stats.getHealth();
  }
}
