package emlakburada.service;

import emlakburada.dto.request.AddressRequest;
import emlakburada.dto.response.AddressResponse;
import emlakburada.model.Address;
import emlakburada.repository.AddressRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public AddressResponse create(AddressRequest addressRequest) {
        Address address = convertToAddressEntity(addressRequest);
        address = addressRepository.saveAndFlush(address);
        return convertToAddressResponse(address);
    }

    public List<AddressResponse> read(){
        List<AddressResponse> addressResponseList = new ArrayList<>();
        List<Address> addressList = addressRepository.findAll();
        for (Address address: addressList) {
            addressResponseList.add(convertToAddressResponse(address));
        }
        return addressResponseList;
    }

    public AddressResponse update(Integer id, AddressRequest addressRequest) {
        Address address = addressRepository.getById(id);
        // BeanUtils.copyProperties(kaynak, hedef) kopyalama yapar
        BeanUtils.copyProperties(convertToAddressEntity(addressRequest), address);
        addressRepository.saveAndFlush(address);
        return convertToAddressResponse(address);
    }

    public Boolean delete(Integer id) {
        try {
            addressRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    public Address convertToAddressEntity(AddressRequest addressRequest){
        Address address = new Address();
        address.setProvince(addressRequest.getProvince());
        address.setAddresDesc(addressRequest.getAddresDesc());
        address.setDistrict(addressRequest.getDistrict());
        return address;
    }

    public AddressResponse convertToAddressResponse(Address address){
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setProvince(address.getProvince());
        addressResponse.setAddresDesc(address.getAddresDesc());
        addressResponse.setDistrict(address.getDistrict());
        return addressResponse;
    }
}
