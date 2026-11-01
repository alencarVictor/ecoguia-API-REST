package br.com.fiap.resource;

import br.com.fiap.bo.AvatarBO;
import br.com.fiap.to.AvatarTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //dizendo para o Spring que essa classe funcionara como Controller (MVC)
@RequestMapping("/avatares") //definindo endpoint
public class AvatarResource {
    private AvatarBO avatarBO = new AvatarBO();

    @GetMapping //requisicao get
    public ResponseEntity<List<AvatarTO>>findAll(){
        List<AvatarTO> avatars = avatarBO.findAll();
        if(avatars != null){
            return ResponseEntity.status(HttpStatus.OK).body(avatars);
            //configurando o retorno com status ok 200
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(avatars);
            //configurando o retorno com status not found 404
        }
    }

    @GetMapping("/{idAvatar}")
    public ResponseEntity<?>findByCodigo(@PathVariable Integer idAvatar){
        AvatarTO avatar = avatarBO.findByCodigo(idAvatar);
        if(avatar != null){
            return ResponseEntity.status(HttpStatus.OK).body(avatar);
            //configurando o retorno com status ok 200
        } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(avatar);
        //configurando o retorno com status not found 404
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid AvatarTO avatar){
        try {
            AvatarTO resultado = avatarBO.save(avatar);
            if (resultado != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
                //configurando o retorno com status created 201
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar avatar");
            //configurando o retorno com status bad request 400
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar avatar");
        }
    }

    @DeleteMapping("/{idAvatar}")
    public ResponseEntity<String> delete(@PathVariable Integer idAvatar){
        if(avatarBO.delete(idAvatar)){
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body("Avatar deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Avatar não encontrado!");
        }
    }

    @PutMapping("/{idAvatar}")
    public ResponseEntity<?> update (@PathVariable Integer idAvatar,
                                     @RequestBody @Valid AvatarTO avatar){
        try {
            if (avatarBO.findByCodigo(idAvatar) == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Avatar não encontrado!");
                //configurando o retorno com status not found 404
            }
            avatar.setIdAvatar(idAvatar);
            AvatarTO resultado = avatarBO.update(avatar);
            if (resultado != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
                //configurando o retorno com status created 201
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar o avatar");
            //configurando o retorno com status bad request 400
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao atualizar o avatar");
        }
    }


}
