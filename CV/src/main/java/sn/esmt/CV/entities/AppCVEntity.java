package sn.esmt.CV.entities;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.web.SortDefault;



import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//?
@Entity
@Table(name = "appcv" )
public class AppCVEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 200)
    private String experienceProfessionnelle;

    @Column(length = 100)
    private String nom;

    @Column(length = 150)
    private String prenom;


    private int age;

    @Column(length = 200)
    private String addresse;

    @Column(length = 200 ,unique = true)
    private String email;

    @Column(length = 30)
    private String telephone;

    @Column(length = 200)
    private String specialite;

    @Column(length = 200)
    private String niveauEtude;


}
