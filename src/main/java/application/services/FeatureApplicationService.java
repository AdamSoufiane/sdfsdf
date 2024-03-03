package application.services;

import domain.entities.FeatureEntity;
import domain.services.FeatureDomainService;
import application.ports.out.FeatureRepositoryPort;

public class FeatureApplicationService {

    private final FeatureDomainService featureDomainService;
    private final FeatureRepositoryPort featureRepositoryPort;

    public FeatureApplicationService(FeatureDomainService featureDomainService, FeatureRepositoryPort featureRepositoryPort) {
        this.featureDomainService = featureDomainService;
        this.featureRepositoryPort = featureRepositoryPort;
    }

    // Method implementations would go here, such as processFeature
    // Since the actual logic and parameters are not specified, they are not implemented here
}
