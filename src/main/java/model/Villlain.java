package model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Villlain extends AbstractHero {

  public Villlain(String name, HeroStatistics stats, TeamType type) {
    super(name, stats, type);
  }

  public int getPower() {
    return (stats.getHealth() + stats.getStrength())
        * stats.getDefense();
  }
}
