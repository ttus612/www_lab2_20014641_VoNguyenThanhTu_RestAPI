package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {
    final ObjectMapper mapper = new ObjectMapper();
    public ObjectMapperContextResolver(){
        mapper.registerModule(new JavaTimeModule());
    }
    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }
}
