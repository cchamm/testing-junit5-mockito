package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository repository;

    @InjectMocks
    VisitSDJpaService service;


    @DisplayName("Test Find All")
    @Test
    void findAll() {
        var set = new HashSet<Visit>();
        set.add(new Visit(1L, LocalDate.EPOCH));
        set.add(new Visit(2L, LocalDate.of(2021, 1, 1)));
        when(repository.findAll()).thenReturn(set);

        var visits = service.findAll();
        verify(repository).findAll();
        assertEquals(2, visits.size());
        assertEquals(set, visits);
    }

    @Test
    void findById() {
        var visit = new Visit(1L, LocalDate.EPOCH);
        when(repository.findById(1L)).thenReturn(java.util.Optional.of(visit));

        var found = service.findById(1L);
        verify(repository).findById(anyLong());
        assertNotNull(found);
        assertEquals(visit, found);

    }

    @Test
    void save() {
        var visit = new Visit(1L, LocalDate.EPOCH);
        when(repository.save(visit)).thenReturn(visit);

        var saved = service.save(visit);
        verify(repository).save(visit);
        assertNotNull(saved);
        assertEquals(visit, saved);

    }

    @Test
    void delete() {

        var visit = new Visit(1L, LocalDate.EPOCH);
        service.delete(visit);
        verify(repository).delete(visit);
    }

    @Test
    void deleteById() {

        service.deleteById(1L);
        verify(repository).deleteById(anyLong());
    }


}