package cpm.influencer_sponsorship.influencer_sponsorship.service.impl;

import cpm.influencer_sponsorship.influencer_sponsorship.entity.Offer;
import cpm.influencer_sponsorship.influencer_sponsorship.repository.OfferRepository;
import cpm.influencer_sponsorship.influencer_sponsorship.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OfferServiceImpl implements OfferService {

    private OfferRepository offerRepository;
    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository){
        this.offerRepository = offerRepository;
    }
    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public Offer insert(Offer offer) {
        Offer savedOffer = offerRepository.save(offer);
        
        return savedOffer;
    }

    @Override
    public Offer findById(Long id) {
        Offer offer = offerRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found!"));

        return offer;
    }

    @Override
    public List<Offer> filterByInfluencerId(Long id) {
        List<Offer> foundOffers = offerRepository.findByInfluencerId(id);

        return foundOffers;
    }

    @Override
    public List<Offer> filterByBrandId(Long id) {
        List<Offer> foundOffers = offerRepository.findByBrandId(id);

        return foundOffers;
    }
}
