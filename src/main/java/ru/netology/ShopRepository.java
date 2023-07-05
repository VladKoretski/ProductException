package ru.netology;

public class ShopRepository {
    private Product[] products = new Product[0];

    public Product findByID(int iD) {
        for (Product product : products) {
            if (product.getId() == iD) {
                return product;
            }
        }
        return null;
    }

    /**
     * Вспомогательный метод для имитации добавления элемента в массив
     *
     * @param current — массив, в который мы хотим добавить элемент
     * @param product — элемент, который мы хотим добавить
     * @return — возвращает новый массив, который выглядит, как тот, что мы передали,
     * но с добавлением нового элемента в конец
     */
    private Product[] addToArray(Product[] current, Product product) {

        Product[] tmp = new Product[current.length + 1];
        System.arraycopy(current, 0, tmp, 0, current.length);
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    /**
     * Метод добавления товара в репозиторий
     *
     * @param //product — добавляемый товар
     */


    public Product[] findAll() {
        return products;
    }

    public void add(Product product) {
        int newID = product.getId();
        products = addToArray(products, product);
    }

    // Этот способ мы рассматривали в теории в теме про композицию
    public Product[] removeByID(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;

        if (findByID(id) != null) {

            for (Product product : products) {
                if (product.getId() != id) {
                    tmp[copyToIndex] = product;
                    copyToIndex++;
                }
            }
            products = tmp;
        } else {
            throw new NotFoundException(
                    "The Product with ID " + id + "is not found"
            );
        }
        return tmp;
    }


}