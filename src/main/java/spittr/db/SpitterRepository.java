package spittr.db;

import spittr.domain.Spitter;

import java.util.List;

/**
 * @author: monkey
 * @date: 2018/5/29 22:41
 */
public interface SpitterRepository {

    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();

}
