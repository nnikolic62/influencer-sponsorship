package cpm.influencer_sponsorship.influencer_sponsorship.service;

import cpm.influencer_sponsorship.influencer_sponsorship.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BrandService {

    List<Brand> getAllBrands();
    Brand insertBrand(Brand brand);
    Page<Brand> getAllBrandsPagination(Pageable pageable);
}
