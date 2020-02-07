import org.junit.Test;
import product.ExemptProduct;
import product.ImportedProductDecorator;
import product.TaxedProduct;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ImportedProductDecoratorTest {

    @Test
    public void shouldApplyOnlyTheImportedTaxInExemptProduct() {
        final var result = new ImportedProductDecorator(new ExemptProduct("imported box of chocolates", new BigDecimal("121.25")));


        assertThat(result.getPrice().add(result.getTaxAmount()), is(new BigDecimal("11.85")));
        assertThat(result.getTaxAmount(), is(new BigDecimal("0.60")));
    }
    @Test
    public void shouldApplyBothTaxesOnNonExemptProduct() {
        final var result = new ImportedProductDecorator(new TaxedProduct("imported bottle of perfume", new BigDecimal("47.50")));


        assertThat(result.getPrice().add(result.getTaxAmount()), is(new BigDecimal("54.65")));
        assertThat(result.getTaxAmount(), is(new BigDecimal("7.15")));
    }
}
