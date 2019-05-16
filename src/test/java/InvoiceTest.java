import org.junit.Test;

import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class InvoiceTest {

    private static final ProductDTO PRODUCT_TIRE = new ProductDTO().setName("Tire").setPrice(100.00);
    private static final ProductDTO PRODUCT_CRANKSHAFT = new ProductDTO().setName("Crankshaft").setPrice(135.00);
    private static final InvoiceDTO INVOICE_1 = new InvoiceDTO()
            .setReceiver("Alan")
            .addProduct(PRODUCT_TIRE, 4)
            .addProduct(PRODUCT_CRANKSHAFT, 2);
    private static final InvoiceDTO INVOICE_2 = new InvoiceDTO()
            .setReceiver("Alan")
            .addProduct(PRODUCT_TIRE, 4)
            .addProduct(PRODUCT_CRANKSHAFT, 2);


    @Test
    public void equalInvoicesShouldBeEqual() {
        assertEquals(INVOICE_2, INVOICE_1);
    }

    @Test
    public void differentInvoicesShouldBeNotEqual() {
        InvoiceDTO differentInvoice = new InvoiceDTO().setReceiver("Alan")
                .addProduct(PRODUCT_TIRE, 2)
                .addProduct(PRODUCT_CRANKSHAFT, 2);

        assertNotEquals(differentInvoice, INVOICE_1);
    }

    @Test
    public void jsonVersionShouldBeEqual() {
        String expectedJson = "{\"name\":\"Tire\",\"price\":100.0}\n{\"name\":\"Crankshaft\",\"price\":135.0}";
        String actualJson = INVOICE_1
                .getProducts()
                .keySet()
                .stream()
                .map(ProductDTO::toJson)
                .collect(Collectors.joining("\n"));

        assertEquals(expectedJson, actualJson);
    }
}
