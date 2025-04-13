package org.fastcampus.common.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PositiveIntegerCounterTest {

    //증가 테스트
    @Test
    void givenCreated_whenIncrease_thenCountIsOne() {
        //given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();

        //when
        counter.increase();

        //then
        assertEquals(1, counter.getCount());
    }

    //감소 테스트
    @Test
    void givenCreated_whenIncreasedAndDecrease_thenCountIsZero() {
        //given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();
        counter.increase();

        //when
        counter.decrease();

        //then
        assertEquals(0, counter.getCount());
    }
}