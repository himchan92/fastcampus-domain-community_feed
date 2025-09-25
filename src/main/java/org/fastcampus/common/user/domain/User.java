package org.fastcampus.common.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.fastcampus.common.domain.PositiveIntegerCounter;

@Getter
@Builder
@AllArgsConstructor
public class User {

    private Long id;

    private UserInfo info;

    private PositiveIntegerCounter followingCount;

    private PositiveIntegerCounter followerCount;

    public User(Long id, UserInfo info) {
        if (info == null) {
            throw new IllegalArgumentException("UserInfo cannot be null");
        }

        this.id = id;
        this.info = info;
        this.followingCount = new PositiveIntegerCounter();
        this.followerCount = new PositiveIntegerCounter();
    }

    public void follow(User followee) {
        if (this.equals(followee)) {
            throw new IllegalArgumentException("");
        }

        followingCount.increase();
        followee.increaseFollowerCount();
    }

    public void unfollow(User followee) {
        if (this.equals(followee)) {
            throw new IllegalArgumentException("");
        }

        followingCount.decrease();
        followee.decreaseFollowerCount();
    }

    private void increaseFollowerCount() {
        followerCount.increase();
    }

    private void decreaseFollowerCount() {
        followerCount.decrease();
    }

    public int getFollowingCount() {
        return followingCount.getCount();
    }

    public int getFollowerCount() {
        return followerCount.getCount();
    }

    public String getProfileImage() {
        return info.getProfileImageUrl();
    }

    public String getName() {
        return info.getName();
    }
}
