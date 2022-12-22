package com.loops.loopsapi.user.persistence;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.loops.loopsapi.history.pesistence.entity.Invoice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 8132776338176864765L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name; //Mandatory field

    private String email;

    private String password;

    private String phoneNumber;

    private String gender;

    private BigDecimal balance;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String address; //Secondary Field

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String addressAlter;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String province;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cities;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String postalCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String country;

//    @OneToMany (mappedBy = "user")
//    private List<Invoice> invoice;

}
