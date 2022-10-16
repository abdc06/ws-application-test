package me.abdc.mockitogettingstarted.study;

import me.abdc.mockitogettingstarted.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {

    @Override
    <S extends Study> S save(S entity);
}
