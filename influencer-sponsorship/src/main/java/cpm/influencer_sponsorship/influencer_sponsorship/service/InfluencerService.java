package cpm.influencer_sponsorship.influencer_sponsorship.service;

import cpm.influencer_sponsorship.influencer_sponsorship.entity.Influencer;

import java.util.List;

public interface InfluencerService {

    List<Influencer> getAllInfluencers();

    Influencer insert(Influencer influencer);
}
