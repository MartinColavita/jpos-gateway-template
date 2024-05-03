package eldar.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "tranlog")
public class Tranlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "mti",nullable = false)
    private String mti;

    @Column(name = "panNumber",nullable = false)
    private String panNumber;

    @Column(name = "responseCode", nullable = false)
    private String responseCode;


    public Tranlog(){

    }

    public Tranlog (String mti, String panNumber,String responseCode) {
        this.mti = mti;
        this.panNumber = panNumber;
        this.responseCode = responseCode;
    }

}
