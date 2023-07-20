package kodlama.io.rentACar.Business.Abstract;

import kodlama.io.rentACar.Business.Request.CreateModelRequest;
import kodlama.io.rentACar.Business.Respones.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);

}
