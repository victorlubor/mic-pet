package com.vetapp.micpet.infrastructure.adapters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.vetapp.micpet.domain.models.Pet;
import com.vetapp.micpet.infrastructure.entities.PetEntity;
import com.vetapp.micpet.infrastructure.mappers.PetMapperInfra;
import com.vetapp.micpet.infrastructure.repositories.JpaPetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class JpaPetRepositoryAdapterTest {

  @Mock
  private JpaPetRepository jpaPetRepository;

  @Mock
  private PetMapperInfra petMapperInfra;

  @InjectMocks
  private JpaPetRepositoryAdapter jpaPetRepositoryAdapter;

  @Test
  void save_whenCalled_mapsAndSavesCorrectly() {
    Pet pet = new Pet();
    PetEntity petEntity = new PetEntity();

    when(petMapperInfra.domainToEntity(any(Pet.class))).thenReturn(petEntity);
    when(jpaPetRepository.save(any(PetEntity.class))).thenReturn(petEntity);
    when(petMapperInfra.entityToDomain(any(PetEntity.class))).thenReturn(pet);

    Pet result = jpaPetRepositoryAdapter.save(pet);

    verify(petMapperInfra).domainToEntity(pet);
    verify(jpaPetRepository).save(petEntity);
    verify(petMapperInfra).entityToDomain(petEntity);
    assertEquals(pet, result);
  }

}
