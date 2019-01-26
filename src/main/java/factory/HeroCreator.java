package factory;

import model.AbstractHero;
import model.HeroStatistics;
import model.TeamType;

public interface HeroCreator {

  String CONFIG = "config";
  String DEFAULT_STRENGTH = "defaultStrength";
  String DEFAULT_HEALTH = "defaultHealth";
  String DEFAULT_DEFENSE = "defaultDefense";

  AbstractHero createHero(
      String name, HeroStatistics stats, TeamType type);

  AbstractHero createHeroWithDefaultStats(String name, TeamType type);
}
