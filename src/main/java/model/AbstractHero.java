package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public abstract class AbstractHero {
  protected String name;
  protected HeroStatistics stats;
  protected TeamType type;

  public AbstractHero(String name, HeroStatistics stats, TeamType type) {
    this.name = name;
    this.stats = stats;
    this.type = type;

    switch (this.type) {
      case RED: {
        this.stats.increaseHealth(50);
        break;
      }
      case BLUE: {
        this.stats.increaseStrenght(50);
        break;
      }
      case GREEN: {
        this.stats.increaseDefense(50);
        break;
      }
    }
  }

  public abstract int getPower();
}
