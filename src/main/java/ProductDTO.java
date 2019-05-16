import com.google.gson.Gson;

import java.io.Serializable;
import java.util.Objects;

public class ProductDTO implements Serializable {

    private String name;
    private double price;
    private String spec;

    private transient Gson gson = new Gson();

    public ProductDTO fromJson(String json) {
        return this.gson.fromJson(json, ProductDTO.class);
    }

    public String toJson() {
        return this.gson.toJson(this);
    }

    public String getName() {
        return name;
    }

    public ProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public ProductDTO setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getSpec() {
        return spec;
    }

    public ProductDTO setSpec(String spec) {
        this.spec = spec;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return Double.compare(that.price, price) == 0 &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
