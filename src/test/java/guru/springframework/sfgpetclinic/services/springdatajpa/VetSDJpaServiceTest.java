package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {

    @Mock
    VetRepository vetRepository;

    @InjectMocks
    VetSDJpaService service;


    @Test
    void deleteById() {
        service.deleteById(1L);

//        verify(vetRepository, times(1)).deleteById(1L);
        verify(vetRepository).deleteById(1L);
    }

    @Test
    void deleteByObject() {
        Vet vet = new Vet(
                1L,
                "Joe",
                "Buck",
                null
        );

        service.delete(vet);
        verify(vetRepository).delete(any(Vet.class));
    }

    @Test
    void findById() {
        Vet vet = new Vet(
                1L,
                "Joe",
                "Buck",
                null
        );

        when(vetRepository.findById(1L)).thenReturn(Optional.of(vet));

        var returned = service.findById(1L);
        verify(vetRepository).findById(1L);

        assertEquals(vet, returned);
    }
}