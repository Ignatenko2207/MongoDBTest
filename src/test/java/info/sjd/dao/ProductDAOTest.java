package info.sjd.dao;

import info.sjd.model.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductDAOTest {

    @Test
    void saveAndGet() {
        Product product = new Product("AI010115", new BigDecimal(125.25), "Some name of product");
        ProductDAO.save(product);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Product> products = ProductDAO.getAll();

        assertNotNull(products);
        assertTrue(!products.isEmpty());
        assertEquals("AI010115", products.get(0).getArticle());
    }
}