package com.learning.coursegraph.config;

import java.util.*;
import java.time.*;
import java.math.BigDecimal;
import com.learning.coursegraph.exception.*;


@org.springframework.context.annotation.Configuration
public class TimeConfig {
    @org.springframework.context.annotation.Bean
    public Clock clock() { return Clock.systemUTC(); }
}
