package cpm.influencer_sponsorship.influencer_sponsorship.repository;

import cpm.influencer_sponsorship.influencer_sponsorship.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    List<Offer> findByInfluencerId(Long id);

    List<Offer> findByBrandId(Long id);
}
