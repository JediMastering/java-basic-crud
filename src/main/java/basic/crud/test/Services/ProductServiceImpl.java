package basic.crud.test.Services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import basic.crud.test.Dtos.ProductDto;
import basic.crud.test.Entities.Products;
import basic.crud.test.Repositories.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Products> getAllProducts() {
        List<Products> productsList = productRepository.findAll();
        return productsList;
    }

    @Override
    public Products getOneProduct(UUID id) {
        Optional<Products> productO = productRepository.findById(id);
        return productO.orElse(null);
    }

    @Override
    public Products saveProduct(ProductDto productDto) {
        Products productModel = new Products();
        BeanUtils.copyProperties(productDto, productModel);
        return productRepository.save(productModel);
    }

    @Override
    public void deleteProduct(UUID id) {
        Optional<Products> productO = productRepository.findById(id);
        productO.ifPresent(productRepository::delete);
    }

    @Override
    public Products updateProduct(UUID id, ProductDto productDto) {
        Optional<Products> productO = productRepository.findById(id);
        if (productO.isPresent()) {
            Products productModel = productO.get();
            BeanUtils.copyProperties(productDto, productModel);
            return productRepository.save(productModel);
        }
        return null;
    }
}
