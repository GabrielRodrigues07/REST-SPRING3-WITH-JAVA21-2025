package br.com.gabrielrodrigues07.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.List;

public interface PersonMapper {

    Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    static <O, D> List<D> parseObjects(List<O> origin, Class<D> destination) {
        return origin.stream()
                .map(o -> mapper.map(o, destination))
                .toList();
    }
}
