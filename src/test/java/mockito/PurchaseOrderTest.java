package mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseOrderTest {

    @Test
    public void shouldPurchaseWorkProperlyWhenThereAreEnoughProducts() {
        // Paso 1: Crear objeto mock
        Warehouse warehouse = Mockito.mock(Warehouse.class);

        // Paso 2: Definir comportamiento
        Mockito.when(warehouse.thereAreProducts("Cerveza", 20)).thenReturn(true);

        // Paso 3: Ejecución
        PurchaseOrder purchaseOrder = new PurchaseOrder("Cerveza", 20);
        purchaseOrder.purchase(warehouse);

        // Paso 4: Verificación
        Mockito.verify(warehouse).remove("Cerveza", 20);
        Mockito.verify(warehouse, Mockito.times(1)).remove("Cerveza", 20);
    }

    @Test
    public void shouldPurchaseWorkProperlyWhenThereAreNotEnoughProducts() {
        // Paso 1: Crear objeto mock
        Warehouse warehouse = Mockito.mock(Warehouse.class);

        // Paso 2: Definir comportamiento
        Mockito.when(warehouse.thereAreProducts("Cerveza", 25)).thenReturn(false);

        // Paso 3: Ejecución
        PurchaseOrder purchaseOrder = new PurchaseOrder("Cerveza", 25);
        purchaseOrder.purchase(warehouse);

        // Paso 4: Verificación
        Mockito.verify(warehouse, Mockito.never()).remove("Cerveza", 25);
    }
}