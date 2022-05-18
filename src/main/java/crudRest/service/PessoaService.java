package crudRest.service;

import crudRest.converter.DozerConverter;
import crudRest.model.PessoaModel;
import crudRest.modelVO.PessoaModelVO;
import crudRest.repository.PessoaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Castro
 */
@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public PessoaModelVO inserir(PessoaModelVO pessoaModelVO) {

        var pessoaModel = DozerConverter.parseObject(pessoaModelVO, PessoaModel.class);
        var vo = DozerConverter.parseObject(pessoaRepository.save(pessoaModel), PessoaModelVO.class);
        
        return vo;
    }

    public PessoaModelVO alterar(Long id, PessoaModelVO pessoaModelVO) {

        var pessoaModel = pessoaRepository.getById(pessoaModelVO.getId());
        pessoaModel.setNome(pessoaModelVO.getNome());
        pessoaModel.setEmail(pessoaModelVO.getEmail());
        var vo = DozerConverter.parseObject(pessoaRepository.save(pessoaModel), PessoaModelVO.class);
        
        return vo;
    }

    public List<PessoaModelVO> listar() {

        return DozerConverter.parseListObjects(pessoaRepository.findAll(), PessoaModelVO.class);
    }

    public PessoaModelVO buscar(Long id) {

        var pessoaModel = pessoaRepository.findById(id).orElseThrow();
        return DozerConverter.parseObject(pessoaModel, PessoaModelVO.class);
    }

    public void deletar(Long id) {

        pessoaRepository.deleteById(id);
    }
}
