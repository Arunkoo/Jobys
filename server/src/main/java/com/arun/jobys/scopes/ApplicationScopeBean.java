package com.arun.jobys.scopes;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
@Getter @Setter
public class ApplicationScopeBean {
    private Integer visitorCount = 0;

    public ApplicationScopeBean(){
        System.out.println("Application Scope is created");
    }

    public void incrementVisitorCount(){
        visitorCount++;
    }

}
