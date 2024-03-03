package infrastructure.rest;

import application.services.FeatureApplicationService;
import domain.entities.FeatureEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/features")
public class FeatureRestController {

    private final FeatureApplicationService featureApplicationService;

    @Autowired
    public FeatureRestController(FeatureApplicationService featureApplicationService) {
        this.featureApplicationService = featureApplicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeatureEntity> getFeature(@PathVariable Long id) {
        // Logic to retrieve a feature by its ID
        return ResponseEntity.ok().body(featureApplicationService.processFeature(id));
    }

    @PostMapping
    public ResponseEntity<FeatureEntity> createFeature(@RequestBody FeatureEntity feature) {
        // Logic to create a new feature
        return ResponseEntity.ok().body(featureApplicationService.processFeature(feature));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeatureEntity> updateFeature(@PathVariable Long id, @RequestBody FeatureEntity feature) {
        // Logic to update an existing feature by its ID
        return ResponseEntity.ok().body(featureApplicationService.processFeature(feature));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeature(@PathVariable Long id) {
        // Logic to delete a feature by its ID
        featureApplicationService.processFeatureDeletion(id);
        return ResponseEntity.ok().build();
    }

}