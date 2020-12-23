package com.oyc.sso.util;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.validation.Assertion;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: CasUtil
 * @Description: CasUtil
 * @Author oyc
 * @Date 2020/12/21 9:32
 * @Version 1.0
 */
public class CASUtil {
    /**
     * 从cas中获取用户名
     *
     * @param request
     * @return
     */
    public static String getAccountNameFromCas(HttpServletRequest request) {
        Assertion assertion = (Assertion) request.getSession().getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION);
        if (assertion != null) {
            AttributePrincipal principal = assertion.getPrincipal();
            return principal.getName();
        } else {
            return null;
        }
    }
}