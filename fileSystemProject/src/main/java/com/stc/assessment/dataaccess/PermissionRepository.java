package com.stc.assessment.dataaccess;

import com.stc.assessment.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long> {
    List<Permission> findAllByPermissionGroupGroupName(String groupName);

    List<Permission> findAllByPermissionGroupId(Long id);

    List<Permission> findAllByUserEmail(String userEmail);

    Permission findByUserEmailAndPermissionGroupGroupName(String userEmail, String groupName);

    Permission findByUserEmailAndPermissionGroupId(String userEmail, Long id);
}
