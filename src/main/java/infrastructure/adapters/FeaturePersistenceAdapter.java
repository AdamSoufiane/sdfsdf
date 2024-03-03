package infrastructure.adapters;

import application.ports.out.FeatureRepositoryPort;
import domain.entities.FeatureEntity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

public class FeaturePersistenceAdapter implements FeatureRepositoryPort {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<FeatureEntity> findById(Long id) {
        return Optional.ofNullable(entityManager.find(FeatureEntity.class, id));
    }

    @Override
    public FeatureEntity save(FeatureEntity featureEntity) {
        if (featureEntity.getId() == null) {
            entityManager.persist(featureEntity);
        } else {
            entityManager.merge(featureEntity);
        }
        return featureEntity;
    }

    @Override
    public void deleteById(Long id) {
        FeatureEntity featureEntity = entityManager.find(FeatureEntity.class, id);
        if (featureEntity != null) {
            entityManager.remove(featureEntity);
        }
    }
}