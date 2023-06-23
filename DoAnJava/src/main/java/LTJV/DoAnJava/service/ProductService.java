package LTJV.DoAnJava.service;

import LTJV.DoAnJava.Entity.Product;
import LTJV.DoAnJava.repository.IProductRepository;
import LTJV.DoAnJava.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;
    public List<Product> getAllProducts(){return productRepository.findAll();}

    public Product getProductById(Long id){
        Optional<Product> optional = productRepository.findById(id);
        return optional.orElse(null);
    }

    public void addProduct(MultipartFile file, Product product){
        productRepository.save(product);
        if(!file.isEmpty()){
            try{
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                String uploadDir = "DoAnJava/src/main/resources/static/img/product-photos/" + product.getId();
                FileUploadUtil.saveFile(uploadDir,fileName,file);
                product.setImage("img/product-photos/"+product.getId()+"/"+fileName);
                productRepository.save(product);
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void updateProduct(MultipartFile file, Product product){
        productRepository.save(product);
        if(!file.isEmpty()){
            try{
                FileUploadUtil.deleteFile(product.getImage());
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                String uploadDir = "DoAnJava/src/main/resources/static/img/product-photos/" + product.getId();
                FileUploadUtil.saveFile(uploadDir,fileName,file);
                product.setImage("img/product-photos/"+product.getId()+"/"+fileName);
                productRepository.save(product);
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void deleteProduct(Long id){
        Product deleteProduct=productRepository.findById(id).orElse(null);
        if(deleteProduct==null){
            throw new NullPointerException("Product not found");
        }
        try{
            FileUploadUtil.deleteFile("DoAnJava/src/main/resources/static/"+deleteProduct.getImage());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        productRepository.deleteById(id);

    }
}
