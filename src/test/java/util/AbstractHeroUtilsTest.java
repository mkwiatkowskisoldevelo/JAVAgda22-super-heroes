package util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import exceptions.InvalidHeroDataException;
import java.util.ArrayList;
import model.AbstractHero;
import model.HeroStatistics;
import model.SuperHero;
import model.TeamType;
import model.Villlain;
import org.junit.jupiter.api.Test;

public class AbstractHeroUtilsTest {

  @Test
  public void shouldCreateSuperHeroFromString() {
    // given
    String superHeroString = "SuperHero;name;5;10;15;RED";

    // when
    AbstractHero result = AbstractHeroUtils
        .createHeroFromString(superHeroString);

    // then
    assertEquals(new SuperHero(
            "name",
            new HeroStatistics(5, 10, 15),
            TeamType.RED),
        result);
  }

  @Test
  public void shouldCreateVillainFromString() {
    // given
    String villainString = "Villlain;name;5;10;15;RED";

    // when
    AbstractHero result = AbstractHeroUtils
        .createHeroFromString(villainString);

    // then
    assertEquals(new Villlain(
            "name",
            new HeroStatistics(5, 10, 15),
            TeamType.RED),
        result);
    assertThat(result, equalTo(new Villlain(
        "name",
        new HeroStatistics(5, 10, 15),
        TeamType.RED)));
  }

  @Test
  public void shouldThrowExceptionIfToManyParts() {
    // given
    String invalidString = "1;2;3;4;5;6;7";

    // when & then
    assertThrows(InvalidHeroDataException.class,
        () -> AbstractHeroUtils.createHeroFromString(invalidString));
  }

  @Test
  public void shouldThrowExceptionIfTooFewParts() {
    // given
    String invalidString = "1;2;3;4;5";

    // when & then
    assertThrows(InvalidHeroDataException.class,
        () -> AbstractHeroUtils.createHeroFromString(invalidString));
  }

  @Test
  public void shouldThrowExceptionIfHealthParamHasWrongFormat() {
    // given
    String invalidFormatString = "SuperHero;name;a;10;15;RED";

    // when & then
    assertThrows(InvalidHeroDataException.class,
        () -> AbstractHeroUtils.createHeroFromString(invalidFormatString));
  }
}
