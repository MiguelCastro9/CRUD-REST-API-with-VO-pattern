package crudRest.controller;

import crudRest.modelVO.PessoaModelVO;
import crudRest.service.PessoaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Miguel Castro
 */
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @PostMapping(value = "/insere", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PessoaModelVO insere(@RequestBody PessoaModelVO pessoaModelVO) {

        return pessoaService.inserir(pessoaModelVO);
    }

    @PutMapping(value = "/altera/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PessoaModelVO altera(@PathVariable("id") Long id, @RequestBody PessoaModelVO pessoaModelVO) {

        return pessoaService.alterar(id, pessoaModelVO);
    }

    @GetMapping(value = "/lista", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PessoaModelVO> lista() {

        return pessoaService.listar();
    }

    @GetMapping(value = "/busca/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PessoaModelVO busca(@PathVariable("id") Long id) {

        return pessoaService.buscar(id);
    }

    @DeleteMapping("/deleta/{id}")
    public void deleta(@PathVariable("id") Long id) {

        pessoaService.deletar(id);
    }
}
