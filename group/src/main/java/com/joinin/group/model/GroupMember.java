package com.joinin.group.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "group_members",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_group_members_group_profile",
                        columnNames = {
                                "group_identity",
                                "profile_identity"
                        }
                )
        },
        indexes = {
                @Index(
                        name = "idx_group_members_profile_identity",
                        columnList = "profile_identity"
                )
        }
)
public class GroupMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "group_identity",
            referencedColumnName = "identity",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_group_members_group"
            )
    )
    private Group group;

    @Column(
            name = "profile_identity",
            nullable = false,
            length = 200
    )
    private String profileIdentity;
}
