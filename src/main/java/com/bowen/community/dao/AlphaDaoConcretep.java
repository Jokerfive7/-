package com.bowen.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
//primary表示在同一接口下优先索引该bean
public class AlphaDaoConcretep implements AlphaDao{
    @Override
    public String select() {
        return "Hello";
    }
}
