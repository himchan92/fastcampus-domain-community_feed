package org.fastcampus.user.domain;

import java.util.Objects;
import org.fastcampus.post.domain.common.PositiveIntegerCounter;

// 유저 생성(id 기준 구분)
public class User {

    private final Long id;
    private final UserInfo info;
    private final PositiveIntegerCounter followingCount;
    private final PositiveIntegerCounter followerCount;

    public User(Long id, UserInfo userInfo) {
        this.id = id;
        this.info = userInfo;
        this.followingCount = new PositiveIntegerCounter();
        this.followerCount = new PositiveIntegerCounter();
    }

    //팔로워
    public void follow(User targetUser) {
        if(targetUser.equals(this)) {
            throw new IllegalArgumentException();
        }

        followerCount.increase();
        targetUser.followingCount.increase();
    }

    //팔로워 취소
    public void unfollow(User targetUser) {
        if(this.equals(targetUser)) {
            throw new IllegalArgumentException();
        }

        followingCount.decrease();
        targetUser.followingCount.decrease();
    }

    //팔로워 수 증가
    private void increaseFollowerCount() {
        followerCount.increase();
    }

    //팔로워 수 감소
    private void decreaseFollowerCount() {
        followerCount.decrease();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) {
            return false;
        }
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId() {
        return id;
    }
}
