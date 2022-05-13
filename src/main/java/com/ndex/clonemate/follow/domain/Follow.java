package com.ndex.clonemate.follow.domain;

import com.ndex.clonemate.user.domain.User;
import com.ndex.clonemate.user.domain.UserResponseMapping;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "follows")
@Entity
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_id", nullable = false)
    private User target;

    @Builder
    public Follow(User user, User target) {
        this.user = user;
        this.target = target;
    }
}
