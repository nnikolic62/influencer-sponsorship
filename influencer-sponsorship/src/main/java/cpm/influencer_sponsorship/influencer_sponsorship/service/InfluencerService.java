package cpm.influencer_sponsorship.influencer_sponsorship.service;

import cpm.influencer_sponsorship.influencer_sponsorship.entity.Influencer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InfluencerService {

    List<Influencer> getAllInfluencers();

    Influencer insert(Influencer influencer);

    void delete(Long id);

    Page<Influencer> getInfluencersPagination(Pageable pageable);
}
