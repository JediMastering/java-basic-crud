package basic.crud.test.Services;

import java.util.List;
import java.util.UUID;

import basic.crud.test.Dtos.ProductDto;
import basic.crud.test.Entities.Products;

public interface ProductService {
    List<Products> getAllProducts();

    Products getOneProduct(UUID id);

    Products saveProduct(ProductDto productDto);

    void deleteProduct(UUID id);

    Products updateProduct(UUID id, ProductDto productDto);
}
