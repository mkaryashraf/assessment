package com.stc.assessment.dataaccess;

import com.stc.assessment.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File,Long> {
    File findByItemId(Long id);
}
