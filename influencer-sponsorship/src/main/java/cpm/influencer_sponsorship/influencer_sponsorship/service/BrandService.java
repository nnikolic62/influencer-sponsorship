package cpm.influencer_sponsorship.influencer_sponsorship.service;

import cpm.influencer_sponsorship.influencer_sponsorship.entity.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> getAllBrands();

    Brand insertBrand(Brand brand);
}
