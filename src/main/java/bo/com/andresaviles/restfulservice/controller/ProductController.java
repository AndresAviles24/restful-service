package bo.com.andresaviles.restfulservice.controller;

import bo.com.andresaviles.restfulservice.controller.model.ProductID;
import bo.com.andresaviles.restfulservice.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController

public class ProductController {

    @PostMapping("/product")
    public ResponseEntity<ProductID> createProduct(@RequestBody final Product product){
        System.out.println(product);
        ProductID result = new ProductID(UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }

    @GetMapping("/product")
    public List<Product> getAllProducts() {
        List<Product> result = new ArrayList<>();

        result.add(new Product("1", "Product1", new BigDecimal("258.33")));
        result.add(new Product("2", "Product2", new BigDecimal("999.11")));
        result.add(new Product("3", "Product3", new BigDecimal("258.33")));

        return result;
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable final String id){
        System.out.println(id);
        return new Product("888",
                "Returning a single product",
                new BigDecimal("458.44"));
    }

    @PatchMapping("/product")
    public void patchProduct(@PathVariable final Product product){
        System.out.println(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable final String id){
        System.out.println(id);
    }


}
