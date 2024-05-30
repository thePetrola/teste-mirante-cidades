package br.com.opetrola.testemirantecidades.controllers;

import br.com.opetrola.testemirantecidades.data.vo.v1.CidadeVO;
import br.com.opetrola.testemirantecidades.services.CidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cidades")
public class CidadesController {

    private final CidadeService service;

    public CidadesController(CidadeService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CidadeVO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CidadeVO findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public CidadeVO create(@RequestBody() CidadeVO cidade) {
        return service.create(cidade);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public CidadeVO update(@RequestBody() CidadeVO cidade) {
        return service.update(cidade);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") long id) {
        service.delete(id);
    }

}
