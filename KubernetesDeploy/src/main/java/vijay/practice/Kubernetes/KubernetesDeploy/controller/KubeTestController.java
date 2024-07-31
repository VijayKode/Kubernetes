package vijay.practice.Kubernetes.KubernetesDeploy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class KubeTestController {

    @GetMapping("/hello")
    ResponseEntity<String> greet() {
        log.info("Print Number from 1 to 5000");
        for(int i =0; i < 50000; i++) {
        }
        return ResponseEntity.ok("Hello Guys");
    }


}
