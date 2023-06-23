package LTJV.DoAnJava.service;

import LTJV.DoAnJava.Entity.Provider;
import LTJV.DoAnJava.repository.IProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {
    @Autowired
    private IProviderRepository providerRepository;
    public List<Provider> getAllProviders(){
        return providerRepository.findAll();
    }
    public Provider getProviderById(Long id){
        Optional<Provider> optional = providerRepository.findById(id);
        return optional.orElse( null);
    }

    public void addProvider(Provider provider){providerRepository.save(provider);}
    public void updateProvider(Provider provider){providerRepository.save(provider);}
    public void deleteProvider(Long id){providerRepository.deleteById(id);}
}
