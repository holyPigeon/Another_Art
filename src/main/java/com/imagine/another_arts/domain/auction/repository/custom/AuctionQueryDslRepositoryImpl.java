package com.imagine.another_arts.domain.auction.repository.custom;

import com.imagine.another_arts.domain.auction.Auction;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

import static com.imagine.another_arts.domain.art.QArt.art;
import static com.imagine.another_arts.domain.auction.QAuction.auction;
import static com.imagine.another_arts.domain.user.QUser.user;

@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuctionQueryDslRepositoryImpl implements AuctionQueryDslRepository {
    private final JPAQueryFactory query;

    @Override
    public Optional<Auction> findByAuctionId(Long auctionId) {
        return Optional.ofNullable(
                query
                        .select(auction)
                        .from(auction)
                        .innerJoin(auction.art, art).fetchJoin()
                        .leftJoin(auction.user, user).fetchJoin()
                        .where(auctionIdEq(auctionId))
                        .fetchOne()
        );
    }

    private BooleanExpression auctionIdEq(Long auctionId) {
        if (Objects.isNull(auctionId)) {
            return null;
        }

        return auction.id.eq(auctionId);
    }
}
