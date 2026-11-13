package com.learning.coursegraph.config;

import java.util.*;
import java.time.*;
import java.math.BigDecimal;
import com.learning.coursegraph.exception.*;


/** D4: implement JWT issuer AND audience checks, scopes and ownership.
 * Use SecurityFilterChain for MVC, SecurityWebFilterChain for WebFlux.
 * This intentionally defines no permit-all filter chain. Until implemented,
 * Spring Security auto-configuration applies its defaults; those are not the target contract.
 */
@org.springframework.context.annotation.Configuration
public class SecurityConfig {
    // TODO: D4 BR-401 BR-402 principal-derived identity and explicit endpoint rules.
}
