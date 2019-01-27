package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public abstract class AbstractHero {

  public static int instanceNumber = 0;

  protected String name;
  protected HeroStatistics stats;
  protected TeamType type;
  protected boolean alive;

  public AbstractHero(String name, HeroStatistics stats, TeamType type) {
    instanceNumber++;

    this.name = name;
    this.stats = stats;
    this.type = type;
    this.alive = true;

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

  public void killHero() {
    this.alive = false;
  }

  public abstract int getPower();
}
