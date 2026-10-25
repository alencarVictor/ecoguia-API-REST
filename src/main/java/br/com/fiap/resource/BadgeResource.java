package br.com.fiap.resource;

import br.com.fiap.bo.BadgeBO;
import br.com.fiap.to.BadgeTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //dizendo para o Spring que essa classe funcionara como Controller (MVC)
@RequestMapping("/badges") //definindo endpoint
public class BadgeResource {
     private BadgeBO badgeBO = new BadgeBO();

    @GetMapping //requisicao get
    public ResponseEntity<List<BadgeTO>> findAll(){
        List<BadgeTO> badges = badgeBO.findAll();
        if(badges != null){
            return ResponseEntity.status(HttpStatus.OK).body(badges);
            //configurando o retorno com status ok 200
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(badges);
            //configurando o retorno com status not found 404
        }
    }

    @GetMapping("/{idBadge}")
    public ResponseEntity<?>findByCodigo(@PathVariable Integer idBadge){
        BadgeTO badge = badgeBO.findByCodigo(idBadge);
        if(badge != null){
            return ResponseEntity.status(HttpStatus.OK).body(badge);
            //configurando o retorno com status ok 200
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(badge);
            //configurando o retorno com status not found 404
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid BadgeTO badge){
        try {
            BadgeTO resultado = badgeBO.save(badge);
            return ResponseEntity.status(HttpStatus.CREATED).body(badge);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar badge");
        }
    }

    @DeleteMapping("/{idBadge}")
    public ResponseEntity<String> delete(@PathVariable Integer idBadge){
        if(badgeBO.delete(idBadge)){
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body("Badge deletada com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Badge não encontrada!");
        }
    }

    @PutMapping("/{idBadge}")
    public ResponseEntity<?> update (@PathVariable Integer idBadge,
                                     @RequestBody @Valid BadgeTO badge){
        try {
            badge.setIdBadge(idBadge);
            BadgeTO resultado = badgeBO.update(badge);
            return ResponseEntity.status(HttpStatus.CREATED).body(badge);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao atualizar o badge");
        }
    }


}
