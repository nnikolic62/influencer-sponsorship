package cpm.influencer_sponsorship.influencer_sponsorship.service;

import cpm.influencer_sponsorship.influencer_sponsorship.entity.Offer;

import java.util.List;

public interface OfferService {

    List<Offer> getAllOffers();

    Offer insert(Offer offer);
}
