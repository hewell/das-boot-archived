package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ShipwreckControllerTest {

  @InjectMocks
  private ShipwreckController sc;

  @Mock
  private ShipwreckRepository repository;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testShipwreckGet() {

    Shipwreck wreck = new Shipwreck();
    wreck.setId(1l);
    when(repository.findOne(1l)).thenReturn(wreck);

    Shipwreck sw = sc.get(1l);

    verify(repository).findOne(1l);

    assertThat(sw.getId(), is(1l));
  }
}
