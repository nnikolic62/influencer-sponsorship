package cpm.influencer_sponsorship.influencer_sponsorship.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "influencer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "social_media_platform")
    private String socialMediaPlatform;
    @Column(name = "followers")
    private int followers;
    @Column(name = "engagment_rate")
    private double engagmentRate;
    @OneToMany(mappedBy = "influencer", cascade = {CascadeType.ALL})
    @JsonManagedReference(value = "influencer-offers")
    private List<Offer> offers = new ArrayList<>();
}
