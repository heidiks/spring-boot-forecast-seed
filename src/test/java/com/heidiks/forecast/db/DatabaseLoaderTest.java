package com.heidiks.forecast.db;

import com.heidiks.forecast.model.City;
import com.heidiks.forecast.repository.CityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by heidi on 18/05/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class DatabaseLoaderTest {

    @InjectMocks
    private DatabaseLoader db;

    @Mock
    private CityRepository repository;

    @Test
    public void run() throws Exception {
        db.run(null);

        verify(repository).save(new City("Maringá", "Brazil"));
        verify(repository).save(new City("Blumenau", "Brazil"));
    }

}