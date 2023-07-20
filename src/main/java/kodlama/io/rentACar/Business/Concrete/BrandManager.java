package kodlama.io.rentACar.Business.Concrete;

import kodlama.io.rentACar.Business.Abstract.BrandService;
import kodlama.io.rentACar.Business.Request.CreateBrandRequest;
import kodlama.io.rentACar.Business.Request.UpdateBrandRequest;
import kodlama.io.rentACar.Business.Respones.GetAllBrandResponse;
import kodlama.io.rentACar.Business.Respones.GetByIdBrandResponse;
import kodlama.io.rentACar.Business.Rules.BrandBusinessRules;
import kodlama.io.rentACar.Core.Utilities.Mappers.ModelMapperService;
import kodlama.io.rentACar.DataAccess.Abstract.BrandRepository;
import kodlama.io.rentACar.Entities.Concrete.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service //Bu sınıf bir business nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandResponse> getAll() {
        // İş kodları
        List<Brand> brands =  brandRepository.findAll();

        List<GetAllBrandResponse> brandsResponse = brands.stream().
                map(brand->this.modelMapperService.forResponse().
                map(brand,GetAllBrandResponse.class)).
                collect(Collectors.toList());

        return brandsResponse;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
      Brand brand = this.brandRepository.findById(id).orElseThrow();

      GetByIdBrandResponse response =
              this.modelMapperService.forResponse().
                      map(brand, GetByIdBrandResponse.class);

      return response;
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().
                map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {

        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().
                map(createBrandRequest,Brand.class);

        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {

        this.brandRepository.deleteById(id);

    }
}
