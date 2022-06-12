package practicas.pr3;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;


class AdvertisementBoardTest {
  @Test
  public void ABoardHasAnAdvertisementWhenItIsCreated() {
    AdvertisementBoard advertisementBoard = new AdvertisementBoard();
    assertEquals(1, advertisementBoard.numberOfPublishedAdvertisements());
  }

  @Test
  public void PublishAnAdvertisementByTheCompanyIncreasesTheNumberOfAdvertisementsByOne() {
    AdvertisementBoard advertisementBoard = new AdvertisementBoard();
    Advertisement advertisement = new Advertisement("Anuncio 1", "Texto anuncio 1", "THE Company");

    advertisementBoard.publish(advertisement, null, null);

    assertEquals(2, advertisementBoard.numberOfPublishedAdvertisements());
  }

  @Test
  public void WhenAnAdvertiserHasNoFoundsTheAdvertisementIsNotPublished() {
    AdvertisementBoard advertisementBoard = new AdvertisementBoard();
    AdvertiserDatabase advertiserDatabase = Mockito.mock(AdvertiserDatabase.class);
    PaymentDatabase paymentDatabase = Mockito.mock(PaymentDatabase.class);

    Advertisement advertisement = new Advertisement("Anuncio", "Texto anuncio", "Pepe Gotera y Otilio");

    Mockito.when(advertiserDatabase.findAdviser("Pepe Gotera y Otilio")).thenReturn(true);
    Mockito.when(paymentDatabase.advertiserHasFunds("Pepe Gotera y Otilio")).thenReturn(false);

    advertisementBoard.publish(advertisement, advertiserDatabase, paymentDatabase);

    Mockito.verify(advertiserDatabase, Mockito.times(1)).findAdviser("Pepe Gotera y Otilio");
    Mockito.verify(paymentDatabase, Mockito.times(1)).advertiserHasFunds("Pepe Gotera y Otilio");
    Mockito.verify(paymentDatabase, Mockito.times(0)).advertisementPublished("Pepe Gotera y Otilio");

    assertEquals(1, advertisementBoard.numberOfPublishedAdvertisements());
  }

  @Test
  public void AnAdvertisementIsPublishedIfTheAdvertiserIsRegisteredAndHasFunds() {
    AdvertisementBoard advertisementBoard = new AdvertisementBoard();
    AdvertiserDatabase advertiserDatabase = Mockito.mock(AdvertiserDatabase.class);
    PaymentDatabase paymentDatabase = Mockito.mock(PaymentDatabase.class);

    Advertisement advertisement = new Advertisement("Anuncio", "Texto anuncio", "Robin Robot");

    Mockito.when(advertiserDatabase.findAdviser("Robin Robot")).thenReturn(true);
    Mockito.when(paymentDatabase.advertiserHasFunds("Robin Robot")).thenReturn(true);

    advertisementBoard.publish(advertisement, advertiserDatabase, paymentDatabase);

    Mockito.verify(advertiserDatabase, Mockito.times(1)).findAdviser("Robin Robot");
    Mockito.verify(paymentDatabase, Mockito.times(1)).advertiserHasFunds("Robin Robot");
    Mockito.verify(paymentDatabase, Mockito.times(1)).advertisementPublished("Robin Robot");

    assertEquals(2, advertisementBoard.numberOfPublishedAdvertisements());
  }

  @Test
  public void WhenTheOwnerMakesTwoPublicationsAndTheFirstOneIsDeletedItIsNotInTheBoard() {
    AdvertisementBoard advertisementBoard = new AdvertisementBoard();

    Advertisement advertisement1 = new Advertisement("Anuncio 1", "Texto anuncio 1", "THE Company");
    Advertisement advertisement2 = new Advertisement("Anuncio 2", "Texto anuncio 2", "THE Company");

    advertisementBoard.publish(advertisement1, null, null);
    advertisementBoard.publish(advertisement2, null, null);

    assertEquals(3, advertisementBoard.numberOfPublishedAdvertisements());

    advertisementBoard.deleteAdvertisement("Anuncio 1", "THE Company");

    assertEquals(2, advertisementBoard.numberOfPublishedAdvertisements());
    assertNull(advertisementBoard.findByTitle("Anuncio 1"));
    assertNotNull(advertisementBoard.findByTitle("Anuncio 2"));
  }

  @Test
  public void AnExistingAdvertisementIsNotPublished() {
    AdvertisementBoard advertisementBoard = new AdvertisementBoard();
    AdvertiserDatabase advertiserDatabase = Mockito.mock(AdvertiserDatabase.class);
    PaymentDatabase paymentDatabase = Mockito.mock(PaymentDatabase.class);

    Advertisement advertisement1 = new Advertisement("Anuncio", "Texto anuncio", "Prueba");
    Advertisement advertisement2 = new Advertisement("Anuncio", "Texto anuncio2", "Prueba");

    Mockito.when(advertiserDatabase.findAdviser("Prueba")).thenReturn(true);
    Mockito.when(paymentDatabase.advertiserHasFunds("Prueba")).thenReturn(true);

    advertisementBoard.publish(advertisement1, advertiserDatabase, paymentDatabase);

    assertEquals(2, advertisementBoard.numberOfPublishedAdvertisements());

    advertisementBoard.publish(advertisement2, advertiserDatabase, paymentDatabase);

    assertEquals(2, advertisementBoard.numberOfPublishedAdvertisements());

    Mockito.verify(advertiserDatabase, Mockito.times(1)).findAdviser("Prueba");
    Mockito.verify(paymentDatabase, Mockito.times(1)).advertiserHasFunds("Prueba");
    Mockito.verify(paymentDatabase, Mockito.times(1)).advertisementPublished("Prueba");
  }

  @Test
  public void AnExceptionIsRaisedIfTheBoardIsFullAndANewAdvertisementIsPublished() {
    AdvertisementBoard advertisementBoard = new AdvertisementBoard();
    AdvertisementBoard spyAdvertisementBoard = Mockito.spy(advertisementBoard);
    Advertisement advertisement = new Advertisement("Anuncio", "Texto anuncio", "Tim O'Theo");

    Mockito.when(spyAdvertisementBoard.numberOfPublishedAdvertisements()).thenReturn(20);

    assertThrows(FullBoardException.class, () -> advertisementBoard.publish(advertisement, null, null));
  }
}