package mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockedListTest {

    @Test
    public void simpleMockingExamples() {
        // Paso 1: Crear objeto mock
        List<String> mockedList = Mockito.mock(List.class);

        // Paso 2: Definir comportamiento

        // Paso 3: Ejecución
        mockedList.add("verde");
        mockedList.add("azul");
        mockedList.add("verde");
        mockedList.clear();

        // Paso 4: Verificación
        Mockito.verify(mockedList).add("azul");
        Mockito.verify(mockedList, Mockito.times(2)).add("verde");
        Mockito.verify(mockedList).clear();

        Mockito.verify(mockedList, Mockito.times(3)).add(Mockito.anyString());
        Mockito.verify(mockedList, Mockito.never()).add("rojo");
        Mockito.verify(mockedList, Mockito.never()).size();
        Mockito.verify(mockedList, Mockito.atLeastOnce()).add("verde");
        Mockito.verify(mockedList, Mockito.atLeast(1)).add(Mockito.anyString());
    }

    @Test
    public void simpleStubbingExamples() {
        // Paso 1: Crear objeto mock
        List<String> mockedList = Mockito.mock(List.class);

        // Paso 2: Stubbing
        mockedList.add("verde");
        mockedList.add("azul");
        Mockito.when(mockedList.size()).thenReturn(2);

        // Paso 3: Verificación
        Mockito.verify(mockedList, Mockito.times(2)).add(Mockito.anyString());

        assertEquals(2, mockedList.size());
    }

    @Test
    public void examplesOfSpying() {
        List<String> list = new ArrayList<>();
        List<String> spyList = Mockito.spy(list);

        spyList.add("verde");
        spyList.add("azul");

        Mockito.verify(spyList).add("verde");
        Mockito.verify(spyList).add("azul");
        Mockito.verify(spyList, Mockito.times(2)).add(Mockito.anyString());

        assertEquals(2, spyList.size());

        Mockito.doReturn(100).when(spyList).size();
        assertEquals(100, spyList.size());
    }
}
