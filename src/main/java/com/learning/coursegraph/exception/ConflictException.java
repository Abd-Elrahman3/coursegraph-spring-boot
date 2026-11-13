package com.learning.coursegraph.exception;

import java.util.*;
import java.time.*;
import java.math.BigDecimal;
import com.learning.coursegraph.exception.*;


public class ConflictException extends RuntimeException {
    public ConflictException(String message) { super(message); }
}
