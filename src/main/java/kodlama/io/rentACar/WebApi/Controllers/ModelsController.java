package kodlama.io.rentACar.WebApi.Controllers;

import jakarta.validation.Valid;
import kodlama.io.rentACar.Business.Abstract.ModelService;
import kodlama.io.rentACar.Business.Request.CreateBrandRequest;
import kodlama.io.rentACar.Business.Request.CreateModelRequest;
import kodlama.io.rentACar.Business.Respones.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Annotation
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;

    @GetMapping("/getall")
    public List<GetAllModelsResponse> getAll() {

        return modelService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateModelRequest createModelRequest){

        this.modelService.add(createModelRequest);
    }

}
