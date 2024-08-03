package vijay.practice.Kubernetes.KubernetesDeploy.controller;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@RestController
public class KubeTestController {
    String fileName = "/filelocation/hello_world.txt";

    @GetMapping("/hello")
    ResponseEntity<String> greet() {
        log.info("Print Number from 1 to 5000");
        for (int i = 0; i < 50000; i++) {
        }
        return ResponseEntity.ok("Hello Guys");
    }

    @GetMapping("/writefile")
    ResponseEntity<String> writeFile() {
        log.info("Writing file to host path");
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Hello, World!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return ResponseEntity.ok("Written file");
    }

    @GetMapping("/readfile")
    @SneakyThrows
    ResponseEntity<String> readfile() {
        log.info("Reading file to host path");
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        log.info("File Content {}", content);
        return ResponseEntity.ok(content);
    }


}
