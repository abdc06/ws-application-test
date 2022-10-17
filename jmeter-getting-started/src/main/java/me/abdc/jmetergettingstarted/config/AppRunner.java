package me.abdc.jmetergettingstarted.config;

import lombok.RequiredArgsConstructor;
import me.abdc.jmetergettingstarted.entity.Sample;
import me.abdc.jmetergettingstarted.repository.SampleRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class AppRunner implements ApplicationRunner {

    final SampleRepository sampleRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        IntStream.range(0, 100).forEach(i -> {
            Sample sample = Sample.builder()
                    .name("Runtime Environment" + i)
                    .description("Integration Layer")
                    .createdBy("SYSTEM")
                    .createdOn(LocalDateTime.now())
                    .build();

            sampleRepository.save(sample);
        });
    }
}
