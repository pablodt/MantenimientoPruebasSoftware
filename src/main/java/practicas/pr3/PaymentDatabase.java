package practicas.pr3;

/**
 * @author Antonio J. Nebro
 */
public interface PaymentDatabase {
  void advertisementPublished(String advertiserName);
  boolean advertiserHasFunds(String advertiserName);
}
