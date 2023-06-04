package eu.codeacademy.hibernate2.dao;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Getter
public class GenericDao<T> {

    private final Session session;
    private final Class<T> entityClass; // use reflection

    public List<T> getAll() {
        return session.createQuery("FROM " + entityClass.getName(), entityClass).list();
    }

    public Optional<T> getById(Long id) {
        return Optional.ofNullable(session.get(entityClass, id));
    }

    public void saveOrUpdate(T pojo) {
        session.persist(pojo);
    }

    public void delete(Long id) {
        getById(id).ifPresent(session::remove);
    }

}
