package eldar.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "tranlog")
@NoArgsConstructor
public class Tranlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "mti",nullable = false)
    private String mti;

    @Column(name = "panNumber",nullable = false)
    private String panNumber;



    public Tranlog (String mti, String panNumber) {
        this.mti = mti;
        this.panNumber = panNumber;
    }

}
