package kodlama.io.rentACar.DataAccess.Abstract;

import kodlama.io.rentACar.Entities.Concrete.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepository extends JpaRepository<Brand,Integer> {
    boolean existsByName(String name); //Spring JPA keyword
}
