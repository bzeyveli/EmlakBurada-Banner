package emlakburada.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Banner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int advertNo;
	private String phone;
	private int total;
	@OneToOne(fetch = FetchType.EAGER)
	private Address address;

}
