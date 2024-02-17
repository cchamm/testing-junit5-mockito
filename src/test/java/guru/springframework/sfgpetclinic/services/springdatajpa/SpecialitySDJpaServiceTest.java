package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    // Mock the specialtyRepository
    @Mock
    SpecialtyRepository specialtyRepository;

    // Inject mock through constructor
    @InjectMocks
    SpecialitySDJpaService service;

    @Test
    void findByIdText() {
        Speciality speciality = new Speciality();
        when(specialtyRepository.findById(1L)).thenReturn(java.util.Optional.of(speciality));
        Speciality foundSpecialty = service.findById(1L);
        assertNotNull(foundSpecialty);
        verify(specialtyRepository).findById(1L);
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        service.deleteById(1L);

        verify(specialtyRepository, times(2)).deleteById(1L);
    }

    @Test
    void deleteByIdAtLeastOne() {
        service.deleteById(1L);
        service.deleteById(1L);

        verify(specialtyRepository, atLeastOnce()).deleteById(1L);
    }

    @Test
    void deleteByIdAtMost() {
        service.deleteById(1L);
        service.deleteById(1L);

        verify(specialtyRepository, atMost(3)).deleteById(1L);
    }

    @Test
    void deleteByIdNever() {
        service.deleteById(1L);
        service.deleteById(1L);

        verify(specialtyRepository, atLeastOnce()).deleteById(1L);
        verify(specialtyRepository, never()).deleteById(5L);

    }



    // test delete
    @Test
    void delete() {
        service.delete(new Speciality());
    }


}