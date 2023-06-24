package LTJV.DoAnJava.service;

import LTJV.DoAnJava.Entity.Provider;
import LTJV.DoAnJava.repository.IProviderRepository;
import LTJV.DoAnJava.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public void addProvider(MultipartFile file, Provider provider){
        providerRepository.save(provider);
        if(!file.isEmpty()){
            try{
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                String uploadDir = "DoAnJava/src/main/resources/static/img/provider-photos/" + provider.getId();
                FileUploadUtil.saveFile(uploadDir,fileName,file);
                provider.setImage("img/provider-photos/"+provider.getId()+"/"+fileName);
                providerRepository.save(provider);
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void updateProvider(Provider provider){providerRepository.save(provider);}
    public void deleteProvider(Long id){providerRepository.deleteById(id);}
}
