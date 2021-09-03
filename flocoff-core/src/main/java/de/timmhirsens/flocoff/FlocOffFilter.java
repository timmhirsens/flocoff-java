package de.timmhirsens.flocoff;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FlocOffFilter extends HttpFilter {

	public static final String PERMISSIONS_POLICY_HEADER = "Permissions-Policy";
	public static final String INTEREST_COHORT_VALUE = "interest-cohort=()";

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		response.addHeader(PERMISSIONS_POLICY_HEADER, INTEREST_COHORT_VALUE);
		filterChain.doFilter(request, response);
	}
}
