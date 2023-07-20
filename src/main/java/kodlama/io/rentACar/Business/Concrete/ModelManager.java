package kodlama.io.rentACar.Business.Concrete;

import kodlama.io.rentACar.Business.Abstract.ModelService;
import kodlama.io.rentACar.Business.Request.CreateModelRequest;
import kodlama.io.rentACar.Business.Respones.GetAllBrandResponse;
import kodlama.io.rentACar.Business.Respones.GetAllModelsResponse;
import kodlama.io.rentACar.Core.Utilities.Mappers.ModelMapperService;
import kodlama.io.rentACar.DataAccess.Abstract.ModelRepository;
import kodlama.io.rentACar.Entities.Concrete.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllModelsResponse> getAll() {
        // İş kodları
        List<Model> models =  modelRepository.findAll();

        List<GetAllModelsResponse> modelReponse = models.stream().
                map(model->this.modelMapperService.forResponse().
                        map(model,GetAllModelsResponse.class)).
                collect(Collectors.toList());

        return modelReponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest,Model.class);

        this.modelRepository.save(model);
    }
}
