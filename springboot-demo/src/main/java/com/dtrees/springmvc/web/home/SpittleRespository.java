package com.dtrees.springmvc.web.home;

import java.util.List;

/**
 * Created by keithl on 2017/9/29.
 */

public interface SpittleRespository {

    List<Spittle> findSpittles(long max, int count);
}
