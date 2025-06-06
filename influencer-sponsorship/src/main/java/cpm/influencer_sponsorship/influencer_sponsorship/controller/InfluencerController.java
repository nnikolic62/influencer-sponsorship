package cpm.influencer_sponsorship.influencer_sponsorship.controller;

import cpm.influencer_sponsorship.influencer_sponsorship.entity.Influencer;
import cpm.influencer_sponsorship.influencer_sponsorship.service.InfluencerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/influencers")
public class InfluencerController {

    private InfluencerService influencerService;

    @Autowired
    public InfluencerController(InfluencerService influencerService){
        this.influencerService = influencerService;
    }

    @GetMapping()
    public ResponseEntity<List<Influencer>> getAll(){
        List<Influencer> influencers = influencerService.getAllInfluencers();

        return ResponseEntity.ok(influencers);
    }

    @PostMapping
    public ResponseEntity<Influencer> insert(@RequestBody Influencer influencer){
        Influencer savedInfluencer = influencerService.insert(influencer);

        return new ResponseEntity<>(savedInfluencer, HttpStatus.CREATED);
    }
}
