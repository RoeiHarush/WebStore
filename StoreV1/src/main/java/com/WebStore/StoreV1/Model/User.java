package com.WebStore.StoreV1.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String first_Name;
    public String last_Name;
    public String email;
    public String user_Name;
    public String password;
    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart = new Cart();


}