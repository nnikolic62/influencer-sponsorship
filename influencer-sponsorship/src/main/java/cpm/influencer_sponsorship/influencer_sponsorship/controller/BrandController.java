package cpm.influencer_sponsorship.influencer_sponsorship.controller;

import cpm.influencer_sponsorship.influencer_sponsorship.entity.Brand;
import cpm.influencer_sponsorship.influencer_sponsorship.service.BrandService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

//    @GetMapping
//    public ResponseEntity<List<Brand>> getAll(){
//        List<Brand> brands = brandService.getAllBrands();
//
//        return ResponseEntity.ok(brands);
//    }

    @GetMapping
    public ResponseEntity<Page<Brand>> getAllBrandsPagination(Pageable pageable){
        if(pageable == null || !pageable.isPaged()){
            pageable = PageRequest.of(0, 10);
        }
        int pageSize = pageable.getPageSize();
        if(pageSize > 100){
            pageable = PageRequest.of(pageable.getPageNumber(), 100, pageable.getSort());
        }
        Page<Brand> resultList = brandService.getAllBrandsPagination(pageable);

        return ResponseEntity.ok(resultList);

    }

    @PostMapping
    public ResponseEntity<Brand> insert(@RequestBody Brand brand){
        Brand savedBrand = brandService.insertBrand(brand);

        return new ResponseEntity<>(savedBrand, HttpStatus.CREATED);
    }

}
