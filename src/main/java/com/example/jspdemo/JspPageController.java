package com.example.jspdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Exposes simple JSP files with matching top-level URLs.
 *
 * <p>For example, {@code /WEB-INF/jsp/hello.jsp} is available at
 * {@code /hello.jsp}. The route deliberately accepts only a single, safe file-name
 * segment; directories and traversal characters cannot be supplied by a request.</p>
 */
@Controller
public class JspPageController {

    @GetMapping("/{pageName:[a-zA-Z0-9_-]+}.jsp")
    public String jspPage(@PathVariable String pageName) {
        return pageName;
    }
}
