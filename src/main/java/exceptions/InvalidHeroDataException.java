package exceptions;

public class InvalidHeroDataException
    extends RuntimeException {

  public InvalidHeroDataException(String message) {
    super(message);
  }

  public InvalidHeroDataException(
      String message, Throwable cause) {
    super(message, cause);
  }
}
