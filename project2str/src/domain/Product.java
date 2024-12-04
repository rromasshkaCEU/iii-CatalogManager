package domain;


public class Product {
    private String name;
    private String price;
    private String id;

    /**
     *It is a constructor, where we identified the name, price, and id parameters.
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
     *It is setter for name parameter.
     * @param name
     */

    public void setName(String name) {

        this.name = name;
    }

    /**
     *It is setter for price parameter
     * @param price
     */

    public void setPrice(String price) {
        this.price = price;
    }

    /**
     *It is setter for id.
     * @param id
     */

    public void setId(String id) {

        this.id = id;
    }

    /**
     *It is getter for name.
     * @return
     */

    public String getName() {

        return name;
    }

    /**
     *It is getter for price.
     * @return
     */

    public String getPrice() {

        return price;
    }

    /**
     *It is getter for id.
     * @return
     */

    public String getId() {

        return id;
    }

    /**
     *Here, It compares this product to another object for equality.
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

