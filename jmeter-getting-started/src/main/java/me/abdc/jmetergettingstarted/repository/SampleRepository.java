package me.abdc.jmetergettingstarted.repository;

import me.abdc.jmetergettingstarted.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<Sample, Long> {
}
