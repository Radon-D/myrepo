package example.datasource.repository;

import example.datasource.entity.Spitter;

public interface SpitterRepository {

    Spitter findOne(long id);

    void addSpitter(Spitter spitter);

}
