package vijay.practice.Kubernetes.KubernetesDeploy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KubeTestController {

    @GetMapping("/hello")
    ResponseEntity<String> greet() {
        return ResponseEntity.ok("Hello Guys");
    }


}
