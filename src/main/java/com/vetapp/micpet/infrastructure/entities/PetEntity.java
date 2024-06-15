package com.vetapp.micpet.infrastructure.entities;

import com.vetapp.micpet.domain.models.Pet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "PETS")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "OWNER_ID", nullable = false)
    private Long ownerId;

    public static PetEntity fromDomain(Pet pet) {
        return new PetEntity(pet.getId(), pet.getName(), pet.getOwnerId());
    }

    public Pet toDomainModel() {
        return new Pet(id, name, ownerId);
    }
}
