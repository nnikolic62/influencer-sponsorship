package cpm.influencer_sponsorship.influencer_sponsorship.controller;

import cpm.influencer_sponsorship.influencer_sponsorship.entity.Influencer;
import cpm.influencer_sponsorship.influencer_sponsorship.service.InfluencerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

//    get bez paginacije
//    @GetMapping
//    public ResponseEntity<List<Influencer>> getAll(){
//        List<Influencer> influencers = influencerService.getAllInfluencers();
//
//        return ResponseEntity.ok(influencers);
//    }

    @GetMapping
    public ResponseEntity<Page<Influencer>> getAllPaginated(Pageable pageable){
        //postavljanje default vrednosti
        if(pageable == null || !pageable.isPaged()){
            pageable = PageRequest.of(0, 10);
        }
        //definisanje maksimalnog prikaza po stranici
        int pageSize = pageable.getPageSize();
        if(pageSize > 100){
            pageable = PageRequest.of(pageable.getPageNumber(), 100, pageable.getSort());
        }
        Page<Influencer> result = influencerService.getInfluencersPagination(pageable);

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Influencer> insert(@RequestBody Influencer influencer){
        Influencer savedInfluencer = influencerService.insert(influencer);

        return new ResponseEntity<>(savedInfluencer, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        influencerService.delete(id);

        return ResponseEntity.ok("Deleted successfully!");
    }
}
