package crudRest.converter;

import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;

/**
 *
 * @author Miguel Castro
 */
public class DozerConverter {
    
    private static Mapper maper = DozerBeanMapperBuilder.buildDefault();
    
    public static <O, D> D parseObject(O origem, Class<D> destino) {
        
        return maper.map(origem, destino);
    }
    
    public static <O, D> List<D> parseListObjects(List<O> origem, Class<D> destino) {
        
        List<D> destinoObjetos = new ArrayList<>();
        for (Object o : origem) {
            destinoObjetos.add(maper.map(o, destino));
            
        }
        return destinoObjetos;
    }
}
