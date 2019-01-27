package testingutils;

import model.AbstractHero;
import model.HeroStatistics;
import model.SuperHero;
import model.TeamType;
import model.Villlain;

public class AbstractHeroDataBuilder {

  private String name;
  private HeroStatistics stats;
  private TeamType type;

  public AbstractHeroDataBuilder() {
    name = "default-hero";
    stats = new HeroStatistics();
    type = TeamType.RED;
  }

  public AbstractHeroDataBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public AbstractHeroDataBuilder withStats(HeroStatistics stats) {
    this.stats = stats;
    return this;
  }

  public AbstractHeroDataBuilder withType(TeamType type) {
    this.type = type;
    return this;
  }

  public AbstractHero buildSuperHero() {
    return new SuperHero(name, stats, type);
  }

  public AbstractHero buildVillain() {
    return new Villlain(name, stats, type);
  }

  public AbstractHeroDataBuilder withWeakStatistics() {
    return this.withStats(new HeroStatistics(1, 1, 1));
  }

  public AbstractHeroDataBuilder withPowerfulStatistics() {
    return this.withStats(new HeroStatistics(100, 100, 100));
  }
}
