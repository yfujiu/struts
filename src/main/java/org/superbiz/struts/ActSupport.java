package org.superbiz.struts;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Component;

@Component
public class ActSupport extends ActionSupport {
    private final UserService userService;

    public ActSupport(UserService userService) {
        this.userService = userService;
    }
}
