package kodlama.io.rentACar.Business.Rules;

import kodlama.io.rentACar.Core.Utilities.Exception.BusinessException;
import kodlama.io.rentACar.DataAccess.Abstract.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name) {

        if(this.brandRepository.existsByName(name)){
            throw new BusinessException("Brand already exists"); //Java exception types
        }

    }
}
