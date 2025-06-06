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
}
