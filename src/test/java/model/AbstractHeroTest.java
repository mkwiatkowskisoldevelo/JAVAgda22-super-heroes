package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import testingutils.AbstractHeroDataBuilder;

public class AbstractHeroTest {

  @Test
  public void shouldParseSuperHeroToString() {
    // given
    AbstractHero hero = new AbstractHeroDataBuilder()
        .buildSuperHero();

    // when
    String parsedHero = hero.parseToString();

    // then
    checkHeroString(hero, parsedHero, "SuperHero");
  }

  @Test
  public void shouldParseVillainToString() {
    // given
    AbstractHero villain = new AbstractHeroDataBuilder()
        .buildVillain();

    // when
    String result = villain.parseToString();

    // then
    checkHeroString(villain, result, "Villlain");
  }

  private void checkHeroString(AbstractHero hero, String result, String className) {
    assertEquals(className + ";"
            + hero.getName() + ";"
            + hero.getStats().getHealth() + ";"
            + hero.getStats().getDefense() + ";"
            + hero.getStats().getStrength() + ";"
            + hero.getType(),
        result);
  }
}
