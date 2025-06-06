package cpm.influencer_sponsorship.influencer_sponsorship.controller;

import cpm.influencer_sponsorship.influencer_sponsorship.entity.Offer;
import cpm.influencer_sponsorship.influencer_sponsorship.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {

    private OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService){
        this.offerService = offerService;
    }

    @GetMapping
    public ResponseEntity<List<Offer>> getAll(){
        return ResponseEntity.ok(offerService.getAllOffers());
    }

    @PostMapping
    public ResponseEntity<Offer> insert(@RequestBody Offer offer){
        Offer savedOffer = offerService.insert(offer);

        return new ResponseEntity<>(savedOffer, HttpStatus.CREATED);
    }
}
