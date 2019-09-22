package com.okta.springbootvue.entity;
import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Data
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name="HOSPITAL")
public class Hospital {
 @Id
 @SequenceGenerator(name="HOSPITAL_SEQ",sequenceName="HOSPITAL_SEQ")
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="HOSPITAL_SEQ")
 @Column(name="HOSPITAL_ID",unique = true, nullable = true)
 private @NonNull Long id;
 private @NonNull String hos_name;
 @OneToMany(fetch = FetchType.EAGER)
 private @NonNull Collection<Claim> claim;
 protected Hospital(){}
 public Hospital(String hos_name ){
    this.hos_name = hos_name;
    }
   
}