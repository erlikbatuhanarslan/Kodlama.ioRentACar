package kodlama.io.rentACar.Business.Respones;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdBrandResponse {
    private int id;
    private String name;
}
