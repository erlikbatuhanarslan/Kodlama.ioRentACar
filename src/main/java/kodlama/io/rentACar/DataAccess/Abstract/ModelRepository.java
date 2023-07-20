package kodlama.io.rentACar.DataAccess.Abstract;

import kodlama.io.rentACar.Entities.Concrete.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
}
