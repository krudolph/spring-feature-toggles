package de.kimrudolph.features;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Adds feature toogles information to frontend model.
 */
@Component
public class FeatureToggleFilter extends OncePerRequestFilter {

    @Autowired
    FeatureToggleProperties featureToggleProperties;

    @Override
    protected void doFilterInternal(final HttpServletRequest request,
                                    final HttpServletResponse response,
                                    final FilterChain filterChain) throws ServletException, IOException {

        request.setAttribute("feature", featureToggleProperties);

        filterChain.doFilter(request, response);

    }
}
