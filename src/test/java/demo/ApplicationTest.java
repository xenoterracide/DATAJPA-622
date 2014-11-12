package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Persistable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest {

    @Autowired
    CharacterRepository repository;

    @Test
    public void trySaveAbstractPersistableCharacter () {

        Character c = new Character();

        Persistable<UUID> saved = repository.save( c );
        assertThat( saved, instanceOf( Character.class ) );

        Persistable<UUID> loaded = repository.findOne( saved.getId() );
        assertEquals( loaded, saved );
    }

}
