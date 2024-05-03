package com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Controller;


import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Product;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Service.ProductService;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/produk")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(path = "/productlist")
    public List<Product> getProduct(){
        return productService.getProduct();
    }

    @PostMapping(path = "/registrasi")
    public Product addProduct(@ModelAttribute Product product){
        return productService.addProduct(product);
    }

    @PutMapping(path = "/{id}")
    public Product updateProduct(@PathVariable String id,@ModelAttribute Product product){
        return productService.updateProduct(UUID.fromString(id),product);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable String id){
        UUID uuid = UUID.fromString(id);
        return productService.deleteProduct(uuid);
    }
}
