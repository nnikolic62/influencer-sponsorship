package cpm.influencer_sponsorship.influencer_sponsorship.controller;

import cpm.influencer_sponsorship.influencer_sponsorship.entity.Brand;
import cpm.influencer_sponsorship.influencer_sponsorship.service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    private BrandService brandService;

    public BrandController(BrandService brandService){
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseEntity<List<Brand>> getAll(){
        List<Brand> brands = brandService.getAllBrands();

        return ResponseEntity.ok(brands);
    }

    @PostMapping
    public ResponseEntity<Brand> insert(@RequestBody Brand brand){
        Brand savedBrand = brandService.insertBrand(brand);

        return new ResponseEntity<>(savedBrand, HttpStatus.CREATED);
    }

}
