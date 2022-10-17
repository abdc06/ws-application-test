package me.abdc.jmetergettingstarted.web;

import lombok.RequiredArgsConstructor;
import me.abdc.jmetergettingstarted.service.SampleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SampleController {

    final SampleService sampleService;

    @GetMapping("/samples")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(sampleService.findAll());
    }

    @GetMapping("/samples/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok(sampleService.findById(id));
    }
}
