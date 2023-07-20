package kodlama.io.rentACar.Business.Abstract;

import kodlama.io.rentACar.Business.Request.CreateBrandRequest;
import kodlama.io.rentACar.Business.Request.UpdateBrandRequest;
import kodlama.io.rentACar.Business.Respones.GetAllBrandResponse;
import kodlama.io.rentACar.Business.Respones.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandResponse> getAll();
    GetByIdBrandResponse getById(int id);

    void update(UpdateBrandRequest updateBrandRequest);
    void add(CreateBrandRequest createBrandRequest);
    void delete(int id);


}
