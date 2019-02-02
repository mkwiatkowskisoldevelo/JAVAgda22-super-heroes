package model;

import static java.lang.String.join;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
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

  public void setName(String name) {
    this.name = name;
  }

  public void setStats(HeroStatistics stats) {
    this.stats = stats;
  }

  public void setType(TeamType type) {
    this.type = type;
  }

  public void killHero() {
    this.alive = false;
  }

  public abstract int getPower();

  public String parseToString() {
    return join(";",
        this.getClass().getSimpleName(),
        this.name,
        Integer.toString(this.stats.getHealth()),
        Integer.toString(this.stats.getDefense()),
        Integer.toString(this.stats.getStrength()),
        this.type.toString());

//    return "SuperHero;"
//        + this.name + ";"
//        + this.getStats().getHealth() + ";"
//        + this.getStats().getDefense() + ";"
//        + this.getStats().getStrength() + ";"
//        + this.getType();
  }
}
