package com.pbcompass.park_api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_client_have_parking_spot")
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ClientParkingSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "receipt_number", nullable = false, unique = true, length = 15)
    private String receipt;
    @Column(name = "licensePlate", nullable = false, length = 8)
    private String licensePlate;
    @Column(name = "brand", nullable = false, length = 45)
    private String brand;
    @Column(name = "model", nullable = false, length = 45)
    private String model;
    @Column(name = "color", nullable = false, length = 45)
    private String color;
    @Column(name = "entry_date", nullable = false, length = 45)
    private LocalDateTime entryDate;
    @Column(name = "exit_date")
    private LocalDateTime exitDate;
    @Column(name = "value", columnDefinition = "decimal(7,2)")
    private BigDecimal value;
    @Column(name = "discount", columnDefinition = "decimal(7,2)")
    private BigDecimal discount;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;
    @ManyToOne
    @JoinColumn(name = "id_parking_spot", nullable = false)
    private ParkingSpot parkingSpot;

    @CreatedDate
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @LastModifiedDate
    @Column(name = "modificatio_date")
    private LocalDateTime modificationDate;
    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;
    @LastModifiedBy
    @Column(name = "modificated_by")
    private String modificatedBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientParkingSpot that = (ClientParkingSpot) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
