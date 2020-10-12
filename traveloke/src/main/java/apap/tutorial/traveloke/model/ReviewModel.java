package apap.tutorial.traveloke.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="review")
public class ReviewModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noReview;

    @NotNull
    @Size(max=10)
    @Column(name="namaReviewer", nullable = false)
    private String namaReviewer;

    @NotNull
    @Size(max=50)
    @Column(name="isiReview", nullable = false)
    private String isiReview;


    @Size(max=50)
    @Column(name="saranReview", nullable = true)
    private String saranReview;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "noKamar", referencedColumnName = "noKamar", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private KamarModel kamar;


}
