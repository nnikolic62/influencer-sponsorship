package cpm.influencer_sponsorship.influencer_sponsorship.service.impl;

import cpm.influencer_sponsorship.influencer_sponsorship.entity.Influencer;
import cpm.influencer_sponsorship.influencer_sponsorship.repository.InfluencerRepository;
import cpm.influencer_sponsorship.influencer_sponsorship.service.InfluencerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfluencerServiceImpl implements InfluencerService {

    private InfluencerRepository influencerRepository;
    @Autowired
    public InfluencerServiceImpl(InfluencerRepository influencerRepository){
        this.influencerRepository = influencerRepository;
    }
    @Override
    public List<Influencer> getAllInfluencers() {
        return influencerRepository.findAll();
    }

    @Override
    public Influencer insert(Influencer influencer) {
        Influencer savedInfluencer = influencerRepository.save(influencer);

        return savedInfluencer;
    }

    @Override
    public void delete(Long id) {
        Influencer influencer = influencerRepository.findById(id).orElseThrow(() -> new RuntimeException("Error!"));

        influencerRepository.delete(influencer);
    }

    @Override
    public Page<Influencer> getInfluencersPagination(Pageable pageable) {
        return influencerRepository.findAll(pageable);
    }
}
