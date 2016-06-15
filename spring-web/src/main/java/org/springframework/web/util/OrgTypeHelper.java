package org.springframework.web.util;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by david on 16/6/14.
 */
public class OrgTypeHelper {

    private static final String DEFAULT_ORG_TYPE_DIPATCH_PATH = "system-config.properties";

    private static final Properties defaultOrgTypeDispatch;

    public static final String ORGTYPE_ATTRIBUTE = "org.type";

    static {
        try {
            ClassPathResource resourceOrgType = new ClassPathResource(DEFAULT_ORG_TYPE_DIPATCH_PATH);
            defaultOrgTypeDispatch = PropertiesLoaderUtils.loadProperties(resourceOrgType);
        }
        catch (IOException ex) {
            throw new IllegalStateException("Not load 'system-config.properties'(if you dont need orgDispatch ignore): " + ex.getMessage());
        }
    }

    public static Integer getOrgType(){
        String orgTypeString = defaultOrgTypeDispatch.getProperty(ORGTYPE_ATTRIBUTE);
        if(orgTypeString!=null){
            return Integer.valueOf(orgTypeString);
        }else{
            throw new IllegalStateException("org type is not configured in :"+DEFAULT_ORG_TYPE_DIPATCH_PATH);
        }
    }
}
