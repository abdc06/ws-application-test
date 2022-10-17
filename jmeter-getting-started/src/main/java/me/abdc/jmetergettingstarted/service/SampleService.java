package me.abdc.jmetergettingstarted.service;

import me.abdc.jmetergettingstarted.entity.Sample;

import java.util.List;
import java.util.Optional;

public interface SampleService {

    List<Sample> findAll();

    Optional<Sample> findById(Long id);
}
