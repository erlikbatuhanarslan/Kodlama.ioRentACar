package kodlama.io.rentACar.Entities.Concrete;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name= "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name ="plate", unique = true)
    private String plate;

    @Column(name ="dailyPrice")
    private  double dailyPrice;

    @Column(name ="modelYear")
    private  int modelYear;

    @Column(name ="state")
    private  int state; // 1.Available 2.Rented vs.

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
