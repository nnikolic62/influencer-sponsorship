package cpm.influencer_sponsorship.influencer_sponsorship.service.impl;

import cpm.influencer_sponsorship.influencer_sponsorship.entity.Brand;
import cpm.influencer_sponsorship.influencer_sponsorship.repository.BrandRepository;
import cpm.influencer_sponsorship.influencer_sponsorship.service.BrandService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {

    private BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }
    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand insertBrand(Brand brand) {
        Brand savedBrand = brandRepository.save(brand);

        return savedBrand;
    }

    @Override
    public Page<Brand> getAllBrandsPagination(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }
}
