package cpm.influencer_sponsorship.influencer_sponsorship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "offer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "money_amount")
    private double moneyAmount;
    @Column(name = "accepted")
    private boolean accepted;
    @ManyToOne
    @JoinColumn(name = "influencer_id")
    private Influencer influencer;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
