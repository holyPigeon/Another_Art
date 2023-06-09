package com.imagine.another_arts.domain.likeart.repository.custom;

import com.imagine.another_arts.domain.likeart.LikeArt;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static com.imagine.another_arts.domain.art.QArt.art;
import static com.imagine.another_arts.domain.likeart.QLikeArt.likeArt;
import static com.imagine.another_arts.domain.user.QUser.user;

@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LikeArtQueryDslRepositoryImpl implements LikeArtQueryDslRepository {
    private final JPAQueryFactory query;

    @Override
    public List<LikeArt> findAllWithFetchArt() {
        return query
                .select(likeArt)
                .from(likeArt)
                .innerJoin(likeArt.art, art).fetchJoin()
                .fetch();
    }

    @Override
    public Long getLikeArtCountByArtId(Long artId) {
        return query
                .select(likeArt.count())
                .from(likeArt)
                .innerJoin(likeArt.art, art)
                .innerJoin(likeArt.user, user)
                .where(artIdEq(artId))
                .fetchOne();
    }

    @Override
    @Transactional
    public Long deleteByArtAndUser(Long artId, Long userId) {
        return query
                .delete(likeArt)
                .where(artIdEq(artId), userIdEq(userId))
                .execute();
    }

    @Override
    @Transactional
    public Long deleteInBatchByArtId(Long artId) {
        return query
                .delete(likeArt)
                .where(artIdEq(artId))
                .execute();
    }

    private BooleanExpression artIdEq(Long artId) {
        if (Objects.isNull(artId)) {
            return null;
        }

        return art.id.eq(artId);
    }

    private BooleanExpression userIdEq(Long userId) {
        if (Objects.isNull(userId)) {
            return null;
        }

        return user.id.eq(userId);
    }
}
