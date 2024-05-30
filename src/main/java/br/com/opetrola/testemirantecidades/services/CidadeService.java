package br.com.opetrola.testemirantecidades.services;

import br.com.opetrola.testemirantecidades.data.vo.mapper.MapperV1;
import br.com.opetrola.testemirantecidades.data.vo.v1.CidadeVO;
import br.com.opetrola.testemirantecidades.exceptions.BadRequestException;
import br.com.opetrola.testemirantecidades.exceptions.NotFoundException;
import br.com.opetrola.testemirantecidades.models.Cidade;
import br.com.opetrola.testemirantecidades.repositories.CidadesRepository;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CidadeService implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Logger logger = Logger.getLogger(CidadeService.class.getName());

    /**
     * Define repositories
     */
    private final CidadesRepository repository;

    public CidadeService(CidadesRepository repository) {
        this.repository = repository;
    }

    /**
     * Find all cities from my Database.
     *
     * @return List<CidadeVO>
     */
    public List<CidadeVO> findAll() {
        logger.info("Getting all tb_cidades data.");

        return MapperV1.parseListObject(repository.findAll(), CidadeVO.class);
    }

    /**
     * Find city by ID.
     *
     * @return CidadeVO
     */
    public CidadeVO findById(Long id) {
        logger.info(String.format("Getting from tb_cidades with id: %d", id));

        Cidade entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        return MapperV1.parseObject(entity, CidadeVO.class);
    }

    /**
     * Create a city
     *
     * @param cidade
     * @return CidadeVO
     */
    public CidadeVO create(CidadeVO cidade) {
        logger.info("Creating row in tb_cidades");

        Cidade entity = MapperV1.parseObject(cidade, Cidade.class);
        CidadeVO vo = MapperV1.parseObject(repository.save(entity), CidadeVO.class);

        System.out.println(cidade.getNome());
        System.out.println(entity.getNome());

        return vo;
    }

    /**
     * Update city row
     *
     * @param cidade
     * @return
     */
    public CidadeVO update(CidadeVO cidade) {
        logger.info("Updating city in tb_cidades with id: " + cidade.getId());

        Cidade entity = repository.findById(cidade.getId())
                .orElseThrow(() -> new NotFoundException(cidade.getId()));

        entity.setCep(cidade.getCep());
        entity.setEstado(cidade.getEstado());
        entity.setIdh(cidade.getIdh());
        entity.setNome(cidade.getNome());
        entity.setLatitude(cidade.getLatitude());
        entity.setLongitude(cidade.getLongitude());
        entity.setPopulacao(cidade.getPopulacao());
        entity.setRendaPerCapta(cidade.getRendaPerCapta());

        return MapperV1.parseObject(repository.save(entity), CidadeVO.class);
    }

    /**
     * Delete city from DB.
     *
     * @param id
     */
    public void delete(long id) {
        logger.warning("Deleting row with id: " + id);

        Cidade entity = repository.findById(id).orElseThrow(() -> new NotFoundException(id));
        repository.delete(entity);
    }

}
