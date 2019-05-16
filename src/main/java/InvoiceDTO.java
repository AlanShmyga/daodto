import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InvoiceDTO {

    private String receiver;
    private Map<ProductDTO, Integer> productList = new HashMap<>();
    private double tax;
    private double totalCost;

    public String getReceiver() {
        return receiver;
    }

    public InvoiceDTO setReceiver(String receiver) {
        this.receiver = receiver;
        return this;
    }

    public Map<ProductDTO, Integer> getProducts() {
        return ImmutableMap.copyOf(productList);
    }

    public InvoiceDTO addProduct(ProductDTO product, Integer quantity) {
        productList.put(product, quantity);
        return this;
    }

    public double getTax() {
        return tax;
    }

    public InvoiceDTO setTax(double tax) {
        this.tax = tax;
        return this;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public InvoiceDTO setTotalCost(double totalCost) {
        this.totalCost = totalCost;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceDTO that = (InvoiceDTO) o;
        return Double.compare(that.totalCost, totalCost) == 0 &&
                receiver.equals(that.receiver) &&
                productList.equals(that.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiver, productList, totalCost);
    }
}
