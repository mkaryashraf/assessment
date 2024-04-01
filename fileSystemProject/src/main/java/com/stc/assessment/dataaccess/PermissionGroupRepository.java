package com.stc.assessment.dataaccess;

import com.stc.assessment.domain.PermissionGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionGroupRepository extends JpaRepository<PermissionGroup,Long> {


    PermissionGroup findByGroupName(String groupName);

}
