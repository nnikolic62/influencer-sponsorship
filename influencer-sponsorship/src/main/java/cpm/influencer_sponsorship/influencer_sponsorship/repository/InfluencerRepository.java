package cpm.influencer_sponsorship.influencer_sponsorship.repository;

import cpm.influencer_sponsorship.influencer_sponsorship.entity.Influencer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfluencerRepository extends JpaRepository<Influencer, Long> {
}
