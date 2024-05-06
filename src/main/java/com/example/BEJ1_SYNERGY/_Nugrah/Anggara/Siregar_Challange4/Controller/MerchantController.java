package com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Controller;


import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.Merchant;
import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/merchant")
public class MerchantController {
    @Autowired
    MerchantService merchantService;

    @GetMapping(path = "/open-merchant")
    public List<Merchant> getMerchant(){
        return merchantService.getOpenMerchant();
    }


    @PutMapping(path = "/status/{id}/{status}")
    public Merchant editStatusMerchant(@PathVariable String id,@PathVariable String status){
        Boolean statu = Boolean.valueOf(status);
        UUID uuid = UUID.fromString(id);
        return merchantService.editStatusMerchant(uuid,statu);
    }

    @PostMapping(path = "/daftar-merchant")
    public Merchant addMerchant(@RequestBody Merchant merchant){
        return merchantService.addingMerchant(merchant);
    }
}
