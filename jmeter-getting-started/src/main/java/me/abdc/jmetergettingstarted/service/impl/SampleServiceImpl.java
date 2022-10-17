package me.abdc.jmetergettingstarted.service.impl;

import lombok.RequiredArgsConstructor;
import me.abdc.jmetergettingstarted.entity.Sample;
import me.abdc.jmetergettingstarted.repository.SampleRepository;
import me.abdc.jmetergettingstarted.service.SampleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SampleServiceImpl implements SampleService {

    final SampleRepository sampleRepository;

    @Override
    public List<Sample> findAll() {
        return sampleRepository.findAll();
    }

    @Override
    public Optional<Sample> findById(Long id) {
        return sampleRepository.findById(id);
    }
}
