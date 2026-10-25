package br.com.fiap.resource;

import br.com.fiap.bo.ConquistaBO;
import br.com.fiap.to.ConquistaTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conquistas")
public class ConquistaResource {
    private ConquistaBO conquistaBO = new ConquistaBO();

    @GetMapping //requisicao get
    public ResponseEntity<List<ConquistaTO>> findAll(){
        List<ConquistaTO> conquistas = conquistaBO.findAll();
        if(conquistas != null){
            return ResponseEntity.status(HttpStatus.OK).body(conquistas);
            //configurando o retorno com status ok 200
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(conquistas);
            //configurando o retorno com status not found 404
        }
    }

    @GetMapping("/{idConquista}")
    public ResponseEntity<?>findByCodigo(@PathVariable Integer idConquista){
        ConquistaTO conquista = conquistaBO.findByCodigo(idConquista);
        if(conquista  != null){
            return ResponseEntity.status(HttpStatus.OK).body(conquista );
            //configurando o retorno com status ok 200
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(conquista );
            //configurando o retorno com status not found 404
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid ConquistaTO conquista){
        try {
            ConquistaTO resultado = conquistaBO.save(conquista);
            return ResponseEntity.status(HttpStatus.CREATED).body(conquista);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar conquista");
        }
    }

    @DeleteMapping("/{idConquista}")
    public ResponseEntity<String> delete(@PathVariable Integer idConquista){
        if(conquistaBO.delete(idConquista)){
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body("Conquista deletada com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conquista não encontrada!");
        }
    }

    @PutMapping("/{idConquista}")
    public ResponseEntity<?> update (@PathVariable Integer idConquista,
                                     @RequestBody @Valid ConquistaTO conquista){
        try {
            conquista.setIdConquista(idConquista);
            ConquistaTO resultado = conquistaBO.update(conquista);
            return ResponseEntity.status(HttpStatus.CREATED).body(conquista);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao atualizar a conquista");
        }
    }
}
