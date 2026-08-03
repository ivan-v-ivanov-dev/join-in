package com.joinin.group.repository;

import com.joinin.group.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    @Query("""
        SELECT DISTINCT groupEntity
        FROM GroupMember groupMember
        JOIN groupMember.group groupEntity
        WHERE groupMember.profileIdentity = :profileIdentity
        ORDER BY groupEntity.name
        """)
    List<Group> findAllJoinedGroupsByProfileIdentity(@Param("profileIdentity") String profileIdentity
    );
}