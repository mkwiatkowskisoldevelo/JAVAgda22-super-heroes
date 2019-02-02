package model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class HeroStatistics {
  private int health;
  private int strength;
  private int defense;

  // konstruktor wygenerowany przez @AllArgsConstructor
//  public HeroStatistics(int health, int strength, int defense) {
//    this.health = health;
//    this.strength = strength;
//    this.defense = defense;
//  }

  public void increaseHealth(int amount) {
    health += amount;
  }

  public void increaseStrenght(int amount) {
    strength += amount;
  }

  public void increaseDefense(int amount) {
    defense += amount;
  }
}
