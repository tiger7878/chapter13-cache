import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.config.RootConfig;
import spittr.db.SpitterRepository;
import spittr.domain.Spitter;

import static org.junit.Assert.assertEquals;

/**
 * User: monkey
 * Date: 2018-05-30 11:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class SpitterRepositoryTest {

    @Autowired
    private SpitterRepository spitterRepository;

    @Test
    public void count(){
        assertEquals(4,spitterRepository.count());
    }

    @Test
    public void findOne(){
        assertEquals("habuma",spitterRepository.findOne(4L).getUsername());
//        assertEquals("monkey",spitterRepository.findOne(5L).getUsername());
    }

    @Test
    public void save(){
        Spitter spitter = new Spitter(null, "monkey", "monkey", "monkey", "1@1.com", true);
        spitterRepository.save(spitter);

        assertEquals(5,spitterRepository.count());
    }

}
