package basic.crud.test.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import basic.crud.test.Entities.Products;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Products, UUID> {

}
