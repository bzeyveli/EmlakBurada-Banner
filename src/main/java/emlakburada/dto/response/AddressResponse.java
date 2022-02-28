package emlakburada.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressResponse {

    private int id;
    private String province;
    private String district;
    private String addresDesc;
}
