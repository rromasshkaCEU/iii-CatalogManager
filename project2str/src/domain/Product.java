package domain;


public class Product {
    private String name;
    private String price;
    private String id;

    /**
     *
     * @param name
     * @param price
     * @param id
     */

    public Product(String name, String price, String id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    /**
     *
     * @param name
     */

    public void setName(String name) {

        this.name = name;
    }

    /**
     *
     * @param price
     */

    public void setPrice(String price) {
        this.price = price;
    }

    /**
     *
     * @param id
     */

    public void setId(String id) {

        this.id = id;
    }

    /**
     *
     * @return
     */

    public String getName() {

        return name;
    }

    /**
     *
     * @return
     */

    public String getPrice() {

        return price;
    }

    /**
     *
     * @return
     */

    public String getId() {

        return id;
    }

    /**
     *
     * @param obj
     * @return
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return id.equalsIgnoreCase(product.id);
    }

}

