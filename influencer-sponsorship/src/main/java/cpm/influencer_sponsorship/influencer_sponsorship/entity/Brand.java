package cpm.influencer_sponsorship.influencer_sponsorship.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "brand")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "budget")
    private double budget;
    @OneToMany(mappedBy = "brand", cascade = {CascadeType.ALL})
    @JsonManagedReference(value = "brand-offers")
    private List<Offer> offers;

}
