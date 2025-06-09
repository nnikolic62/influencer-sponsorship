package cpm.influencer_sponsorship.influencer_sponsorship.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import cpm.influencer_sponsorship.influencer_sponsorship.entity.Brand;
import cpm.influencer_sponsorship.influencer_sponsorship.entity.Influencer;
import cpm.influencer_sponsorship.influencer_sponsorship.entity.Offer;
import cpm.influencer_sponsorship.influencer_sponsorship.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/offers")
public class OfferController {

    private OfferService offerService;
    private ObjectMapper objectMapper;

    @Autowired
    public OfferController(OfferService offerService, ObjectMapper objectMapper){
        this.offerService = offerService;
        this.objectMapper = objectMapper;
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

    @PatchMapping("/{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable Long id, @RequestBody Map<String, Object> patchPayload){
        Offer currentOffer = offerService.findById(id);

        if(currentOffer == null){
            throw new RuntimeException("No offer found!");
        }

        if(patchPayload.containsKey("id")){
            throw new RuntimeException("Cant change the id of the offer!");
        }

        Offer newOffer = apply(patchPayload, currentOffer);

        Offer dbOffer = offerService.insert(newOffer);

        return ResponseEntity.ok(dbOffer);
    }

    @GetMapping("influencer/{influencerId}")
    public ResponseEntity<List<Offer>> findByInfluencerId(@PathVariable Long influencerId){
        List<Offer> foundOffers = offerService.filterByInfluencerId(influencerId);

        return ResponseEntity.ok(foundOffers);
    }

    @GetMapping("brand/{brandId}")
    public ResponseEntity<List<Offer>> findByBrandId(@PathVariable Long brandId){
        List<Offer> foundOffers = offerService.filterByBrandId(brandId);

        return ResponseEntity.ok(foundOffers);
    }

    //custom metoda za patch
    private Offer apply(Map<String, Object> patchPayload, Offer currentOffer) {
        Brand currentBrand = currentOffer.getBrand();
        Influencer currentInfluencer = currentOffer.getInfluencer();

        ObjectNode currentNode = objectMapper.convertValue(currentOffer, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        currentNode.setAll(patchNode);

        Offer newOffer = objectMapper.convertValue(currentNode, Offer.class);

        newOffer.setBrand(currentBrand);
        newOffer.setInfluencer(currentInfluencer);

        return newOffer;
    }
}
